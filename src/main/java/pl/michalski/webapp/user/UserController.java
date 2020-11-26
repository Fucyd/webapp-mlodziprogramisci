package pl.michalski.webapp.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.michalski.webapp.student.Student;
import pl.michalski.webapp.student.StudentSave;

import java.util.List;

@Controller
public class UserController {
    private UserComponent userComponent;

    @Autowired
    public UserController(UserComponent userComponent) {
        this.userComponent = userComponent;
    }

    @GetMapping("/user")
    public String mainPageUsers(Model model) {
        List<User> userList = userComponent.getAllUsers();
        model.addAttribute("usersFromDatabase", userList);
        return "user-page";
    }

    @GetMapping("/user/new")
    public String newUserForm(Model model) {
        UserSave userSave = new UserSave();
        model.addAttribute("newUser", userSave);
        return "new-user-form";
    }

    @PostMapping("/user/new")
    public String newUserProcessing(@ModelAttribute("newUser") UserSave userSave) {
        userComponent.saveNewUser(userSave);
        return "redirect:/";
    }
}