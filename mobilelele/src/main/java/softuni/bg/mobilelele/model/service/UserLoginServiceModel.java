package softuni.bg.mobilelele.model.service;

public class UserLoginServiceModel {
    private  String name;
    private String rawPass;



    public String name() {
        return name;
    }

    public UserLoginServiceModel setName(String name) {
        this.name = name;
        return this;
    }

    public String rawPass() {
        return rawPass;
    }

    public UserLoginServiceModel setRawPass(String rawPass) {
        this.rawPass = rawPass;
        return this;
    }
}
