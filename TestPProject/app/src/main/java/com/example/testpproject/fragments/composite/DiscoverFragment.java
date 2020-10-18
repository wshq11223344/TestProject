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
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.testpproject.R;
import com.example.testpproject.fragments.composite.livedata.FragmentLivedata;

import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class DiscoverFragment extends Fragment {

    View mView;
    @BindView(R.id.discover_fragment_btn)
    Button mBtn;
    @BindView(R.id.discover_fragment_txt)
    TextView mTxt;

    public DiscoverFragment() {
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Log.e("======", "DiscoverFragment onAttach ");
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e("======", "DiscoverFragment onCreate ");
    }

    private Unbinder unbinder;
    private FragmentLivedata livedata;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        Log.e("======", "DiscoverFragment onCreateView ");
        mView = inflater.inflate(R.layout.fragment_discover, container, false);

        unbinder = ButterKnife.bind(this, mView);

        livedata = new ViewModelProvider(getActivity()).get(FragmentLivedata.class);
        Log.e("======", livedata.hashCode() + "");

        livedata.getMutableLiveData().observe(getActivity(), (String str) -> {
            Log.e("======", str);
            mTxt.setText(str);

        });

        return mView;
    }

    @OnClick(R.id.discover_fragment_btn)
    public void onViewClicked() {
        livedata.getIntegerMutableLiveData().setValue(new Random().nextInt(100));

    }


    @Override
    public void onStart() {
        super.onStart();
        Log.e("======", "DiscoverFragment onStart ");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.e("======", "DiscoverFragment onResume ");
        Bundle bundle = getArguments();
        if (bundle != null) {
            String bundleString = bundle.getString("123");
            Log.e("======", bundleString);
            Log.e("======", "DiscoverFragment onResume ");
        }

    }

    @Override
    public void onStop() {
        super.onStop();

        Log.e("======", "DiscoverFragment onStop ");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        unbinder.unbind();
        Log.e("======", "DiscoverFragment onDestroyView ");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        Log.e("======", "DiscoverFragment onDestroy ");
    }


    public void test() {
        Bundle bundle = getArguments();
        String bundleString = bundle.getString("123");
        Log.e("======", bundleString);

    }


}
