package pl.michalski.webapp.school;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
}
