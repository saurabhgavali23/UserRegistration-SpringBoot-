package userregistration.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import userregistration.model.User;

import java.util.Optional;

@Repository
public interface UserRepository  extends JpaRepository<User,Integer> {

     Optional<User> findByEmail(String email);

    Optional<User> findByPassword(String password);
}
