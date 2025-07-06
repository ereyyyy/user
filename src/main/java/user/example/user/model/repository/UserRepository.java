package user.example.user.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import user.example.user.model.entitiy.UserEntity;
import user.example.user.model.enums.UserType;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    java.util.List<UserEntity> findByUserType(UserType userType);

    java.util.Optional<UserEntity> findByEmail(String email);

}
