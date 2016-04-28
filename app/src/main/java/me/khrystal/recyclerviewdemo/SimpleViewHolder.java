package me.khrystal.recyclerviewdemo;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * @FileName: me.khrystal.recyclerviewdemo.SimpleViewHolder.java
 * @Fuction:
 * @author: kHRYSTAL
 * @email: 723526676@qq.com
 * @date: 2016-03-04 09:57
 * @UpdateUser:
 * @UpdateDate:
 */
public class SimpleViewHolder extends BaseViewHolder{

    public Button mItemButton;
    public TextView mItemText;

    private Context mContext;
    private String mString;

    public SimpleViewHolder(View itemView, Object parent) {
        super(itemView, parent);
        mContext = itemView.getContext();
        mItemButton = (Button)itemView.findViewById(R.id.item_button);
        mItemText = (TextView)itemView.findViewById(R.id.item_text);
    }

    public void bind(String item){
        if (TextUtils.isEmpty(item))
            return;
        mString = item;
        mItemButton.setText(item);
        mItemText.setText(item);
    }
}
