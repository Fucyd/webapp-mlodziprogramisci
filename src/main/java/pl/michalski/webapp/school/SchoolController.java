package pl.michalski.webapp.school;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.michalski.webapp.user.UserForm;

import javax.validation.Valid;
import java.util.UUID;

@Controller
public class SchoolController {

    private SchoolService schoolService;

    @Autowired
    public SchoolController(SchoolService schoolService) {
        this.schoolService = schoolService;
    }


    @GetMapping("/school")
    public String getAllSchools(Model model){
        model.addAttribute("allSchools", schoolService.getAllSchools());
        return "all-schools";
    }

    @GetMapping("/school/new")
    public String newSchoolForm(Model model) {
        SchoolForm schoolForm = new SchoolForm();
        model.addAttribute("newSchool", schoolForm);
        return "new-school-form";
    }

    @PostMapping("/school/new")
    public String processNewSchoolForm(@ModelAttribute("newSchool") @Valid SchoolForm schoolForm,
                                       BindingResult result){
        if(result.hasErrors()){
            return "new-school-form";
        }
        schoolService.saveSchool(schoolForm);
        return "redirect:/school";
    }

    @GetMapping("/student/school/add/{studentUuid}")
    public String addStudentToSchoolPage(@PathVariable("studentUuid") UUID studentUuid,
                                      Model model){
        model.addAttribute("schools", schoolService.getAllSchools());
        model.addAttribute("studentUuid", studentUuid);
        return "add-student-to-school-page";
    }

    @GetMapping("/student/school/add/{studentUuid}/{schoolUuid}")
    public String processAddStudentToSchool(@PathVariable("studentUuid") UUID studentUuid,
                                            @PathVariable("schoolUuid") UUID schoolUuid){
        return schoolService.addStudentToSchool(studentUuid, schoolUuid);

    }
}
