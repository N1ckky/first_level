package Nick_Maven.WebdriverAdv.Yandex.service;

import Nick_Maven.WebdriverAdv.Yandex.model.User;

public class UserCreator {
    private static final String USER_LOGIN = "nickTestQA";
    private static final String USER_PASWD = "mytestpassword";

    public static User withCredentialsFromProperty() {
        return new User(USER_LOGIN,USER_PASWD);
    }

    public static User withOwnCredentials(String login, String password) {
        return new User(login,password);
    }

}