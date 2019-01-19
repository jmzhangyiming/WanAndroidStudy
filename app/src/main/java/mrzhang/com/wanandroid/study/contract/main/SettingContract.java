package mrzhang.com.wanandroid.study.contract.main;

import mrzhang.com.wanandroid.study.base.present.AbstractPresent;
import mrzhang.com.wanandroid.study.base.view.AbstractView;

/**
 * @author mrzhang
 * @date 2019/1/13
 */
public interface SettingContract {

    interface View extends AbstractView {

    }

    interface Prensent extends AbstractPresent<View> {

        /**
         * Set night mode state
         *
         * @param b current night mode state
         */
        void setNightModeState(boolean b);
    }

}
