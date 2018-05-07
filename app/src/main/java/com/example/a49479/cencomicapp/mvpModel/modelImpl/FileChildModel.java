package com.example.a49479.cencomicapp.mvpModel.modelImpl;

import android.os.AsyncTask;

import com.example.a49479.cencomicapp.mvpModel.Callback;
import com.example.a49479.cencomicapp.mvpModel.baseModel.FileBaseModel;

import java.io.File;
import java.util.Arrays;
import java.util.List;

/**
 * Created by 49479 on 2018/5/6.
 */

public class FileChildModel extends FileBaseModel<List<String >> {

    @Override
    public void execute(final Callback<List<String>> callback) {
        AsyncTask<String,Void,List<String>> asyncTask = new AsyncTask<String,Void,List<String>>() {

            @Override
            protected List<String> doInBackground(String... params) {
                try {
                    File file = new File(params[0]);
                    if (file.exists()) {
                        return Arrays.asList(file.list());
                    } else {
                        return null;
                    }
                }catch (Exception e ){

                }
                finally {
                    return null;
                }
            }

            @Override
            protected void onPostExecute(List<String> strings) {
                if(strings!=null) {
                    callback.onSuccess(strings);
                }
                else{
                    callback.onFailure(-1,"result null");
                }
            }
        };

        asyncTask.execute((String)mFilePath);


    }
}
