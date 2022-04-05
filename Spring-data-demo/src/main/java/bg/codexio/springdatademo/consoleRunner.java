package bg.codexio.springdatademo;

import bg.codexio.springdatademo.exeptions.UserNameAlreadyExistsExeption;
import bg.codexio.springdatademo.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class consoleRunner  implements CommandLineRunner {
    private final UserService userService;

    public consoleRunner(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void run(String... args) throws Exception {
        try {

        this.userService.register("pesho",new BigDecimal(1000));
        }catch (UserNameAlreadyExistsExeption e){
            System.out.println(e.getClass().getSimpleName());
        }
    this.userService.addCount(new BigDecimal(5000),1);
    }
}
