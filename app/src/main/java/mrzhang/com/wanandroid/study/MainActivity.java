package mrzhang.com.wanandroid.study;

import android.os.Bundle;

import mrzhang.com.wanandroid.wanandroidstudy.R;
import mrzhang.com.wanandroid.study.base.activity.BaseActivity;
import mrzhang.com.wanandroid.study.contract.main.MainContract;
import mrzhang.com.wanandroid.study.presenter.main.MainPresent;

/**
  * @author zhangyiming
  * @date 2019/1/4
  */
public class MainActivity extends BaseActivity<MainPresent> implements MainContract.View {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected int getLayoutId() {
        return 0;
    }

    @Override
    protected void initToolbar() {

    }

    @Override
    protected void initEventAndData() {

    }
}
