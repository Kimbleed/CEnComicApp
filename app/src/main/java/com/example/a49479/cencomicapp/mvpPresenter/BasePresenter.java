package com.example.a49479.cencomicapp.mvpPresenter;

import com.example.a49479.cencomicapp.mvpView.IBaseView;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/**
 * Created by 49479 on 2018/5/5.
 */

public abstract class BasePresenter<V extends IBaseView> {

    protected Reference<V> mViewRef;

    protected V getView() {
        return mViewRef.get();
    }

    public void attachView(V view){
        mViewRef = new WeakReference<V>(view);
    }

    public boolean isViewAttached() {
        return mViewRef != null && mViewRef.get() != null;
    }

    public void detachView(){
        if(mViewRef!=null){
            mViewRef.clear();
            mViewRef = null;
        }
    }
}
