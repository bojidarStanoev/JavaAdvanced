package softuni.bg.mobilelele.service;

import org.springframework.stereotype.Service;
import softuni.bg.mobilelele.model.service.UserLoginServiceModel;

@Service
public interface UserServiceIfc {
    boolean login(UserLoginServiceModel userLoginServiceModel);
}
