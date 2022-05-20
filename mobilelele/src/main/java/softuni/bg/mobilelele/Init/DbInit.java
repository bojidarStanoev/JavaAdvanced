package softuni.bg.mobilelele.Init;

import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import softuni.bg.mobilelele.model.entity.BrandEntity;
import softuni.bg.mobilelele.model.entity.Category;
import softuni.bg.mobilelele.model.entity.Model;
import softuni.bg.mobilelele.model.entity.UserEntity;
import softuni.bg.mobilelele.repository.BrandRepository;
import softuni.bg.mobilelele.repository.UserRepository;

import java.util.List;

@Component
public class DbInit  implements CommandLineRunner {
    private final BrandRepository brandRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    public DbInit(BrandRepository brandRepository, UserRepository userRepository, PasswordEncoder passwordEncoder){
        this.brandRepository=brandRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }
    @Override
    public void run(String... args) throws Exception {
    initializeBrandAndModels();
    initializeUsers();
    }
    private  void initializeUsers(){
    if(userRepository.count()==0){
        UserEntity admin = new UserEntity();
        admin.setActive(true).setUsername("admin").setPassword(passwordEncoder.encode("12345") ).setLastname("Adminov")
                .setFirstname("ADmin");

        userRepository.save(admin);
    }

    }
    private void initializeBrandAndModels(){
        if(brandRepository.count()==0){
            BrandEntity ford= new BrandEntity().setName("ford");
            Model fiesta = new Model("fiesta", Category.Car,1967,2002,"https://images.ams.bg/images/galleries/107476/ford-fiesta-1460777781_big.jpg",ford);
            Model escort = new Model("escort",Category.Car,1968,2002,"https://amklassiek.nl/wp-content/uploads/2020/09/20200911_190649-1_1599847959165-758x510.jpg",ford);

            ford.setModels(List.of(fiesta,escort));
            fiesta.setBrand(ford);
            escort.setBrand(ford);
            brandRepository.save(ford);
        }

    }
}
