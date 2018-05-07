package com.example.a49479.cencomicapp.mvpView.baseActivity;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Window;

import com.example.a49479.cencomicapp.R;
import com.example.a49479.cencomicapp.manager.AppActivityManager;

import java.lang.ref.WeakReference;

import butterknife.ButterKnife;

/**
 * Created by 49479 on 2018/5/6.
 */

public abstract class BaseUIHandlerActivity extends Activity {

    protected boolean isForeground;

    protected UIHandler mUIHandler  = new UIHandler(BaseUIHandlerActivity.this);

    protected static class UIHandler extends Handler {
        private final WeakReference<BaseUIHandlerActivity> mActivityReference;

        public UIHandler(BaseUIHandlerActivity activity) {
            mActivityReference = new WeakReference(activity);
        }

        @Override
        public void handleMessage(Message msg) {
            final BaseUIHandlerActivity activity = mActivityReference.get();
            if (activity == null) {
                return;
            }
            if (activity.isFinishing()) {
                return;
            }
            activity.handleMessage(msg);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AppActivityManager.instance().addActivity(this);
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(getContentView());
        ButterKnife.inject(this);

    }

    @Override
    protected void onResume() {
        super.onResume();
        isForeground = true;
    }

    @Override
    protected void onPause() {
        super.onPause();
        isForeground = false;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        AppActivityManager.instance().finishActivity(this);
    }

    public abstract int getContentView();

    public abstract void handleMessage(Message msg);


    public Activity activity(){
        return this;
    }

    public Context getContext(){
        return getContext();
    }

    @Override
    public void startActivityForResult(Intent intent, int requestCode) {
        super.startActivityForResult(intent, requestCode);
        overridePendingTransition(R.anim.activity_arrival, R.anim.activity_leave);
    }

    @Override
    public void startActivityForResult(Intent intent, int requestCode, Bundle options) {
        super.startActivityForResult(intent, requestCode, options);
        overridePendingTransition(R.anim.activity_arrival, R.anim.activity_leave);
    }

    @Override
    public void finish() {
        super.finish();
    }

    public void finishWithTransition(){
        super.finish();
        overridePendingTransition(R.anim.activity_leave, R.anim.activity_arrival);
    }
}
