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

}
