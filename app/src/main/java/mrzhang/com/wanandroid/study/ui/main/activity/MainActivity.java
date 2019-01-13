package mrzhang.com.wanandroid.study.ui.main.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;
import android.widget.FrameLayout;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import mrzhang.com.wanandroid.study.base.fragment.BaseFragment;
import mrzhang.com.wanandroid.study.ui.main.mainpager.fragment.MainPagerFragment;
import mrzhang.com.wanandroid.wanandroidstudy.R;
import mrzhang.com.wanandroid.study.base.activity.BaseActivity;
import mrzhang.com.wanandroid.study.contract.main.MainContract;
import mrzhang.com.wanandroid.study.presenter.main.MainPresent;

/**
  * @author zhangyiming
  * @date 2019/1/4
  */
public class MainActivity extends BaseActivity<MainPresent> implements MainContract.View {

    @BindView(R.id.nav_view)
    NavigationView mNavigationView;
    @BindView(R.id.common_toolbar_title_tv)
    TextView mTitleTv;
    @BindView(R.id.fragment_group)
    FrameLayout mFrameGroup;

    private ArrayList<BaseFragment> mFragments;
    private MainPagerFragment mMainPagerFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mFragments = new ArrayList<>();
        initPager(false, 0);

    }

    private void initPager(boolean isRecreate, int position) {
        mMainPagerFragment = MainPagerFragment.getInstance();
        switchFragment();
    }

    private void switchFragment() {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.show(mMainPagerFragment);
        ft.commit();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initToolbar() {
        mTitleTv.setText(R.string.home_pager);
    }

    @Override
    protected void initEventAndData() {

    }
}
