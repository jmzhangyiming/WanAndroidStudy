package mrzhang.com.wanandroid.study.ui.main.activity;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.Toolbar;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.jakewharton.rxbinding2.view.RxView;

import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import mrzhang.com.wanandroid.study.app.Constants;
import mrzhang.com.wanandroid.study.base.activity.BaseActivity;
import mrzhang.com.wanandroid.study.contract.main.RegisterContract;
import mrzhang.com.wanandroid.study.presenter.main.RegisterPresenter;
import mrzhang.com.wanandroid.study.utils.StatusBarUtil;
import mrzhang.com.wanandroid.study.utils.logger.CommonUtils;
import mrzhang.com.wanandroid.wanandroidstudy.R;

/**
 * @author mrzhang
 * @date 2019/2/28
 */
public class RegisterActivity extends BaseActivity<RegisterPresenter> implements RegisterContract.View {

    @BindView(R.id.common_toolbar)
    Toolbar mToolbar;
    @BindView(R.id.common_toolbar_title_tv)
    TextView mTitleTv;
    @BindView(R.id.register_account_edit)
    EditText mAccountEdit;
    @BindView(R.id.register_password_edit)
    EditText mPasswordEdit;
    @BindView(R.id.register_confirm_password_edit)
    EditText mConfirmPasswordEdit;
    @BindView(R.id.register_btn)
    Button mRegisterBtn;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_register;
    }

    @Override
    protected void initToolbar() {
        StatusBarUtil.immersive(this);
        StatusBarUtil.setPaddingSmart(this, mToolbar);
        mToolbar.setBackgroundColor(ContextCompat.getColor(this, R.color.register_bac));
        mTitleTv.setText(R.string.register);
        mTitleTv.setTextColor(ContextCompat.getColor(this, R.color.white));
        mTitleTv.setTextSize(20);
        mToolbar.setNavigationOnClickListener(v -> onBackPressedSupport());
    }

    @Override
    protected void initEventAndData() {
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        if (inputMethodManager != null) {
            mAccountEdit.requestFocus();
            inputMethodManager.showSoftInput(mAccountEdit, 0);
        }
        mPresenter.addRxBindingSubscribe(RxView.clicks(mRegisterBtn)
                .throttleFirst(Constants.CLICK_TIME_AREA, TimeUnit.MILLISECONDS)
                .filter(o -> mPresenter != null)
                .subscribe(o -> register()));
    }

    private void register() {
        mPresenter.getRegisterData(mAccountEdit.getText().toString().trim(),
                mPasswordEdit.getText().toString().trim(),
                mConfirmPasswordEdit.getText().toString().trim());
    }


    @Override
    public void showRegisterSuccess() {
        CommonUtils.showSnackMessage(this, getString(R.string.register_success));
        onBackPressedSupport();
    }
}
