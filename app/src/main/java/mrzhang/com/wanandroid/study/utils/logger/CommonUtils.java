package mrzhang.com.wanandroid.study.utils.logger;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.telecom.ConnectionService;
import android.widget.Toast;

import mrzhang.com.wanandroid.study.app.WanAndroidApp;

/**
 * @author mrzhang
 * @date 2019/1/26
 */
public class CommonUtils {

    /**
     * Show message
     *
     * @param activity Activity
     * @param msg message
     */
    public static void showMessage(Activity activity, String msg) {
        LogHelper.e("showMessage ：" + msg);
        Toast.makeText(activity, msg, Toast.LENGTH_SHORT).show();
    }

    /**
     * 检查是否有可用网络
     */
    public static boolean isNetworkConnected() {
        ConnectivityManager connectivityManager = (ConnectivityManager) WanAndroidApp.getInstance().getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        assert connectivityManager != null;
        return connectivityManager.getActiveNetworkInfo() != null;
    }




}
