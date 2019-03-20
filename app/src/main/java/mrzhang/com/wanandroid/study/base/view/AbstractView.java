package mrzhang.com.wanandroid.study.base.view;

/**
 * @author mrzhang
 * @date 2019/1/5
 *
 * view 基类
 */
public interface AbstractView {

    /**
     * Show error message
     *
     * @param errorMsg error message
     */
    void showErrorMsg(String errorMsg);

    /**
     * Use night mode
     *
     * @param isNightMode if is night mode
     */
    void useNightMode(boolean isNightMode);

    /**
     * Show error
     */
    void showError();

    /**
     * Show login view
     */
    void showLoginView();

    /**
     * Show logout view
     */
    void showLogoutView();

    /**
     * Show snackBar
     *
     * @param message Message
     */
    void showSnackBar(String message);

}
