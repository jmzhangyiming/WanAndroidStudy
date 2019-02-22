package mrzhang.com.wanandroid.study.base.fragment;

import mrzhang.com.wanandroid.study.base.present.BasePresent;

/**
 * @author mrzhang
 * @date 2019/1/13
 */
public abstract class BaseRootFragment<T extends BasePresent> extends BaseFragment<T> {

    @Override
    protected void initEventAndData() {
        
    }

    @Override
    public void showError() {

    }
}
