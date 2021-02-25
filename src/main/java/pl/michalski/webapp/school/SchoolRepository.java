package pl.michalski.webapp.school;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface SchoolRepository extends JpaRepository<School, Long> {
    School findByName(String name);
    Optional<School> findByUuid(UUID schoolUuid);
}
