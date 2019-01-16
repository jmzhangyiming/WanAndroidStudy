package mrzhang.com.wanandroid.study.presenter.main;

import javax.inject.Inject;

import mrzhang.com.wanandroid.study.base.present.BasePresent;
import mrzhang.com.wanandroid.study.contract.main.MainContract;
import mrzhang.com.wanandroid.study.core.DataManager;

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
    }

    @Override
    public void detach() {

    }
}
