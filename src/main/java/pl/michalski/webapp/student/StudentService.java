package pl.michalski.webapp.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import pl.michalski.webapp.school.SchoolRepository;

import java.util.List;
import java.util.UUID;

@Service
public class StudentService {

    private StudentRepository studentRepository;
    private SchoolRepository schoolRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository, SchoolRepository schoolRepository) {
        this.studentRepository = studentRepository;
        this.schoolRepository = schoolRepository;
    }

    //metoda, ktora zwraca obiekty z bazy danych
    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    // metoda, ktora zapisuje nowy obiekt w bazie danych
        //chce zapisac ucznia - imie i wiek
    //formularz --> obiekt StudentSave ---> controler (PostMapping)
    // --> StudentComponent --> zamiana z obiektu klasy StudentSave na Student

    public void saveNewStudent(StudentSave studentSave){
        Student student = new Student();
        student.setUuid(UUID.randomUUID());
        student.setName(studentSave.getName());
        student.setAge(studentSave.getAge());
        studentRepository.save(student);
    }

    public List<Student> getAllStudentsBySchool(UUID uuid){
//        return studentRepository
//                .findAllBySchool(schoolRepository.findByName(schoolName));
        return studentRepository.findAllBySchool_Uuid(uuid);

    }


}
