package mrzhang.com.wanandroid.study.base.present;

import io.reactivex.disposables.Disposable;
import mrzhang.com.wanandroid.study.base.view.AbstractView;

/**
 * @author mrzhang
 * @date 2019/1/5
 * <p>
 * Present 基类
 */
public interface AbstractPresent<T extends AbstractView> {
    /**
     * 注入view
     * @param view
     */
    void attachView(T view);

    /**
     * 回收view
     */
    void detachView();

    /**
     * Get night mode state
     *
     * @return if is night mode
     */
    boolean getNightModeState();

    /**
     * Get current page
     *
     * @return current page
     */
    int getCurrentPage();

    /**
     * Set login status
     *
     * @param loginStatus login status
     */
    void setLoginStatus(boolean loginStatus);

    /**
     * Get login status
     *
     * @return if is login status
     */
    boolean getLoginStatus();

    /**
     * Get login account
     *
     * @return login account
     */
    String getLoginAccount();

    /**
     * Set login status
     *
     * @param account account
     */
    void setLoginAccount(String account);

    /**
     * Set login password
     *
     * @param password password
     */
    void setLoginPassword(String password);

    /**
     * Add rxBing subscribe manager
     *
     * @param disposable Disposable
     */
    void addRxBindingSubscribe(Disposable disposable);
}
