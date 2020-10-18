package com.example.testpproject.fragments.composite;


import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.testpproject.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyFragment extends Fragment {


    public MyFragment() {
        // Required empty public constructor
    }


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Log.e("======", "MyFragment onAttach ");
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e("======", "MyFragment onCreate ");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        Log.e("======", "MyFragment onCreateView ");
        return inflater.inflate(R.layout.fragment_my, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.e("======", "MyFragment onStart ");
    }

    @Override
    public void onResume() {
        super.onResume();

        Log.e("======", "MyFragment onResume ");
    }

    @Override
    public void onStop() {
        super.onStop();

        Log.e("======", "MyFragment onStop ");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        Log.e("======", "MyFragment onDestroyView ");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        Log.e("======", "DiscoverFragment onDestroy ");
    }

}
