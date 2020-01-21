package Nick_Maven.WebdriverAdv.Yandex.model;

public class User {
    private String userLogin;
    private String userPassword;

    public User(String login, String password){
        userLogin = login;
        userPassword =password;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
}