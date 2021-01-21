package pl.michalski.webapp.student;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.michalski.webapp.school.School;

import java.util.List;


public interface StudentRepository extends JpaRepository<Student,Integer> {
    List<Student> findAllBySchool_Name(String schoolName);
}
