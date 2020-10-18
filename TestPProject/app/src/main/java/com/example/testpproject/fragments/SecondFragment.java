package com.example.testpproject.fragments;


import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.example.testpproject.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SecondFragment extends Fragment {

    private View mView;

    private ImageView mImageView;


    public SecondFragment() {
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Log.e("========", "SecondFragment:onAttach");


    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e("========", "SecondFragment:onCreate");
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_second, container, false);
        Bundle bundle = getArguments();
        Log.e("========", "SecondFragment:onCreateView执行");
        Log.e("====", bundle.getString("han", "无数据"));
        Log.e("====", bundle.getString("qi", "无数据"));
        return mView;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.e("========", "SecondFragment:onActivityCreated");

        mImageView = (ImageView) mView.findViewById(R.id.images);
        mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (null != mCallBack) {
                    mCallBack.callBack(1000);
                }

                Button button = getActivity().findViewById(R.id.frag);
                button.setText("改变Activity中的数据");
            }
        });

    }

    @Override
    public void onStart() {
        super.onStart();
        Log.e("========", "SecondFragment:onStart");

    }

    @Override
    public void onResume() {
        super.onResume();
        Log.e("========", "SecondFragment:onResume");

    }

    @Override
    public void onPause() {
        super.onPause();
        Log.e("========", "SecondFragment:onPause");

    }

    @Override
    public void onStop() {
        super.onStop();
        Log.e("========", "SecondFragment:onStop");

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.e("========", "SecondFragment:onDestroyView");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e("========", "SecondFragment:onDestroy");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.e("========", "SecondFragment:onDetach");
    }

    private ICallBack mCallBack;

    public void setmCallBack(ICallBack callBack) {
        this.mCallBack = callBack;
    }

    public interface ICallBack {

        void callBack(int i);
    }


    public void test() {

        Log.e("====", "SecondFragment执行了");
    }

}
