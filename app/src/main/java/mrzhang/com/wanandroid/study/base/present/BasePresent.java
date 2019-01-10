package mrzhang.com.wanandroid.study.base.present;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import mrzhang.com.wanandroid.study.base.view.AbstractView;

/**
 * @author mrzhang
 * @date 2019/1/5
 */
public class BasePresent<T extends AbstractView> implements AbstractPresent<T> {

    private T mView;
    private CompositeDisposable compositeDisposable;

    @Override
    public void attachView(T view) {
        this.mView = view;
    }

    @Override
    public void detach() {
        this.mView = null;
    }

    protected void addSubscribe(Disposable disposable) {
        if (null == compositeDisposable) {
            compositeDisposable = new CompositeDisposable();
        }
        compositeDisposable.add(disposable);
    }


}
