package com.example.a49479.cencomicapp.mvpModel;

import com.example.a49479.cencomicapp.mvpModel.baseModel.BaseModel;

/**
 * Created by 49479 on 2018/5/6.
 */

public class DataModelManager {

    public static BaseModel request(String token){
        BaseModel model =null;

        try {
            //利用反射机制获得对应Model对象的引用
            model = (BaseModel)Class.forName(token).newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return model;
    }
}
