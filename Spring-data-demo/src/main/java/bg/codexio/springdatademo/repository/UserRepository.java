package bg.codexio.springdatademo.repository;

import bg.codexio.springdatademo.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    boolean existsByName(String name);
}
