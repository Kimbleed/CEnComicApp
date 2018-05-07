package com.example.a49479.cencomicapp.utils;

import android.animation.ValueAnimator;
import android.content.Context;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;

import com.example.a49479.cencomicapp.R;


/**
 * Created by 49479 on 2017/8/14.
 *
 * 动画工具类
 *
 */

public class AnimUtil {

    public static final int INTERPOLATOR_ACC = 1;
    public static final int INTERPOLATOR_DEC = 2;
    public static final int INTERPOLATOR_AND = 3;
    public static final int INTERPOLATOR_LIN = 4;

    public interface AnimEndListener{
        void animEnd();
    }

    public static ValueAnimator getValueAnimatorOfFloat(float[] nums, int duration, int repeatCount, int repeatMode, int interpolator, ValueAnimator.AnimatorUpdateListener listener){
        ValueAnimator valueAnimatorScale = new ValueAnimator().ofFloat(nums);
        valueAnimatorScale.setDuration(duration);
        if(repeatCount != 0) {
            valueAnimatorScale.setRepeatCount(repeatCount);
            valueAnimatorScale.setRepeatMode(repeatMode);
        }
        switch (interpolator){
            case INTERPOLATOR_ACC:
                valueAnimatorScale.setInterpolator(new AccelerateInterpolator());
                break;
            case INTERPOLATOR_DEC:
                valueAnimatorScale.setInterpolator(new DecelerateInterpolator());
                break;
            case INTERPOLATOR_AND:
                valueAnimatorScale.setInterpolator(new AccelerateDecelerateInterpolator());
                break;
            case INTERPOLATOR_LIN:
                valueAnimatorScale.setInterpolator(new LinearInterpolator());
                break;
        }
        valueAnimatorScale.addUpdateListener(listener);
        return valueAnimatorScale;
    }

    public static ValueAnimator getValueAnimatorOfInt(int[] nums, int duration, int repeatCount, int repeatMode, int interpolator, ValueAnimator.AnimatorUpdateListener listener){
        ValueAnimator valueAnimatorScale = new ValueAnimator().ofInt(nums);
        valueAnimatorScale.setDuration(duration);
        if(repeatCount != 0) {
            valueAnimatorScale.setRepeatCount(repeatCount);
            valueAnimatorScale.setRepeatMode(repeatMode);
        }
        switch (interpolator){
            case INTERPOLATOR_ACC:
                valueAnimatorScale.setInterpolator(new AccelerateInterpolator());
                break;
            case INTERPOLATOR_DEC:
                valueAnimatorScale.setInterpolator(new DecelerateInterpolator());
                break;
            case INTERPOLATOR_AND:
                valueAnimatorScale.setInterpolator(new AccelerateDecelerateInterpolator());
                break;
            case INTERPOLATOR_LIN:
                valueAnimatorScale.setInterpolator(new LinearInterpolator());
                break;
        }
        if(listener!=null)
            valueAnimatorScale.addUpdateListener(listener);
        return valueAnimatorScale;
    }

    public static RotateAnimation getRotateAnimation(int startDegree, int endDegree, int duration, View view){
        RotateAnimation anim = new RotateAnimation(startDegree,endDegree,view.getMeasuredWidth()/2,view.getMeasuredHeight()/2);
        anim.setDuration(duration);
        anim.setInterpolator(new AccelerateDecelerateInterpolator());
        anim.setRepeatCount(-1);
        return anim;
    }


    public static void animLayoutBottom(Context context, final boolean isToVisible, final View layout_bg, final View layout_main){
        Animation animSlide = null;
        Animation animAlpha = null;
        if (isToVisible) {
            animSlide = AnimationUtils.loadAnimation(context, R.anim.slide_in_bottom);
            animAlpha = AnimationUtils.loadAnimation(context, R.anim.alpha_in);
        } else {
            animSlide = AnimationUtils.loadAnimation(context, R.anim.slide_out_bottom);
            animAlpha = AnimationUtils.loadAnimation(context, R.anim.alpha_out);
        }
        animSlide.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                layout_main.setVisibility(View.VISIBLE);
                layout_bg.setVisibility(View.VISIBLE);
                layout_main.setClickable(false);
                layout_bg.setClickable(false);

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                if (!isToVisible) {
                    layout_main.setVisibility(View.INVISIBLE);
                    layout_bg.setVisibility(View.INVISIBLE);
                }
                layout_main.setClickable(true);
                layout_bg.setClickable(true);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        animAlpha.setDuration(300);
        layout_bg.startAnimation(animAlpha);

        animSlide.setDuration(300);
        layout_main.startAnimation(animSlide);
    }

