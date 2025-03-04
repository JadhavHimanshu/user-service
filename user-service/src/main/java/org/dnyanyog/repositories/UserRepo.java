package org.dnyanyog.repositories;

import java.util.Optional;
import org.dnyanyog.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Component
public interface UserRepo extends JpaRepository<User, Long> {
  Optional<User> findByuserId(Long userId);

  Long deleteByuserId(Long userId);
}
