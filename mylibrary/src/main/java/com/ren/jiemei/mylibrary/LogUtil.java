package com.ren.jiemei.mylibrary;

import android.util.Log;

/**
 * Created by Administrator on 2016/12/26 0026.
 */

public  class LogUtil {

    public LogUtil(){}
    public static void shoelog(String canname,String s){
        Log.e(canname, "shoelog: "+s );
    }
}
