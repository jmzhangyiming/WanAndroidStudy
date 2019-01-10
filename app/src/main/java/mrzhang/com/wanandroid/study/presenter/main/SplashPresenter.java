package mrzhang.com.wanandroid.study.presenter.main;


import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import mrzhang.com.wanandroid.study.base.present.BasePresent;
import mrzhang.com.wanandroid.study.contract.main.SplashContract;

/**
 * @author mrzhang
 * @date 2019/1/5
 */
public class SplashPresenter extends BasePresent<SplashContract.View> implements SplashContract.Present {
    @Inject
    SplashPresenter() {

    }

    @Override
    public void attachView(SplashContract.View view) {
        super.attachView(view);
        long splashTime = 2000;
        addSubscribe(Observable.timer(splashTime, TimeUnit.MILLISECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(aLong -> view.jumpToMain())
        );
    }
}
