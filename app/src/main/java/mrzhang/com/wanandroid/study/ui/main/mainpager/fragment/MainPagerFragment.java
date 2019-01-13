package mrzhang.com.wanandroid.study.ui.main.mainpager.fragment;

import mrzhang.com.wanandroid.study.base.fragment.BaseRootFragment;
import mrzhang.com.wanandroid.study.contract.mainpager.MainPagerContract;
import mrzhang.com.wanandroid.study.presenter.mainpager.MainPagerPresent;
import mrzhang.com.wanandroid.wanandroidstudy.R;

/**
 * @author mrzhang
 * @date 2019/1/13
 */
public class MainPagerFragment extends BaseRootFragment<MainPagerPresent> implements MainPagerContract.View{

    public static MainPagerFragment getInstance() {
        MainPagerFragment mainPagerFragment = new MainPagerFragment();
        return  mainPagerFragment;
    }


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_main_pager;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initEventAndData() {

    }
}
