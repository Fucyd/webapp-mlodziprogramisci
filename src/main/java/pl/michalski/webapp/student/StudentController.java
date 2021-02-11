package pl.michalski.webapp.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.UUID;

@Controller
public class StudentController {

    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/")
    public String mainPage(Model model){
        List<Student> studentList = studentService.getAllStudents();
        model.addAttribute("studenciBazaDanych", studentList);
        return "index";
    }

    @GetMapping("/student/new")
    public String newStudentForm(Model model){
        StudentSave studentSave = new StudentSave();
        model.addAttribute("newStudent", studentSave);
        return "new-student-form";
    }

    @PostMapping("/student/new")
    public String newStudentProcessing(@ModelAttribute("newStudent") StudentSave studentSave){
        studentService.saveNewStudent(studentSave);
        return "redirect:/";
    }

    @GetMapping("/student/school/{uuid}")
    public String showStudentsBySchool(@PathVariable("schoolName") UUID uuid, Model model){
        List<Student> studentList = studentService.getAllStudentsBySchool(uuid);
        model.addAttribute("studentsBySchool", studentList);
        return "students-school";
    }




}
