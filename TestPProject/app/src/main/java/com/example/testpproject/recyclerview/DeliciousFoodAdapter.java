package com.example.testpproject.recyclerview;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.testpproject.R;

import java.util.List;

public class DeliciousFoodAdapter extends RecyclerView.Adapter<DeliciousFoodAdapter.DeliciousFoodVH> {

    private List<DeliciousFoodModel> mDeliciousFoodList;
    private Context mContext;

    public DeliciousFoodAdapter(Context ctx, List<DeliciousFoodModel> deliciousFoodList) {
        mDeliciousFoodList = deliciousFoodList;
        mContext = ctx;
    }

    @Override
    public int getItemCount() {
        if (null == mDeliciousFoodList) {
            return 0;
        }
        return mDeliciousFoodList.size();
    }

    /**
     * 为控件填充内容
     */
    @Override
    public void onBindViewHolder(DeliciousFoodVH viewHolder, int position) {


        Log.e("DeliciousFoodVH", "viewHolder = " + viewHolder.mPosition);
        Log.e("DeliciousFoodVH", "onBindViewHolder真实position = " + position);


//		viewHolder.mContext = mContext;
        Glide.with(mContext)
                .load(mDeliciousFoodList.get(position).foodImg)
                .placeholder(R.mipmap.head_icon1)
                .error(R.mipmap.head_icon1)
                .into(viewHolder.mUrlImage);


        viewHolder.mNameText.setText(mDeliciousFoodList.get(position).foodName);
        viewHolder.mDescTest.setText(mDeliciousFoodList.get(position).foodDesc);
        viewHolder.mPosition = position;
    }

    @Override
    public DeliciousFoodVH onCreateViewHolder(ViewGroup parent, int position) {
//		 View view = LayoutInflater.from(parent.getContext()).inflate(
//		 R.layout.water_fall_item, parent, false);

        Log.e("DeliciousFoodVH", "onCreateViewHolder = " + position);
        View view = View.inflate(parent.getContext(), R.layout.water_fall_item, null);
        return new DeliciousFoodVH(view);


    }


    public class DeliciousFoodVH extends RecyclerView.ViewHolder {

        ImageView mUrlImage;
        TextView mNameText;
        TextView mDescTest;
        int mPosition;

//		public Context mContext;


        public DeliciousFoodVH(View itemView) {
            super(itemView);
            mUrlImage = (ImageView) itemView.findViewById(R.id.item_img);
            mNameText = (TextView) itemView.findViewById(R.id.item_title);
            mDescTest = (TextView) itemView.findViewById(R.id.item_desc);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (null != onItemClistListener) {
                        onItemClistListener.onItemClick(mPosition);
                    }
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
