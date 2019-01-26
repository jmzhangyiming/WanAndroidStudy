package mrzhang.com.wanandroid.study.utils.logger;

import android.app.Activity;
import android.widget.Toast;

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



}
