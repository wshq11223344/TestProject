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
import com.example.testpproject.fragments.composite.livedata.User;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class ContactFragment extends Fragment {

    View mView;
    @BindView(R.id.contact_btn)
    Button contactBtn;
    @BindView(R.id.contact_txt)
    TextView contactTxt;


    public ContactFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Log.e("======", "ContactFragment onAttach ");
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e("======", "ContactFragment onCreate ");
    }

    Unbinder bind;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        Log.e("======", "ContactFragment onCreateView ");

        mView = inflater.inflate(R.layout.fragment_contact, container, false);

        bind = ButterKnife.bind(this, mView);

        livedata = new ViewModelProvider(getActivity()).get(FragmentLivedata.class);

        livedata.getMutableLiveData().observe(getActivity(), (String str) -> {

            contactTxt.setText(str);

        });

        return mView;
    }

    FragmentLivedata livedata;

    @OnClick(R.id.contact_btn)
    public void onViewClicked() {
        livedata.getUserMutableLiveData().setValue(new User("qiqi", "男", 27));

    }


    @Override
    public void onStart() {
        super.onStart();
        Log.e("======", "ContactFragment onStart ");
    }

    @Override
    public void onResume() {
        super.onResume();

        Log.e("======", "ContactFragment onResume ");
    }

    @Override
    public void onStop() {
        super.onStop();

        Log.e("======", "ContactFragment onStop ");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        bind.unbind();
        Log.e("======", "ContactFragment onDestroyView ");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        Log.e("======", "ContactFragment onDestroy ");
    }


}