    /**
     * 控制布局从底部出现/消失的动画
     *
     * @param context
     * @param isToVisible true 从下往上滑动出现  false 从上往下滑动消失
     * @param layout_bg
     * @param layout_main
     * @param listener
     */
    public static void animLayoutBottom(Context context, final boolean isToVisible, final View layout_bg, final View layout_main, final AnimEndListener listener){
        Animation animSlide = null;
        Animation animAlpha = null;
        if (isToVisible) {
            animSlide = AnimationUtils.loadAnimation(context, R.anim.slide_in_bottom);
            animAlpha = AnimationUtils.loadAnimation(context, R.anim.alpha_in);
        } else {
            animSlide = AnimationUtils.loadAnimation(context, R.anim.slide_out_bottom);
            animAlpha = AnimationUtils.loadAnimation(context, R.anim.alpha_out);
        }
        animSlide.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                layout_main.setVisibility(View.VISIBLE);
                layout_bg.setVisibility(View.VISIBLE);
                layout_main.setClickable(false);
                layout_bg.setClickable(false);

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                if (!isToVisible) {
                    layout_main.setVisibility(View.INVISIBLE);
                    layout_bg.setVisibility(View.INVISIBLE);
                }
                layout_main.setClickable(true);
                layout_bg.setClickable(true);
                if(listener!=null)
                    listener.animEnd();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        animAlpha.setDuration(180);
        layout_bg.startAnimation(animAlpha);

        animSlide.setDuration(180);
        layout_main.startAnimation(animSlide);
    }

    public static void animLayoutTop(Context context, final boolean isToVisible, final View layout_bg, final View layout_main, final AnimEndListener listener){
        Animation animSlide = null;
        Animation animAlpha = null;
        if (isToVisible) {
            animSlide = AnimationUtils.loadAnimation(context, R.anim.slide_in_top);
            animAlpha = AnimationUtils.loadAnimation(context, R.anim.alpha_in);
        } else {
            animSlide = AnimationUtils.loadAnimation(context, R.anim.slide_out_top);
            animAlpha = AnimationUtils.loadAnimation(context, R.anim.alpha_out);
        }
        animSlide.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                layout_main.setVisibility(View.VISIBLE);
                layout_bg.setVisibility(View.VISIBLE);
                layout_main.setClickable(false);
                layout_bg.setClickable(false);

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                if (!isToVisible) {
                    layout_main.setVisibility(View.INVISIBLE);
                    layout_bg.setVisibility(View.INVISIBLE);
                }
                layout_main.setClickable(true);
                layout_bg.setClickable(true);
                if(listener!=null)
                    listener.animEnd();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        animAlpha.setDuration(180);
        layout_bg.startAnimation(animAlpha);

        animSlide.setDuration(180);
        layout_main.startAnimation(animSlide);
    }

    public static void animAlpha(Context context, final View view , final boolean isToVisible){
        Animation animAlpha = null;
        if (isToVisible) {
            animAlpha = AnimationUtils.loadAnimation(context, R.anim.alpha_in);
        } else {
            animAlpha = AnimationUtils.loadAnimation(context, R.anim.alpha_out);
        }
        animAlpha.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                view.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                if(isToVisible){
                    view.setVisibility(View.VISIBLE);
                }else {
                    view.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        animAlpha.setDuration(180);
        view.startAnimation(animAlpha);

    }

    public static void animScale(Context context, final View view , final boolean isToVisible){
        Animation animScale = null;
        if (isToVisible) {
            animScale = AnimationUtils.loadAnimation(context, R.anim.scale_to_big);
        } else {
            animScale = AnimationUtils.loadAnimation(context, R.anim.scale_to_small);
        }
        animScale.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                view.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                if(isToVisible){
                    view.setVisibility(View.VISIBLE);
                }else {
                    view.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        animScale.setDuration(180);
        view.startAnimation(animScale);

    }

    public static void animAlpha(Context context, View view){
        Animation animAlpha = new AnimationUtils().loadAnimation(context,R.anim.alpha_in_and_out);
        view.startAnimation(animAlpha);

    }
}
