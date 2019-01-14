package mrzhang.com.wanandroid.study.ui.main.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import mrzhang.com.wanandroid.study.app.Constants;
import mrzhang.com.wanandroid.study.base.fragment.BaseFragment;
import mrzhang.com.wanandroid.study.ui.hierarchy.fragment.KnowledgeHierarchyFragment;
import mrzhang.com.wanandroid.study.ui.main.fragment.CollectFragment;
import mrzhang.com.wanandroid.study.ui.main.fragment.SettingFragment;
import mrzhang.com.wanandroid.study.ui.mainpager.fragment.MainPagerFragment;
import mrzhang.com.wanandroid.study.ui.navigation.fragment.NavigationFragment;
import mrzhang.com.wanandroid.study.ui.project.fragment.ProjectFragment;
import mrzhang.com.wanandroid.study.ui.wx.fragment.WxArticleFragment;
import mrzhang.com.wanandroid.study.utils.BottomNavigationViewHelper;
import mrzhang.com.wanandroid.wanandroidstudy.R;
import mrzhang.com.wanandroid.study.base.activity.BaseActivity;
import mrzhang.com.wanandroid.study.contract.main.MainContract;
import mrzhang.com.wanandroid.study.presenter.main.MainPresent;

/**
  * @author zhangyiming
  * @date 2019/1/4
  */
public class MainActivity extends BaseActivity<MainPresent> implements MainContract.View {

    @BindView(R.id.drawer_layout)
    DrawerLayout mDrawerLayout;
    @BindView(R.id.nav_view)
    NavigationView mNavigationView;
    @BindView(R.id.common_toolbar_title_tv)
    TextView mTitleTv;
    @BindView(R.id.fragment_group)
    FrameLayout mFrameGroup;
    @BindView(R.id.common_toolbar)
    Toolbar mToolbar;
    @BindView(R.id.bottom_navigation_view)
    BottomNavigationView mBottomNavigationView;
    @BindView(R.id.main_floating_action_btn)
    FloatingActionButton mFloatingActionButton;

    private ArrayList<BaseFragment> mFragments;
    private MainPagerFragment mMainPagerFragment;
    private KnowledgeHierarchyFragment mKnowledgeHierarchyFragment;
    private WxArticleFragment mWxArticleFragment;
    private NavigationFragment mNavigationFragment;
    private ProjectFragment mProjectFragment;
    private CollectFragment mCollectFragment;
    private SettingFragment mSettingFragment;
    private int mLastFgIndex;


    private TextView mUsTv;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mFragments = new ArrayList<>();
        initPager(false, Constants.TYPE_MAIN_PAGER);

    }

    private void initPager(boolean isRecreate, int position) {
        mMainPagerFragment = MainPagerFragment.getInstance();
        mFragments.add(mMainPagerFragment);
        initFragments();
        init();
        switchFragment(position);
    }

    private void init() {
        initNavigationView();
        initBottomNavigationView();
        initDrawerLayout();
    }

    private void initDrawerLayout() {

    }

    private void initBottomNavigationView() {
        BottomNavigationViewHelper.disableShiftMode(mBottomNavigationView);
    }

    private void initNavigationView() {
        mUsTv = mNavigationView.getHeaderView(0).findViewById(R.id.nav_header_login_tv);
        mNavigationView.getMenu().findItem(R.id.nav_item_wan_android)
                .setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        startMainPager();
                        return true;
                    }
                });
        mNavigationView.getMenu().findItem(R.id.nav_item_setting)
                .setOnMenuItemClickListener(menuItem -> {
                    startSettingFragment();
                    return true;
                });

    }

    private void startSettingFragment() {
        mTitleTv.setText(getString(R.string.setting));
        switchFragment(Constants.TYPE_SETTING);
        mDrawerLayout.closeDrawers();
    }

    private void startMainPager() {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_activity_main, menu);
        return true;
    }

    private void initFragments() {
        mKnowledgeHierarchyFragment = KnowledgeHierarchyFragment.getInstance();
        mWxArticleFragment = WxArticleFragment.getInstance();
        mNavigationFragment = NavigationFragment.getInstance();
        mProjectFragment = ProjectFragment.getInstance();
        mCollectFragment = CollectFragment.getInstance();
        mSettingFragment = SettingFragment.getInstance();

        mFragments.add(mKnowledgeHierarchyFragment);
        mFragments.add(mWxArticleFragment);
        mFragments.add(mNavigationFragment);
        mFragments.add(mProjectFragment);
        mFragments.add(mCollectFragment);
        mFragments.add(mSettingFragment);

    }

    private void switchFragment(int position) {
        if (position >= Constants.TYPE_COLLECT) {
            mFloatingActionButton.setVisibility(View.INVISIBLE);
            mBottomNavigationView.setVisibility(View.INVISIBLE);
        } else {
            mFloatingActionButton.setVisibility(View.VISIBLE);
            mBottomNavigationView.setVisibility(View.VISIBLE);
        }
        if (position >= mFragments.size()) {
            return;
        }
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        Fragment targetFg = mFragments.get(position);
        Fragment lastFg = mFragments.get(mLastFgIndex);
        mLastFgIndex = position;
        ft.hide(lastFg);
        if (!targetFg.isAdded()) {
            getSupportFragmentManager().beginTransaction().remove(targetFg).commitAllowingStateLoss();
            ft.add(R.id.fragment_group, targetFg);
        }
        ft.show(targetFg);
        ft.commitAllowingStateLoss();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initToolbar() {
        setSupportActionBar(mToolbar);
        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        // 去掉标题
        actionBar.setDisplayShowTitleEnabled(false);
        mTitleTv.setText(R.string.home_pager);


    }

    @Override
    protected void initEventAndData() {

    }
}
