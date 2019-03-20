package mrzhang.com.wanandroid.study.contract.main;

import mrzhang.com.wanandroid.study.base.present.AbstractPresent;
import mrzhang.com.wanandroid.study.base.view.AbstractView;

/**
 * @author mrzhang
 * @date 2019/2/28
 */
public interface RegisterContract {

    interface View extends AbstractView {
        /**
         * Show register data
         */
        void showRegisterSuccess();
    }

    interface Presenter extends AbstractPresent<View> {
        /**
         * 注册
         * http://www.wanandroid.com/user/register
         *
         * @param username user name
         * @param password password
         * @param rePassword re password
         */
        void getRegisterData(String username, String password, String rePassword);
    }

}
