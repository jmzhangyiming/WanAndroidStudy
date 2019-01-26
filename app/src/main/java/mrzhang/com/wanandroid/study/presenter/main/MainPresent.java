package mrzhang.com.wanandroid.study.presenter.main;

import javax.inject.Inject;

import mrzhang.com.wanandroid.study.app.WanAndroidApp;
import mrzhang.com.wanandroid.study.base.present.BasePresent;
import mrzhang.com.wanandroid.study.component.Rxbus;
import mrzhang.com.wanandroid.study.contract.main.MainContract;
import mrzhang.com.wanandroid.study.core.DataManager;
import mrzhang.com.wanandroid.study.core.event.NightModeEvent;
import mrzhang.com.wanandroid.study.utils.RxUtils;
import mrzhang.com.wanandroid.study.widget.BaseSubscribe;
import mrzhang.com.wanandroid.wanandroidstudy.R;

/**
 * @author mrzhang
 * @date 2019/1/9
 */
public class MainPresent extends BasePresent<MainContract.View> implements MainContract.Presenter {

    private DataManager mDataManager;

    @Inject
    MainPresent(DataManager dataManager) {
        super(dataManager);
        this.mDataManager = dataManager;
    }

    @Override
    public void attachView(MainContract.View view) {
        super.attachView(view);
        registerEvent();
    }

    @Override
    public void detach() {

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


    }

    @Override
    public void setNightModeState(boolean b) {
        mDataManager.setNightModeState(b);
    }
}
