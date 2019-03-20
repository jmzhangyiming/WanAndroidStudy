package mrzhang.com.wanandroid.study.contract.main;

import mrzhang.com.wanandroid.study.base.present.AbstractPresent;
import mrzhang.com.wanandroid.study.base.view.AbstractView;

/**
 * @author mrzhang
 * @date 2019/2/23
 */
public interface LoginContract {

    interface View extends AbstractView {

        /**
         * Show login data
         *
         */
        void showLoginSuccess();
    }

    interface Presenter extends AbstractPresent<View> {

        /**
         * Get Login data
         *
         * @param username user name
         * @param password password
         */
        void getLoginData(String username, String password);
    }
}
