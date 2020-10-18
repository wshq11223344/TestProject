package com.example.testpproject.recyclerview.vlayout;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.example.testpproject.R;

import java.util.ArrayList;
import java.util.HashMap;

public class VlayoutAdapter extends DelegateAdapter.Adapter<VlayoutAdapter.MainViewHolder> {

    // 数据源
    private ArrayList<HashMap<String, Object>> listItem;
    //上下文
    private Context context;
    //数据总数量
    private int count = 0;
    //layoutHelper对象
    LayoutHelper layoutHelper;


    public VlayoutAdapter(Context context, LayoutHelper layoutHelper,int count,
                     ArrayList<HashMap<String, Object>> listItem){
        this.context = context;
        this.layoutHelper = layoutHelper;
        this.count = count;
        this.listItem = listItem;
    }


    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return layoutHelper;
    }

    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int position) {
        return new MainViewHolder(LayoutInflater.from(context).inflate(R.layout.items,parent,false));

    }

    @Override
    public void onBindViewHolder(@NonNull MainViewHolder viewHolder, int position) {

        viewHolder.Text.setText((String) listItem.get(position).get("ItemTitle"));
        viewHolder.image.setImageResource((Integer) listItem.get(position).get("ItemImage"));

    }

    @Override
    public int getItemCount() {
        return count;
    }

    class MainViewHolder extends RecyclerView.ViewHolder {

        public TextView Text;
        public ImageView image;

        public MainViewHolder(View root) {
            super(root);
            // 绑定视图
            Text = (TextView) root.findViewById(R.id.Item);
            image = (ImageView) root.findViewById(R.id.Image);
        }


    }

}
