package com.example.testpproject.dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MyDialogFragment extends DialogFragment {

    private DialogInterface.OnClickListener positiveCallback;

    private DialogInterface.OnClickListener negativeCallback;

    private String title;

    private String message;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        Log.e("======", "onCreateView");
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        Log.e("======", "onCreateDialog");

        AlertDialog dialog = new AlertDialog.Builder(getActivity())
                .setTitle("神灯")
                .setMessage("来选择你要实现的一个愿望把")
                .setPositiveButton("车子", positiveCallback)
                .setNegativeButton("房子", negativeCallback).create();
        return dialog;
    }

    public void show(String title, String message, DialogInterface.OnClickListener positiveCallback,
                     DialogInterface.OnClickListener negativeCallback, FragmentManager fragmentManager) {
        this.title = title;
        this.message = message;
        this.positiveCallback = positiveCallback;
        this.negativeCallback = negativeCallback;
        show(fragmentManager, "");
    }
}
