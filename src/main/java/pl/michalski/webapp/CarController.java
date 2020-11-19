package pl.michalski.webapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class CarController {
    private CarRepository carRepository;

    @Autowired
    public CarController(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @GetMapping("/car")
    public String carPage(Model model){
        //lista, ktora posiada obiekty z bazy danych (carRepository.findAll())
//        List<Car> carList = carRepository.findAll(); (OPCJONALE)
        //dodaje ją jako atrybut do modelu strony
        model.addAttribute("cars", carRepository.findAll());
        //zwracam plik html, który wyświetli mi samochody z bazy danych
        return "car-page";
    }
}
