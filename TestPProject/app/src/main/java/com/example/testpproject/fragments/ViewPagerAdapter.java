package com.example.testpproject.fragments;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.testpproject.R;

import java.util.List;

public class ViewPagerAdapter extends PagerAdapter {

    private Context context;
    private List<Integer> list;


    public ViewPagerAdapter(Context context, List<Integer> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

//        ImageView iv = new ImageView(context);
//        iv.setScaleType(ImageView.ScaleType.FIT_XY);
//        iv.setImageResource(list.get(position));
//        container.addView(iv);

//        View inflate = LayoutInflater.from(context).inflate(R.layout.viewpager_layout, null);
        View view = View.inflate(context, R.layout.viewpager_layout, null);

        ImageView imageView = view.findViewById(R.id.image_iv);

        imageView.setImageResource(list.get(position));

        container.addView(view);

//        Log.e("=====instantiateItem==", position + "");
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {

        container.removeView((View) object);
//        Log.e("=====destroyItem==", position + "");
    }
}
