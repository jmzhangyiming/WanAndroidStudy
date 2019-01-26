package mrzhang.com.wanandroid.study.widget;

import android.text.TextUtils;

import io.reactivex.subscribers.ResourceSubscriber;
import mrzhang.com.wanandroid.study.base.view.AbstractView;

/**
 * @author mrzhang
 * @date 2019/1/26
 */
public abstract class BaseSubscribe<T> extends ResourceSubscriber<T> {

    private AbstractView mView;
    private String mErrorMsg;

    protected BaseSubscribe(AbstractView view, String errorMsg){
        this.mView = view;
        this.mErrorMsg = errorMsg;
    }

    @Override
    public void onComplete() {

    }

    @Override
    public void onError(Throwable t) {
        if (mView == null) return;
        if (mErrorMsg != null && !TextUtils.isEmpty(mErrorMsg)) {
            mView.showErrorMsg(mErrorMsg);
        }
    }
}
