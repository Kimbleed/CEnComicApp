package com.example.a49479.cencomicapp.mvpView.baseActivity;

import android.os.Bundle;

import com.example.a49479.cencomicapp.mvpPresenter.BasePresenter;
import com.example.a49479.cencomicapp.mvpView.IBaseView;

/**
 * Created by 49479 on 2018/5/5.
 */

public abstract class MVPBaseActivity <V extends IBaseView,T extends BasePresenter<V>> extends BaseUIHandlerActivity{
    protected T mPresenter;

    @SuppressWarnings("unchecked")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = createPresenter();
        mPresenter.attachView((V)this);
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        mPresenter.detachView();
    }

    protected abstract T createPresenter();
}
