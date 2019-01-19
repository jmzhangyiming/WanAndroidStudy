package mrzhang.com.wanandroid.study.presenter.mainpager;

import javax.inject.Inject;

import mrzhang.com.wanandroid.study.base.present.BasePresent;
import mrzhang.com.wanandroid.study.contract.mainpager.MainPagerContract;
import mrzhang.com.wanandroid.study.core.DataManager;

/**
 * @author mrzhang
 * @date 2019/1/13
 */
public class MainPagerPresent extends BasePresent<MainPagerContract.View> implements MainPagerContract.Present {

    private DataManager mDataManager;

    @Inject
    MainPagerPresent(DataManager dataManager) {
        super(dataManager);
        this.mDataManager = dataManager;
    }
    
}
