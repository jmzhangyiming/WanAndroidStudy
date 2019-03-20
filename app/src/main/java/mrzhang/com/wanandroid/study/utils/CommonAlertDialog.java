package mrzhang.com.wanandroid.study.utils;

import android.app.Activity;
import android.app.AlertDialog;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import mrzhang.com.wanandroid.wanandroidstudy.R;

/**
 * @author mrzhang
 * @date 2019/3/2
 */
public class CommonAlertDialog {

    private AlertDialog alertDialog;

    public static CommonAlertDialog newInstance() {
        return CommonAlertDialogHolder.COMMON_ALERT_DIALOG;
    }

    private static class CommonAlertDialogHolder {
        private static final CommonAlertDialog COMMON_ALERT_DIALOG = new CommonAlertDialog();
    }

    /**
     * Show alertDialog
     *
     * @param mActivity activity instance
     * @param content show content
     * @param btnContent ok btn content
     * @param neContent negative btn content
     * @param onPoClickListener ok btn onClickListener
     * @param onNeClickListener negative btn onClickListener
     */
    public void showDialog(Activity mActivity, String content, String btnContent, String neContent,
                           final View.OnClickListener onPoClickListener,
                           final View.OnClickListener onNeClickListener) {
        if (mActivity == null) {
            return;
        }
        if (alertDialog == null) {
            alertDialog = new AlertDialog.Builder(mActivity, R.style.myCorDialog).create();
        }
        if (!alertDialog.isShowing()) {
            alertDialog.show();
        }
        alertDialog.setCanceledOnTouchOutside(false);
        Window window = alertDialog.getWindow();
        if (window != null) {
            window.setContentView(R.layout.common_alert_dialog);
            TextView contentTv = (TextView) window.findViewById(R.id.dialog_content);
            contentTv.setText(content);
            Button mOkBtn = (Button) window.findViewById(R.id.dialog_btn);
            mOkBtn.setText(btnContent);
            mOkBtn.setOnClickListener(onPoClickListener);
            View btnDivider = window.findViewById(R.id.dialog_btn_divider);
            btnDivider.setVisibility(View.VISIBLE);
            Button mNeBtn = (Button) window.findViewById(R.id.dialog_negative_btn);
            mNeBtn.setText(neContent);
            mNeBtn.setVisibility(View.VISIBLE);
            mNeBtn.setOnClickListener(onNeClickListener);
        }
    }

    /**
     * Cancel alertDialog
     */
    public void cancelDialog() {
        if (alertDialog != null && alertDialog.isShowing()) {
            alertDialog.dismiss();
            alertDialog = null;
        }
    }

}
