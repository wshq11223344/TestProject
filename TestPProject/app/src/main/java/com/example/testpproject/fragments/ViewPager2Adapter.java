package com.example.testpproject.fragments;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testpproject.R;

import java.util.List;

public class ViewPager2Adapter extends RecyclerView.Adapter<ViewPager2Adapter.ViewHolder> {

    private Context context;
    private List<Integer> list;

    public ViewPager2Adapter(Context context, List<Integer> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

//        View view = View.inflate(context, R.layout.viewpager_layout, null);
        View view = LayoutInflater.from(context).inflate(R.layout.viewpager_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.mImageview.setImageResource(list.get(position));

        holder.context = context;

        holder.position = position;
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView mImageview;
        Context context;
        int position;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            mImageview = itemView.findViewById(R.id.image_iv);

            mImageview.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

//                    Toast.makeText(context, position+"", Toast.LENGTH_SHORT).show();
                    onItemClistListener.onItemClick(position);

                }
            });
        }
    }


    private OnItemClickListener onItemClistListener;

    public interface OnItemClickListener {
        void onItemClick(int postion);
    }

    public void setOnItemClistListener(OnItemClickListener itemClistListener) {
        this.onItemClistListener = itemClistListener;
    }

}
