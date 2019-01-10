package mrzhang.com.wanandroid.study.contract.main;

import mrzhang.com.wanandroid.study.base.present.AbstractPresent;
import mrzhang.com.wanandroid.study.base.view.AbstractView;

/**
 * @author mrzhang
 * @date 2019/1/5
 */
public interface SplashContract {

    interface View extends AbstractView {
        // 跳转到主界面
        void jumpToMain();
    }

    interface Present extends AbstractPresent<View> {

    }

}
