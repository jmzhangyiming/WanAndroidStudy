package mrzhang.com.wanandroid.study.ui.main.activity;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import butterknife.BindView;
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
