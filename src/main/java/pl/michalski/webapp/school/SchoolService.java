package pl.michalski.webapp.school;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class SchoolService {
    private SchoolRepository schoolRepository;

    @Autowired
    public SchoolService(SchoolRepository schoolRepository) {
        this.schoolRepository = schoolRepository;
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
}
