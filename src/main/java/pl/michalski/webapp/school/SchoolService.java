package pl.michalski.webapp.school;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.michalski.webapp.student.Student;
import pl.michalski.webapp.student.StudentRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class SchoolService {
    private SchoolRepository schoolRepository;
    private StudentRepository studentRepository;
    @Autowired
    public SchoolService(SchoolRepository schoolRepository, StudentRepository studentRepository) {
        this.schoolRepository = schoolRepository;
        this.studentRepository = studentRepository;
    }

    public List<School> getAllSchools(){
        return schoolRepository.findAll();
    }

    public void saveSchool(SchoolForm schoolForm){
        School school = new School();
        school.setUuid(UUID.randomUUID());
        school.setName(schoolForm.getName());
        school.setCity(schoolForm.getCity());
        schoolRepository.save(school);
    }

    @Transactional
    public String addStudentToSchool(UUID studentUuid, UUID schoolUuid) {
        Optional<Student> student = studentRepository.findByUuid(studentUuid);
        Optional<School> school = schoolRepository.findByUuid(schoolUuid);
        if(student.isEmpty() || school.isEmpty()){
             return "redirect:/";
        }
        //wziac liste uczniow ze znalezionej szkoly i dodaj do niej ucznia
        student.get().setSchool(school.get());
        school.get().getStudents().add(student.get());
        return "redirect:/student/school/" + schoolUuid;
    }
}
