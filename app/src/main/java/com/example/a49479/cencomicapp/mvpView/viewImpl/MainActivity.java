package com.example.a49479.cencomicapp.mvpView.viewImpl;

import android.content.Context;
import android.os.Bundle;
import android.os.Message;

import com.example.a49479.cencomicapp.R;
import com.example.a49479.cencomicapp.mvpPresenter.presenterImpl.ComicTypePresenter;
import com.example.a49479.cencomicapp.mvpView.IBaseView;
import com.example.a49479.cencomicapp.mvpView.baseActivity.MVPBaseActivity;

import java.util.List;

public class MainActivity extends MVPBaseActivity<IBaseView, ComicTypePresenter> implements IBaseView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter.getComicType();
    }
    @Override
    public void handleMessage(Message msg) {

    }

    @Override
    public int getContentView() {
        return R.layout.activity_main;
    }

    @Override
    protected ComicTypePresenter createPresenter() {
        return new ComicTypePresenter();
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showToast(String msg) {

    }

    @Override
    public void showErr() {

    }

    @Override
    public void showMsg(int msgType, Object... data) {
        List<String> comicTypeList = (List<String>) data[0];
    }

    @Override
    public Context getContext() {
        return null;
    }

}
