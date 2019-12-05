package by.gsu.pms.lr12.repo;

import by.gsu.pms.lr12.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
    User findByUserId(Long id);
}
