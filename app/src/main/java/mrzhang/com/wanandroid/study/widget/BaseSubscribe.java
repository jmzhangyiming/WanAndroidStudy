package mrzhang.com.wanandroid.study.widget;

import android.text.TextUtils;

import io.reactivex.subscribers.ResourceSubscriber;
import mrzhang.com.wanandroid.study.app.WanAndroidApp;
import mrzhang.com.wanandroid.study.base.view.AbstractView;
import mrzhang.com.wanandroid.study.core.http.exception.ServerException;
import mrzhang.com.wanandroid.study.utils.logger.LogHelper;
import mrzhang.com.wanandroid.wanandroidstudy.R;
import retrofit2.HttpException;

/**
 * @author mrzhang
 * @date 2019/1/26
 */
public abstract class BaseSubscribe<T> extends ResourceSubscriber<T> {

    private AbstractView mView;
    private String mErrorMsg;
    private boolean isShowError = true;

    protected BaseSubscribe(AbstractView view){
        this.mView = view;
    }

    protected BaseSubscribe(AbstractView view, String errorMsg){
        this.mView = view;
        this.mErrorMsg = errorMsg;
    }

    protected BaseSubscribe(AbstractView view, boolean isShowError){
        this.mView = view;
        this.isShowError = isShowError;
    }

    protected BaseSubscribe(AbstractView view, String errorMsg, boolean isShowError){
        this.mView = view;
        this.mErrorMsg = errorMsg;
        this.isShowError = isShowError;
    }

    @Override
    public void onComplete() {

    }

    @Override
    public void onError(Throwable e) {
        if (mView == null) {
            return;
        }
        if (mErrorMsg != null && !TextUtils.isEmpty(mErrorMsg)) {
            mView.showErrorMsg(mErrorMsg);
        } else if (e instanceof ServerException) {
            mView.showErrorMsg(e.toString());
        } else if (e instanceof HttpException) {
            mView.showErrorMsg(WanAndroidApp.getInstance().getString(R.string.http_error));
        } else {
            mView.showErrorMsg(WanAndroidApp.getInstance().getString(R.string.unKnown_error));
            LogHelper.d(e.toString());
        }
        if (isShowError) {
            mView.showError();
        }
    }
}
