package mrzhang.com.wanandroid.study.presenter.main;

import mrzhang.com.wanandroid.study.base.present.BasePresent;
import mrzhang.com.wanandroid.study.contract.main.MainContract;

/**
 * @author mrzhang
 * @date 2019/1/9
 */
public class MainPresent extends BasePresent<MainContract.View> implements MainContract.Presenter {


    @Override
    public void attachView(MainContract.View view) {
        super.attachView(view);
    }

    @Override
    public void detach() {

    }
}
