package bg.codexio.springdatademo.services;

import bg.codexio.springdatademo.exeptions.UserNameAlreadyExistsExeption;
import bg.codexio.springdatademo.exeptions.UserNotFoundExeption;
import bg.codexio.springdatademo.models.Account;
import bg.codexio.springdatademo.models.User;
import bg.codexio.springdatademo.repository.AccountRepository;
import bg.codexio.springdatademo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final AccountRepository accountRepository;

    public UserServiceImpl(UserRepository userRepository, AccountRepository accountRepository) {
        this.userRepository = userRepository;
        this.accountRepository = accountRepository;
    }

    @Override
    public void register(String username, BigDecimal initialAmount) throws UserNameAlreadyExistsExeption {
    if(this.userRepository.existsByName(username)){
        throw new UserNameAlreadyExistsExeption();
    }
        var user= new User();
    user.setName(username);
    user.setAge(19);
    this.userRepository.save(user);
    var firstAccount = new Account();
    firstAccount.setBalance(initialAmount);
    firstAccount.setUser(user);
    this.accountRepository.save(firstAccount);
    }

    @Override
    public void addCount(BigDecimal amount, long id) throws  UserNotFoundExeption {
        User user= this.userRepository.findById(id).orElseThrow(UserNotFoundExeption::new);
        var newAccount = new Account();
        newAccount.setBalance(amount);
        newAccount.setUser(user);
        this.accountRepository.save(newAccount);
    }
}
