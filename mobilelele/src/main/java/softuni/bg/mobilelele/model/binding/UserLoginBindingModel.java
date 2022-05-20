package softuni.bg.mobilelele.model.binding;

public class UserLoginBindingModel {
    private String username;
    private String password;

    public String username() {
        return username;
    }

    public UserLoginBindingModel setUsername(String username) {
        this.username = username;
        return this;
    }

    public String password() {
        return password;
    }

    public UserLoginBindingModel setPassword(String password) {
        this.password = password;
        return this;
    }
}
