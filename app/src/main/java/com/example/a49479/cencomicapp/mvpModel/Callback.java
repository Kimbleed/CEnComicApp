package com.example.a49479.cencomicapp.mvpModel;

/**
 * Created by 49479 on 2018/5/5.
 */

public interface Callback<T> {
    void onSuccess(T data);

    void onError(int code,String errMsg);

    void onFailure(int code,String errMsg);

}
