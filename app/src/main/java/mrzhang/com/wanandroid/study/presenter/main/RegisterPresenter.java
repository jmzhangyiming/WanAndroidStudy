package mrzhang.com.wanandroid.study.presenter.main;

import android.text.TextUtils;

import javax.inject.Inject;

import mrzhang.com.wanandroid.study.app.WanAndroidApp;
import mrzhang.com.wanandroid.study.base.present.BasePresent;
import mrzhang.com.wanandroid.study.contract.main.RegisterContract;
import mrzhang.com.wanandroid.study.core.DataManager;
import mrzhang.com.wanandroid.study.core.bean.main.login.LoginData;
import mrzhang.com.wanandroid.study.utils.RxUtils;
import mrzhang.com.wanandroid.study.widget.BaseObserver;
import mrzhang.com.wanandroid.wanandroidstudy.R;

/**
 * @author mrzhang
 * @date 2019/2/28
 */
public class RegisterPresenter extends BasePresent<RegisterContract.View> implements RegisterContract.Presenter{

    private DataManager mDataManager;
    @Inject
    public RegisterPresenter(DataManager dataManager) {
        super(dataManager);
        this.mDataManager = dataManager;
    }

    @Override
    public void getRegisterData(String username, String password, String rePassword) {
        if (TextUtils.isEmpty(username) || TextUtils.isEmpty(password) || TextUtils.isEmpty(rePassword)) {
            mView.showSnackBar(WanAndroidApp.getInstance().getString(R.string.account_password_null_tint));
            return;
        }
        addSubscribe(mDataManager.getRegisterData(username, password, rePassword)
                .compose(RxUtils.rxSchedulerHelper())
                .compose(RxUtils.handleResult())
                .filter(loginData -> !TextUtils.isEmpty(username)
                        && !TextUtils.isEmpty(password)
                        && !TextUtils.isEmpty(rePassword))
                .subscribeWith(new BaseObserver<LoginData>(mView, WanAndroidApp.getInstance().getString(R.string.register_fail)) {
                    @Override
                    public void onNext(LoginData loginData) {
                        mView.showRegisterSuccess();
                    }
                }));

    }
}
