package mrzhang.com.wanandroid.study.ui.mainpager.fragment;

import android.os.Bundle;
import android.util.Log;

import mrzhang.com.wanandroid.study.app.Constants;
import mrzhang.com.wanandroid.study.base.fragment.BaseRootFragment;
import mrzhang.com.wanandroid.study.contract.mainpager.MainPagerContract;
import mrzhang.com.wanandroid.study.presenter.mainpager.MainPagerPresent;
import mrzhang.com.wanandroid.wanandroidstudy.R;

/**
 * @author mrzhang
 * @date 2019/1/13
 */
public class MainPagerFragment extends BaseRootFragment<MainPagerPresent> implements MainPagerContract.View{

    public static MainPagerFragment getInstance(boolean param1, String param2) {
        MainPagerFragment mainPagerFragment = new MainPagerFragment();
        Bundle bundle = new Bundle();
        bundle.putBoolean(Constants.ARG_PARAM1, param1);
        bundle.putString(Constants.ARG_PARAM2, param2);
        mainPagerFragment.setArguments(bundle);
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
