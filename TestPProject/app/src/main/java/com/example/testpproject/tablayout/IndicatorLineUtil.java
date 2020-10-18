package com.example.testpproject.tablayout;

import android.content.Context;
import android.content.res.Resources;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.LinearLayout;

import com.google.android.material.tabs.TabLayout;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class IndicatorLineUtil {

    private static class SingletonHolder {

        private static final IndicatorLineUtil indicatorLineUtil = new IndicatorLineUtil();
    }

    public static IndicatorLineUtil getInstance() {

        return SingletonHolder.indicatorLineUtil;
    }


    /**
     * 调节tablayout指示线宽度
     *
     * @param tabs
     * @param leftDip
     * @param rightDip
     */
    public void setIndicator(TabLayout tabs, int leftDip, int rightDip) {
        Class<?> tabLayout = tabs.getClass();
        Object slidingTabIndicator;
        try {
            Field tabLayoutDeclaredField = tabLayout.getDeclaredField("slidingTabIndicator");
            tabLayoutDeclaredField.setAccessible(true);
            slidingTabIndicator = tabLayoutDeclaredField.get(tabs);
            Class<?> slidingTabIndicatorClass = slidingTabIndicator.getClass();
            Method method = slidingTabIndicatorClass.getDeclaredMethod("setIndicatorPosition", int.class, int.class);

            Log.e("======", method.getName());
            method.setAccessible(true);
            method.invoke(slidingTabIndicator, leftDip, rightDip);
        } catch (Exception e) {
            e.printStackTrace();
        }

       /* for (Class<?> layoutClass : layoutClasses) {


            if (layoutClass.getSimpleName().equals("SlidingTabIndicator")) {
//                Log.e("======", layoutClass.getSimpleName());
                Method method = null;
                try {

                    method = layoutClass.getDeclaredMethod("setIndicatorPosition", int.class, int.class);

                    method.setAccessible(true);

//                    Constructor<?> constructor = layoutClass.getConstructor(Context.class);

//                    constructor.setAccessible(true);

//                    Object instance = constructor.newInstance(context);

//                    Log.e("======", instance.getClass().getSimpleName());

                    method.invoke(slidingTabIndicator, leftDip, rightDip);

                } catch (Exception e) {
                    e.printStackTrace();

                }

            }
        }*/


    }
}