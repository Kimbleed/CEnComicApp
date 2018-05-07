package com.example.a49479.cencomicapp.mvpModel.baseModel;

import com.example.a49479.cencomicapp.mvpModel.Callback;

import java.util.Map;

/**
 * Created by 49479 on 2018/5/5.
 */

public abstract class NetBaseModel<T> extends BaseModel<T>{

    protected Map<String,String> mParams;

    @Override
    public NetBaseModel params(Object... params) {
        if(params[0] instanceof Map)
            mParams = (Map)params[0];
        return this;
    }

    // 执行Get网络请求，此类看需求由自己选择写与不写
    protected void requestGetAPI(String url,Callback<T> callback){
        //这里写具体的网络请求
    }
    // 执行Post网络请求，此类看需求由自己选择写与不写
    protected void requestPostAPI(String url, Callback<T> callback){
        //这里写具体的网络请求
    }


}
