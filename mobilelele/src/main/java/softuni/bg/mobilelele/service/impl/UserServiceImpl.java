package softuni.bg.mobilelele.service.impl;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import softuni.bg.mobilelele.model.entity.UserEntity;
import softuni.bg.mobilelele.model.service.UserLoginServiceModel;
import softuni.bg.mobilelele.repository.UserRepository;
import softuni.bg.mobilelele.service.UserServiceIfc;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserServiceIfc {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    public UserServiceImpl(PasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    @Override
    public boolean login(UserLoginServiceModel userLoginServiceModel) {
        Optional<UserEntity> byUsername = userRepository.findByUsername(userLoginServiceModel.name());

        if(byUsername.isEmpty()){
            return false;
        }
        else{
            return passwordEncoder.matches(userLoginServiceModel.rawPass(),byUsername.get().password());
        }

    }
}
