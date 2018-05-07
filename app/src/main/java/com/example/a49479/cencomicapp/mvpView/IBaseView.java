package com.example.a49479.cencomicapp.mvpView;

import android.content.Context;

/**
 * Created by 49479 on 2018/5/5.
 */

public interface IBaseView {
    void showLoading();
    void hideLoading();
    void showToast(String msg);
    void showErr();
    void showMsg(int msgType,Object ...data);
    Context getContext();
}
