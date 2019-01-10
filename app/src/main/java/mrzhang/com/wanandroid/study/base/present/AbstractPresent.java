package mrzhang.com.wanandroid.study.base.present;

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
    void detach();
}
