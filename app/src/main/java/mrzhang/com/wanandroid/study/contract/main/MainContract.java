package mrzhang.com.wanandroid.study.contract.main;

import mrzhang.com.wanandroid.study.base.present.AbstractPresent;
import mrzhang.com.wanandroid.study.base.view.AbstractView;

/**
 * @author mrzhang
 * @date 2019/1/9
 */
public interface MainContract {
    interface View extends AbstractView {
        /**
         * Show auto login view
         */
        void showAutoLoginView();

        /**
         * Show logout success
         */
        void showLogoutSuccess();

    }

    interface Presenter extends AbstractPresent<View> {
        /**
         * Set night mode state
         *
         * @param b current night mode state
         */
        void setNightModeState(boolean b);

        /**
         * Set current page
         *
         * @param page current page
         */
        void setCurrentPage(int page);

        /**
         * logout
         */
        void logout();
    }
}
