package mrzhang.com.wanandroid.study.base.present;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import mrzhang.com.wanandroid.study.base.view.AbstractView;
import mrzhang.com.wanandroid.study.core.DataManager;

/**
 * @author mrzhang
 * @date 2019/1/5
 */
public class BasePresent<T extends AbstractView> implements AbstractPresent<T> {

    protected T mView;
    private CompositeDisposable compositeDisposable;
    private DataManager mDataManager;

    public BasePresent(DataManager dataManager) {
        this.mDataManager = dataManager;
    }

    @Override
    public void attachView(T view) {
        this.mView = view;
    }

    @Override
    public void detachView() {
        this.mView = null;
        if (compositeDisposable != null) {
            compositeDisposable.clear();
        }
    }

    @Override
    public boolean getNightModeState() {
        return mDataManager.getNightModeState();
    }

    @Override
    public int getCurrentPage() {
        return mDataManager.getCurrentPage();
    }

    protected void addSubscribe(Disposable disposable) {
        if (null == compositeDisposable) {
            compositeDisposable = new CompositeDisposable();
        }
        compositeDisposable.add(disposable);
    }



}
