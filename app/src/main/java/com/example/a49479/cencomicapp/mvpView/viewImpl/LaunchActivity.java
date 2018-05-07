package com.example.a49479.cencomicapp.mvpView.viewImpl;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.widget.TextView;

import com.example.a49479.cencomicapp.R;
import com.example.a49479.cencomicapp.mvpView.baseActivity.BaseUIHandlerActivity;
import com.example.a49479.cencomicapp.utils.AnimUtil;

import butterknife.InjectView;

/**
 * Created by 49479 on 2018/5/6.
 */

public class LaunchActivity extends BaseUIHandlerActivity {

    @InjectView(R.id.tv_app_name)
    TextView tv_app_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onResume() {
        super.onResume();
        AnimUtil.animScale(activity(),tv_app_name,true);
        mUIHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if(isForeground)
                    startActivity(new Intent(activity(),MainActivity.class));
            }
        },3000);
    }

    @Override
    protected void onStop() {
        super.onStop();
        finish();
    }

    @Override
    public int getContentView() {
        return R.layout.activity_launch;
    }

    @Override
    public void handleMessage(Message msg) {

    }
}
