package softuni.bg.mobilelele.web;

import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import softuni.bg.mobilelele.model.binding.UserLoginBindingModel;
import softuni.bg.mobilelele.model.service.UserLoginServiceModel;
import softuni.bg.mobilelele.service.impl.UserServiceImpl;

@Controller

public class UserLoginController {
    private final UserServiceImpl userService;
    private static Logger LOGGER= LoggerFactory.getLogger(UserLoginController.class);

    public UserLoginController(UserServiceImpl userService) {

        this.userService = userService;
    }

    @GetMapping("/users/login")
    public String login(){
        return "auth-login";
    }
    @PostMapping("/users/login")
    public String login(UserLoginBindingModel userLoginBindingModel){
    ///TODO
        boolean loginSuccessful=userService.login(new UserLoginServiceModel().setName(userLoginBindingModel.username())
                .setRawPass(userLoginBindingModel.password()));
        LOGGER.info("User tried to login with {} success={}?",userLoginBindingModel.username(),loginSuccessful);
        return "redirect:/users/login";
    }
}
