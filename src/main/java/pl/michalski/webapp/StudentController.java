package pl.michalski.webapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class StudentController {

    private StudentRepository studentRepository;
    private CarRepository carRepository;
    @Autowired
    public StudentController(StudentRepository studentRepository, CarRepository carRepository) {
        this.studentRepository = studentRepository;
        this.carRepository = carRepository;
    }

    @GetMapping("/")
    public String mainPage(Model model){
        List<Student> studentList = studentRepository.findAll();
        model.addAttribute("studenciBazaDanych", studentList);
        return "index";
    }

    @GetMapping("/car")
    public String carPage(Model model){
        //lista, ktora posiada obiekty z bazy danych (carRepository.findAll())
        //dodaje ją jako atrybut do modelu strony
        //zwracam plik html, który wyświetli mi samochody z bazy danych
        return "0";
    }
}
