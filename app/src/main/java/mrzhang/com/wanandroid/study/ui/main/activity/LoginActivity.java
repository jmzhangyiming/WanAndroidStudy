package mrzhang.com.wanandroid.study.ui.main.activity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;

import com.jakewharton.rxbinding2.view.RxView;

import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.OnClick;
import mrzhang.com.wanandroid.study.app.Constants;
import mrzhang.com.wanandroid.study.base.activity.BaseActivity;
import mrzhang.com.wanandroid.study.contract.main.LoginContract;
import mrzhang.com.wanandroid.study.presenter.main.LoginPresenter;
import mrzhang.com.wanandroid.study.utils.StatusBarUtil;
import mrzhang.com.wanandroid.study.utils.logger.CommonUtils;
import mrzhang.com.wanandroid.wanandroidstudy.R;

/**
 * @author mrzhang
 * @date 2019/2/23
 */
public class LoginActivity extends BaseActivity<LoginPresenter> implements LoginContract.View{

    @BindView(R.id.login_group)
    RelativeLayout mLoginGroup;
    @BindView(R.id.login_toolbar)
    Toolbar mToolbar;
    @BindView(R.id.login_account_edit)
    EditText mAccountEdit;
    @BindView(R.id.login_password_edit)
    EditText mPasswordEdit;
    @BindView(R.id.login_btn)
    Button mLoginBtn;
    @BindView(R.id.login_register_btn)
    Button mRegisterBtn;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void initToolbar() {
        StatusBarUtil.immersive(this);
        StatusBarUtil.setPaddingSmart(this, mToolbar);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressedSupport();
            }
        });
    }

    @Override
    protected void initEventAndData() {
        subscribeLoginClickEvent();
    }

    @OnClick({R.id.login_register_btn})
    void onClick(View view) {
        switch (view.getId()) {
            case R.id.login_register_btn:
                startRegisterPager();
                break;
            default:
                break;
        }
    }

    private void startRegisterPager() {
        ActivityOptions options = ActivityOptions.makeScaleUpAnimation(mRegisterBtn, mRegisterBtn.getWidth()/2,
                mRegisterBtn.getHeight()/2, 0 , 0);
        startActivity(new Intent(this, RegisterActivity.class), options.toBundle());
    }

    private void subscribeLoginClickEvent() {
        mPresenter.addRxBindingSubscribe(RxView.clicks(mLoginBtn)
                .throttleFirst(Constants.CLICK_TIME_AREA, TimeUnit.MILLISECONDS)
                .filter(o -> mPresenter != null)
                .subscribe(o -> mPresenter.getLoginData(mAccountEdit.getText().toString().trim(),
                        mPasswordEdit.getText().toString().trim())));
    }


    @Override
    public void showLoginSuccess() {
        CommonUtils.showMessage(this, getString(R.string.login_success));
        onBackPressedSupport();
    }
}
