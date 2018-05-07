package com.example.a49479.cencomicapp.mvpModel.baseModel;

/**
 * Created by 49479 on 2018/5/6.
 */

public abstract class FileBaseModel<T> extends BaseModel<T> {

    protected String mFilePath;

    @Override
    public BaseModel params(Object... params) {
        if(params[0] instanceof String )
            mFilePath = (String)params[0];
        return this;
    }

}
