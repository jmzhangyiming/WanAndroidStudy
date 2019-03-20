package mrzhang.com.wanandroid.study.presenter.main;

import javax.inject.Inject;

import io.reactivex.functions.Consumer;
import io.reactivex.functions.Predicate;
import mrzhang.com.wanandroid.study.app.WanAndroidApp;
import mrzhang.com.wanandroid.study.base.present.BasePresent;
import mrzhang.com.wanandroid.study.component.Rxbus;
import mrzhang.com.wanandroid.study.contract.main.MainContract;
import mrzhang.com.wanandroid.study.core.DataManager;
import mrzhang.com.wanandroid.study.core.bean.main.login.LoginData;
import mrzhang.com.wanandroid.study.core.event.LoginEvent;
import mrzhang.com.wanandroid.study.core.event.NightModeEvent;
import mrzhang.com.wanandroid.study.utils.RxUtils;
import mrzhang.com.wanandroid.study.widget.BaseObserver;
import mrzhang.com.wanandroid.study.widget.BaseSubscribe;
import mrzhang.com.wanandroid.wanandroidstudy.R;

/**
 * @author mrzhang
 * @date 2019/1/9
 */
public class MainPresenter extends BasePresent<MainContract.View> implements MainContract.Presenter {

    private DataManager mDataManager;

    @Inject
    MainPresenter(DataManager dataManager) {
        super(dataManager);
        this.mDataManager = dataManager;
    }

    @Override
    public void attachView(MainContract.View view) {
        super.attachView(view);
        registerEvent();
    }

    @Override
    public void detachView() {

    }

    private void registerEvent() {
        addSubscribe(Rxbus.getDefault().toFlowable(NightModeEvent.class)
                .compose(RxUtils.rxFlSchedulerHelper())
                .map(NightModeEvent :: isNightMode)
                .subscribeWith(new BaseSubscribe<Boolean>(mView, WanAndroidApp.getInstance().getString(R.string.failed_to_cast_mode)) {
                    @Override
                    public void onNext(Boolean aBoolean) {
                        mView.useNightMode(aBoolean);
                    }

                    @Override
                    public void onError(Throwable t) {
                        super.onError(t);
                        registerEvent();
                    }
                })
        );

       addSubscribe(Rxbus.getDefault().toFlowable(LoginEvent.class)
               .compose(RxUtils.rxFlSchedulerHelper())
               .filter(loginEvent -> loginEvent.isLogin())
               .subscribe(loginEvent -> mView.showLoginView()));


    }

    @Override
    public void setNightModeState(boolean b) {
        mDataManager.setNightModeState(b);
    }

    @Override
    public void setCurrentPage(int page) {
        mDataManager.setCurrentPage(page);
    }

    @Override
    public void logout() {
        addSubscribe(mDataManager.logout()
                .compose(RxUtils.rxSchedulerHelper())
                .compose(RxUtils.handleLogoutResult())
                .subscribeWith(new BaseObserver<LoginData>(mView, WanAndroidApp.getInstance().getString(R.string.logout_fail)) {

                    @Override
                    public void onNext(LoginData loginData) {
                        setLoginAccount("");
                        setLoginPassword("");
                        setLoginStatus(false);
//                        CookiesManager.clearAllCookies();
                        Rxbus.getDefault().post(new LoginEvent(false));
                        mView.showLogoutSuccess();
                    }
                }));
    }


}
