package com.example.testpproject.hotrepair.utils;

import android.content.Context;
import android.widget.Toast;

public class Calculator {
    public void calculate(Context context){
        int a = 666;
        int b = 0;
        Toast.makeText(context, "calculate >>> " + a / b, Toast.LENGTH_SHORT).show();
    }
}
