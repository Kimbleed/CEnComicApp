package com.example.a49479.cencomicapp.utils;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.app.ActivityCompat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 49479 on 2018/5/6.
 * 权限动态请求帮助类
 *
 */

public class PermissionHelper {

    public static final int REQ_PERMISSION_CODE = 0x12;

    /**
     * 动态申请权限
     * @param context 上下文
     * @param permissions 需要申请的权限
     * @return 是不是需要申请      true 不需要
     */
    public static boolean checkPermission(Activity context, String[] permissions) {
        //6.0以上
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            //没有权限需要申请时
            if (permissions == null || permissions.length <= 0)
                return true;
            //检查权限是不是已经授予
            List<String> noOkPermissions = new ArrayList<String>();
            for (String permission : permissions) {
                if (ActivityCompat.checkSelfPermission(context,permission) == PackageManager.PERMISSION_DENIED) {
                    noOkPermissions.add(permission);
                }
            }
            //该权限已经授予，不再申请
            if (noOkPermissions.size() <= 0)
                return true;
            //6.0以上需要申请权限
            ActivityCompat.requestPermissions(context,noOkPermissions.toArray(new String[noOkPermissions.size()]), REQ_PERMISSION_CODE);
            return false;
        }
        //6.0以下下不需要申请
        return true;
    }

    /**
     * 处理权限申请的结果，返回结构化的数据
     * @param requestCode 请求码
     * @param permissions 被请求的权限
     * @param grantResults 请求结果
     * @param listener 监听
     */
    public static void onRequestPermissionsResult(int requestCode,
                                                  String[] permissions,
                                                  int[] grantResults,
                                                  OnPermissionHandleOverListener listener) {
        if (requestCode != REQ_PERMISSION_CODE)
            return;
        Map<String, Integer> result = new HashMap<String, Integer>();
        boolean isHavePermissionNotOk = false;
        for (int i = 0; i < Math.min(permissions.length, grantResults.length); i++) {
            result.put(permissions[i], grantResults[i]);
            //有权限没有同意
            if (grantResults[i] == PackageManager.PERMISSION_DENIED) {
                isHavePermissionNotOk = true;
            }
        }
        //如果权限全部同意，继续执行
        if (listener != null)
            listener.onHandleOver(!isHavePermissionNotOk, result);
    }

    public interface OnPermissionHandleOverListener {
        void onHandleOver(boolean isOkExactly, Map<String, Integer> result);
    }
}
