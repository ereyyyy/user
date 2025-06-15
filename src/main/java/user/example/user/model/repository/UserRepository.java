package user.example.user.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import user.example.user.model.entitiy.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

}
