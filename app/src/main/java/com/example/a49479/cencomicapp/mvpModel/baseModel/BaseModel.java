package com.example.a49479.cencomicapp.mvpModel.baseModel;


import com.example.a49479.cencomicapp.mvpModel.Callback;

/**
 * Created by 49479 on 2018/5/5.
 */

public abstract class BaseModel<T> {

    public abstract BaseModel params(Object ...params);

    public abstract void execute(Callback<T> callback);
}
