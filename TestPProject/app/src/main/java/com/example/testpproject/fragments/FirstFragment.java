package com.example.testpproject.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.testpproject.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


public class FirstFragment extends Fragment {

    @BindView(R.id.btn)
    Button mBtn;
    private View mView;

    public FirstFragment() {
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        Log.e("=====FirstFragment", "attach" + context + "");

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.e("=====FirstFragment", "onCreate");
    }

    Unbinder unbinder;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        mView = inflater.inflate(R.layout.fragment_first, container, false);
        Log.e("=====FirstFragment", "onCreateView");

        unbinder = ButterKnife.bind(this, mView);

        Bundle bundle = getArguments();
        if (bundle != null) {
            String bundleString = bundle.getString("test", "无");
            Log.e("=====", bundleString);
        }

        return mView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Log.e("=====FirstFragment", "onActivityCreated");
        mBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getActivity(), "btn", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent();
                intent.setClass(getActivity(), Viewpager2Activity.class);
                startActivity(intent);

            }
        });

    }


    @Override
    public void onStart() {
        super.onStart();
        Log.e("=====FirstFragment", "onStart");
    }


    @Override
    public void onResume() {
        super.onResume();
        Log.e("=====FirstFragment", "onResume");

        Log.e("======getActivity", getActivity() + "");
        Log.e("======getContext", getContext() + "");
    }


    @Override
    public void onPause() {
        super.onPause();
        Log.e("=====FirstFragment", "onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.e("=====FirstFragment", "onStop");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
        Log.e("=====FirstFragment", "onDestroyView");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e("=====FirstFragment", "onDestroy");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.e("=====FirstFragment", "onDetach");
    }

    public void test() {
        Log.e("=====", "FirstFragment中的方法");

        Bundle bundle = getArguments();
        String bundleString = bundle.getString("test", "无");
        Log.e("=====", bundleString);
    }


}
