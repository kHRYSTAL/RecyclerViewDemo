package me.khrystal.recyclerviewdemo;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * @FileName: me.khrystal.recyclerviewdemo.SimpleAdapter.java
 * @Fuction:
 * @author: kHRYSTAL
 * @email: 723526676@qq.com
 * @date: 2016-03-04 09:56
 * @UpdateUser:
 * @UpdateDate:
 */
public class SimpleAdapter extends RecyclerView.Adapter<SimpleViewHolder> {

    List<String> dataList;
    Object parent;


    public SimpleAdapter(Object parent, List<String> dataList) {
        this.dataList = dataList;
        this.parent = parent;
    }

    @Override
    public SimpleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);
        final SimpleViewHolder holder = new SimpleViewHolder(v, parent);
        // TODO: 16/4/28
        if (mClickListener != null) {
            holder.mItemButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mClickListener.onItemClick(dataList.get(holder.getLayoutPosition()),v, holder.getLayoutPosition());
                }
            });
            holder.mItemText.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mClickListener.onItemClick(dataList.get(holder.getLayoutPosition()),v,holder.getLayoutPosition());
                }
            });
        }
        return holder;
    }

    @Override
    public void onBindViewHolder(SimpleViewHolder holder, int position) {
        String item = dataList.get(position);
        holder.bind(item);
    }

    public void append(String[] items) {
        int pos = dataList.size();
        for (String item : items) {
            if (!dataList.contains(item))
                dataList.add(item);
        }
        notifyItemRangeInserted(pos, items.length);
    }

    public void append(List<String> items){
        int pos = dataList.size();
        for (String item : items){
            if (!dataList.contains(item))
                dataList.add(item);
        }
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public void remove(int position) {
        if (dataList.size() > 0) {
            dataList.remove(position);
            this.notifyItemRemoved(position);
        }
    }

    public void clear() {
        int size = dataList.size();
        dataList.clear();
        this.notifyItemRangeRemoved(0, size);
    }

    // TODO: 16/4/28
    protected OnItemClickListener mClickListener;

    public void setOnItemClickListener(OnItemClickListener listener) {
        mClickListener = listener;
    }
}
