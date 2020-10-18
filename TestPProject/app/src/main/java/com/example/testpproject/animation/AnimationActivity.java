package com.example.testpproject.animation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityOptionsCompat;
import androidx.dynamicanimation.animation.DynamicAnimation;
import androidx.dynamicanimation.animation.SpringAnimation;

import com.example.testpproject.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AnimationActivity extends AppCompatActivity {

    ValueAnimator valueAnimator;

    @BindView(R.id.txt)
    TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);
        ButterKnife.bind(this);

        valueAnimator = ValueAnimator.ofFloat(0, 1f);

        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {

                float animatedValue = (float) animation.getAnimatedValue();
                Log.e("======", animatedValue + "");

            }
        });
        valueAnimator.setDuration(2000);
//        valueAnimator.setStartDelay(2000);
//        valueAnimator.setRepeatCount(ValueAnimator.INFINITE);
//        valueAnimator.setRepeatMode(ValueAnimator.RESTART);
//        valueAnimator.start();

    }

    @Override
    protected void onStart() {
        super.onStart();

//        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(txt, "alpha", 1f, 0, 1f);
//        objectAnimator.setDuration(5000);
//        objectAnimator.start();
//        objectAnimator.setRepeatCount(ObjectAnimator.INFINITE);

        ObjectAnimator animator = ObjectAnimator.ofFloat(txt, "rotation", -90f, 0f);
        txt.setPivotX(0);
        txt.setPivotY(0);
        animator.setInterpolator(new BounceInterpolator());
        animator.setDuration(5000);
//        animator.start();


//        ObjectAnimator animator = ObjectAnimator.ofFloat(txt, "translationX", 450f, -450f);
//        animator.setDuration(3000);
//        animator.setRepeatCount(ObjectAnimator.INFINITE);
//        animator.start();

        txt.post(new Runnable() {
            @Override
            public void run() {

                float curTranslationX = txt.getX();
                Log.e("====", curTranslationX + "");
                Log.e("====", txt.getY() + "");
                DisplayMetrics dm = getResources().getDisplayMetrics();
                int height = dm.heightPixels;
                int width = dm.widthPixels;
//                Log.e("====", height + "");
//                Log.e("====", width + "");
//                Log.e("====", dm.density + "");
//                Log.e("====", dm.densityDpi + "");
                Log.e("====", txt.getWidth() + "");
                Log.e("====", txt.getHeight() + "");
                ObjectAnimator animator = ObjectAnimator.ofFloat(txt, "translationY", (float) (-height / 2 + txt.getHeight()), (float) (height / 2 - txt.getHeight()));
                animator.setDuration(3000);
//        animator.setRepeatCount(ObjectAnimator.INFINITE);
//                animator.setInterpolator(new AccelerateInterpolator(10));
//                animator.setInterpolator(new DecelerateInterpolator());
//                animator.setInterpolator(new AccelerateDecelerateInterpolator());
//                animator.setInterpolator(new AnticipateInterpolator());
//                animator.setInterpolator(new BounceInterpolator());
//                animator.setInterpolator(new LinearInterpolator());
//                animator.setInterpolator(new OvershootInterpolator());
//                animator.start();

            }
        });


//        ObjectAnimator animator = ObjectAnimator.ofFloat(txt, "scaleY", 1f, 3f, 1f);
//        animator.setDuration(5000);
//        animator.start();


//        ObjectAnimator moveIn = ObjectAnimator.ofFloat(txt, "translationX", -500f, 0f);
//        ObjectAnimator rotate = ObjectAnimator.ofFloat(txt, "rotation", 0f, 360f);
//        ObjectAnimator fadeInOut = ObjectAnimator.ofFloat(txt, "alpha", 1f, 0f, 1f);
        AnimatorSet animSet = new AnimatorSet();
//        animSet.play(rotate).with(fadeInOut).after(moveIn);
//        animSet.setDuration(5000);
//        animSet.start();


        PropertyValuesHolder pvhX = PropertyValuesHolder.ofFloat("alpha", 1f, 0f, 1f);
        PropertyValuesHolder pvhY = PropertyValuesHolder.ofFloat("scaleX", 1f, 0, 1f);
        PropertyValuesHolder pvhZ = PropertyValuesHolder.ofFloat("scaleY", 1f, 0, 1f);
        ObjectAnimator objectAnimator = ObjectAnimator.ofPropertyValuesHolder(txt, pvhX, pvhY, pvhZ);
        objectAnimator.setDuration(5000);
//        objectAnimator.start();

        objectAnimator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
            }
        });


//        弹簧动画
        SpringAnimation anim1X = new SpringAnimation(txt, DynamicAnimation.TRANSLATION_X, 0);
        SpringAnimation anim1Y = new SpringAnimation(txt, DynamicAnimation.TRANSLATION_Y, 0);

        anim1X.addUpdateListener(new DynamicAnimation.OnAnimationUpdateListener() {
            @Override
            public void onAnimationUpdate(DynamicAnimation animation, float value, float velocity) {


            }
        });

        txt.postDelayed(() -> {

//            startActivity(new Intent(AnimationActivity.this, SecondActivity.class));

//            startActivity(new Intent(AnimationActivity.this, SecondActivity.class), ActivityOptions.makeSceneTransitionAnimation(this).toBundle());

            String transitionName = getString(R.string.transition);

            ActivityOptions transitionActivityOptions = ActivityOptions.makeSceneTransitionAnimation(AnimationActivity.this, txt, transitionName);

            // version may be lower than Android 5.0
//            ActivityOptionsCompat transitionActivityOptions = ActivityOptionsCompat.makeSceneTransitionAnimation(AnimationActivity.this, txt, transitionName);

            startActivity((new Intent(AnimationActivity.this, SecondActivity.class)), transitionActivityOptions.toBundle());


        }, 2000);


    }

    @Override
    protected void onStop() {
        super.onStop();

        valueAnimator.cancel();


    }
}
