package bg.codexio.springdatademo.services;

import bg.codexio.springdatademo.exeptions.UserNameAlreadyExistsExeption;
import bg.codexio.springdatademo.exeptions.UserNotFoundExeption;

import java.math.BigDecimal;

public interface UserService {
    void register(String username, BigDecimal initialAmount) throws UserNameAlreadyExistsExeption;
    void addCount(BigDecimal amount,long id) throws UserNotFoundExeption;
}
