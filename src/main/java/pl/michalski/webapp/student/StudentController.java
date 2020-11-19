package pl.michalski.webapp.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StudentController {

    private StudentComponent studentComponent;

    @Autowired
    public StudentController(StudentComponent studentComponent) {
        this.studentComponent = studentComponent;
    }

    @GetMapping("/")
    public String mainPage(Model model){
        List<Student> studentList = studentComponent.returnAllStudents();
        model.addAttribute("studenciBazaDanych", studentList);
        return "index";
    }

    @GetMapping("/student/new")
    public String showFormNewStudent(Model model){
        model.addAttribute("newStudent", new StudentSave());
        return "new-student-form";
    }

    @PostMapping("/student/new")
    public String formNewStudentProcessing(@ModelAttribute("newStudent") StudentSave studentSave){
        studentComponent.saveNewStudent(studentSave);
        return "redirect:/";
    }

}
