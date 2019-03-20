package mrzhang.com.wanandroid.study.core.event;

/**
 * @author mrzhang
 * @date 2019/2/27
 */
public class LoginEvent {

    private boolean isLogin;

    public boolean isLogin() {
        return isLogin;
    }

    public void setLogin(boolean login) {
        isLogin = login;
    }

    public LoginEvent(boolean isLogin) {

        this.isLogin = isLogin;
    }
}
