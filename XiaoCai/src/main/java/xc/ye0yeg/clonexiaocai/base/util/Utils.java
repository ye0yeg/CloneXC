package xc.ye0yeg.clonexiaocai.base.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by Administrator on 4/14/2017.
 */

public class Utils {
    public static boolean isNetworkAvailable(Context context) {
        if (context == null) {
            return false;
        }
        ConnectivityManager connectivity = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if(connectivity ==null){
            return false;
        }else{
            NetworkInfo[] info = connectivity.getAllNetworkInfo();
            if(info != null){
                int l = info.length;
                for(int i = 0; i<1 ; i++){
                    if(info[i].getState() == NetworkInfo.State.CONNECTED){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
