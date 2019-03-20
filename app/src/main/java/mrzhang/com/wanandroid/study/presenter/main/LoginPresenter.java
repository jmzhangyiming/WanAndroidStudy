package mrzhang.com.wanandroid.study.presenter.main;

import android.text.TextUtils;

import javax.inject.Inject;

import mrzhang.com.wanandroid.study.app.WanAndroidApp;
import mrzhang.com.wanandroid.study.base.present.BasePresent;
import mrzhang.com.wanandroid.study.component.Rxbus;
import mrzhang.com.wanandroid.study.contract.main.LoginContract;
import mrzhang.com.wanandroid.study.core.DataManager;
import mrzhang.com.wanandroid.study.core.bean.main.login.LoginData;
import mrzhang.com.wanandroid.study.core.event.LoginEvent;
import mrzhang.com.wanandroid.study.utils.RxUtils;
import mrzhang.com.wanandroid.study.widget.BaseObserver;
import mrzhang.com.wanandroid.wanandroidstudy.R;

/**
 * @author mrzhang
 * @date 2019/2/23
 */
public class LoginPresenter extends BasePresent<LoginContract.View> implements LoginContract.Presenter {

    private DataManager mDataManager;

    @Inject
    public LoginPresenter(DataManager dataManager) {
        super(dataManager);
        mDataManager = dataManager;
    }


    @Override
    public void getLoginData(String username, String password) {
        if (TextUtils.isEmpty(username) || TextUtils.isEmpty(password)) {
            mView.showSnackBar(WanAndroidApp.getInstance().getString(R.string.account_password_null_tint));
            return;
        }
        addSubscribe(mDataManager.getLoginData(username, password)
                .compose(RxUtils.rxSchedulerHelper())
                .compose(RxUtils.handleResult())
                .subscribeWith(new BaseObserver<LoginData>(mView, WanAndroidApp.getInstance().getString(R.string.login_fail)) {
                    @Override
                    public void onNext(LoginData loginData) {
                        setLoginAccount(loginData.getUsername());
                        setLoginPassword(loginData.getPassword());
                        setLoginStatus(true);
                        Rxbus.getDefault().post(new LoginEvent(true));
                        mView.showLoginSuccess();
                    }
                }));
    }
}
