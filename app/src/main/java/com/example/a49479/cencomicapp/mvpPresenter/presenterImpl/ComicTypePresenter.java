package com.example.a49479.cencomicapp.mvpPresenter.presenterImpl;

import android.os.Environment;

import com.example.a49479.cencomicapp.mvpModel.Callback;
import com.example.a49479.cencomicapp.mvpModel.DataModelManager;
import com.example.a49479.cencomicapp.mvpModel.Token;
import com.example.a49479.cencomicapp.mvpPresenter.BasePresenter;
import com.example.a49479.cencomicapp.mvpView.IBaseView;

import java.util.List;

/**
 * Created by 49479 on 2018/5/6.
 */

public class ComicTypePresenter extends BasePresenter<IBaseView> {

    public static final String dirPath = Environment.getExternalStorageDirectory().getAbsolutePath()+"CEnComic";

    public void getComicType() {
        getView().showLoading();
        DataModelManager.
                request(Token.API_FILE_CHILD).
                params("").
                execute(new Callback<List<String>>() {
                    @Override
                    public void onSuccess(List<String> data) {
                        getView().hideLoading();
                        getView().showMsg(0,data);
                    }

                    @Override
                    public void onError(int code, String errMsg) {
                        getView().hideLoading();
                        getView().showToast(errMsg);
                    }

                    @Override
                    public void onFailure(int code, String errMsg) {
                        getView().hideLoading();
                        getView().showToast(errMsg);
                    }
                });
    }
}
