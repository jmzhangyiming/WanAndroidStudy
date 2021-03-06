package mrzhang.com.wanandroid.study.presenter.main;

import javax.inject.Inject;

import mrzhang.com.wanandroid.study.base.present.BasePresent;
import mrzhang.com.wanandroid.study.contract.main.SettingContract;
import mrzhang.com.wanandroid.study.core.DataManager;

/**
 * @author mrzhang
 * @date 2019/1/13
 */
public class SettingPresenter extends BasePresent<SettingContract.View> implements SettingContract.Prensent {

    private DataManager mDataManager;

    @Inject
    SettingPresenter(DataManager dataManager) {
        super(dataManager);
        this.mDataManager = dataManager;
    }


    @Override
    public void setNightModeState(boolean b) {
        mDataManager.setNightModeState(b);
    }

    @Override
    public boolean getNightModeState() {
        return mDataManager.getNightModeState();
    }
}
