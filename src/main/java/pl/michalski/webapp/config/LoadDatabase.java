package pl.michalski.webapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
import pl.michalski.webapp.school.School;
import pl.michalski.webapp.school.SchoolRepository;
import pl.michalski.webapp.student.Student;
import pl.michalski.webapp.student.StudentRepository;
import pl.michalski.webapp.user.Authority;
import pl.michalski.webapp.user.AuthorityRepository;

import java.util.UUID;

@Service
public class LoadDatabase implements CommandLineRunner {
    private AuthorityRepository authorityRepository;
    private StudentRepository studentRepository;
    private SchoolRepository schoolRepository;
    @Autowired
    public LoadDatabase(AuthorityRepository authorityRepository, StudentRepository studentRepository, SchoolRepository schoolRepository) {
        this.authorityRepository = authorityRepository;
        this.studentRepository = studentRepository;
        this.schoolRepository = schoolRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        addAuthorities();
        addStudent1();
        addStudent2();
        addSchool();
    }

    private void addAuthorities(){
        Authority userAuthority = new Authority();
        userAuthority.setRole("ROLE_USER");
        authorityRepository.save(userAuthority);

        Authority moderatorAuthority = new Authority();
        moderatorAuthority.setRole("ROLE_MODERATOR");
        authorityRepository.save(moderatorAuthority);

        Authority adminAuthority = new Authority();
        adminAuthority.setRole("ROLE_ADMIN");
        authorityRepository.save(adminAuthority);
    }

    private void addStudent1(){
        Student student = new Student();
        student.setUuid(UUID.randomUUID());
        student.setName("Ksawery");
        student.setAge(18);
        studentRepository.save(student);
    }


    private void addStudent2(){
        Student student = new Student();
        student.setUuid(UUID.randomUUID());
        student.setName("Jacek");
        student.setAge(17);
        studentRepository.save(student);
    }

    private void addSchool(){
        School school = new School();
        school.setUuid(UUID.randomUUID());
        school.setName("EZN");
        school.setCity("Wrocław");
        schoolRepository.save(school);
    }




}
