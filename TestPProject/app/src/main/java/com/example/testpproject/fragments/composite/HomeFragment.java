package com.example.testpproject.fragments.composite;


import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.testpproject.R;
import com.example.testpproject.fragments.composite.livedata.FragmentLivedata;

import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


public class HomeFragment extends Fragment {


    View mView;

    @BindView(R.id.homeFragment_txt)
    TextView homeFragmentTxt;
    @BindView(R.id.homeFragment_btn)
    Button homeFragmentBtn;

    public HomeFragment() {
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Log.e("======", "HomeFragment onAttach ");
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e("======", "HomeFragment onCreate ");
    }

    Unbinder unbinder;
    FragmentLivedata livedata;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        mView = inflater.inflate(R.layout.fragment_home, container, false);

        unbinder = ButterKnife.bind(this, mView);

        Log.e("======", "HomeFragment onCreateView ");

        livedata = new ViewModelProvider(getActivity()).get(FragmentLivedata.class);

        Log.e("======", livedata.hashCode() + "");

        livedata.getIntegerMutableLiveData().observe(getActivity(), (Integer str) -> {
            Log.e("======", String.valueOf(str));
            homeFragmentTxt.setText(String.valueOf(str));
        });


        homeFragmentTxt.setOnClickListener((View view) -> {
            mCallBack.callBack(new Random().nextInt(10));

        });

        return mView;
    }

    @OnClick(R.id.homeFragment_btn)
    public void onViewClicked() {

        livedata.getMutableLiveData().setValue(new Random().nextInt(100) + "");

    }


    @Override
    public void onStart() {
        super.onStart();
        Log.e("======", "HomeFragment onStart ");
    }

    @Override
    public void onResume() {
        super.onResume();

        Log.e("======", "HomeFragment onResume ");
    }

    @Override
    public void onStop() {
        super.onStop();

        Log.e("======", "HomeFragment onStop ");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
        Log.e("======", "HomeFragment onDestroyView ");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        Log.e("======", "HomeFragment onDestroy ");
    }


    private ICallBack mCallBack;

    public void setmCallBack(ICallBack callBack) {
        this.mCallBack = callBack;
    }


    public interface ICallBack {

        void callBack(int i);
    }

}
