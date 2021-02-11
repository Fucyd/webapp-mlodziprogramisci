package pl.michalski.webapp.student;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;


public interface StudentRepository extends JpaRepository<Student,Integer> {
    List<Student> findAllBySchool_Uuid(UUID uuid);
}
