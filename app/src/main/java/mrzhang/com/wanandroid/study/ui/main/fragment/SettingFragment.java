package mrzhang.com.wanandroid.study.ui.main.fragment;

import mrzhang.com.wanandroid.study.base.fragment.BaseRootFragment;
import mrzhang.com.wanandroid.study.contract.main.SettingContract;
import mrzhang.com.wanandroid.study.presenter.main.SettingPresent;
import mrzhang.com.wanandroid.wanandroidstudy.R;

/**
 * @author mrzhang
 * @date 2019/1/13
 */
public class SettingFragment extends BaseRootFragment<SettingPresent> implements SettingContract.View{


    public static SettingFragment getInstance( ) {
        SettingFragment settingFragment = new SettingFragment();
        return settingFragment;
    }


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_setting;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initEventAndData() {

    }
}
