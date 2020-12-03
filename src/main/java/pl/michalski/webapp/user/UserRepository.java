package pl.michalski.webapp.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, Integer> {
    void deleteByUuid(UUID uuid);
}
