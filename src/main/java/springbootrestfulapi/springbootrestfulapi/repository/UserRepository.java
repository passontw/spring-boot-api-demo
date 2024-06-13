package springbootrestfulapi.springbootrestfulapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import springbootrestfulapi.springbootrestfulapi.entity.User;

public interface UserRepository  extends JpaRepository<User, Long> {


}
