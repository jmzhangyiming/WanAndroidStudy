package mrzhang.com.wanandroid.study.ui.navigation.fragment;

import android.support.design.widget.NavigationView;

import mrzhang.com.wanandroid.study.base.fragment.BaseRootFragment;

/**
 * @author mrzhang
 * @date 2019/1/14
 */
public class NavigationFragment extends BaseRootFragment{

    public static NavigationFragment getInstance() {
        NavigationFragment navigationFragment = new NavigationFragment();
        return navigationFragment;
    }

    @Override
    protected int getLayoutId() {
        return 0;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initEventAndData() {

    }
}
