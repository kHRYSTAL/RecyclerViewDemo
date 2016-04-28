package me.khrystal.recyclerviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private SimpleAdapter mAdapter;
    private ArrayList<String> mDataList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        LinearLayoutManager manager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        mRecyclerView.setLayoutManager(manager);
        mDataList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            mDataList.add("index:" + i);
        }

        mAdapter = new SimpleAdapter(this,mDataList);
        mAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(Object data, View view, int position) {
                switch (view.getId()){
                    case R.id.item_button:
                        Toast.makeText(MainActivity.this,"clickbutton:"+position,Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.item_text:
                        Toast.makeText(MainActivity.this,"clicktext:"+data,Toast.LENGTH_SHORT).show();
                        break;
                }
            }

            @Override
            public void onItemLongClick(Object data, View view, int position) {
                //nothing todo
            }
        });

        mRecyclerView.setAdapter(mAdapter);
    }

}
