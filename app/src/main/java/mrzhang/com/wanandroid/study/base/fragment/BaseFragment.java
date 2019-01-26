package mrzhang.com.wanandroid.study.base.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

import javax.inject.Inject;

import dagger.android.support.AndroidSupportInjection;
import mrzhang.com.wanandroid.study.base.present.AbstractPresent;
import mrzhang.com.wanandroid.study.base.view.AbstractView;

/**
 * @author mrzhang
 * @date 2019/1/13
 */
public abstract class BaseFragment<T extends AbstractPresent> extends AbstractSimpleFragment implements AbstractView {

    @Inject
    protected T mPresent;

    @Override
    public void onAttach(Context context) {
        AndroidSupportInjection.inject(this);
        super.onAttach(context);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (mPresent != null) {
            mPresent.attachView(this);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (mPresent != null) {
            mPresent.detach();
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        if (mPresent != null) {
            mPresent = null;
        }
    }

    @Override
    public void showErrorMsg(String errorMsg) {
        if (isAdded()) {

        }
    }

    @Override
    public void useNightMode(boolean isNightMode) {

    }
}
