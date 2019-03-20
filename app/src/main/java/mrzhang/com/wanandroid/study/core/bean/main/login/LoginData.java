package mrzhang.com.wanandroid.study.core.bean.main.login;

/**
 * @author mrzhang
 * @date 2019/2/27
 */
public class LoginData {

    private String username;
    private String password;

    public String getRepassword() {
        return repassword;
    }

    public void setRepassword(String repassword) {
        this.repassword = repassword;
    }

    private String repassword;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
