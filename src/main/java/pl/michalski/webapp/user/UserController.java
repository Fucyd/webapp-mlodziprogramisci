package pl.michalski.webapp.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@Controller
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user")
    public String mainPageUsers(Model model) {
        List<User> userList = userService.getAllUsers();
        model.addAttribute("usersFromDatabase", userList);
        return "user-page";
    }

    @GetMapping("/registration")
    public String newUserForm(Model model) {
        UserForm userForm = new UserForm();
        model.addAttribute("newUser", userForm);
        return "new-user-form";
    }

    @PostMapping("/registration")
    public String newUserProcessing(@ModelAttribute("newUser") @Valid UserForm userForm, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) return "new-user-form";
        if(!userForm.getPassword().equals(userForm.getConfirmPassword())) {
            bindingResult.rejectValue("confirmPassword", "confirmPassword", "Hasła nie są identyczne");
            return "new-user-form";
        }
        if(userService.checkIfUserByEmailExists(userForm.getEmail())){
            bindingResult.rejectValue("email", "emailExists", "Hasła nie są identyczne");
            return "new-user-form";
        }
        // sprawdzenie czy uzytkownik o podanym email juz istnieje.
        try{
            userService.saveNewUser(userForm);
        }catch (RuntimeException exception){
            exception.printStackTrace();
        }
        return "redirect:/user";
    }

    @GetMapping("/user/delete/{uuid}")
    public String deleteUser(@PathVariable("uuid") UUID uuid){
        userService.deleteUser(uuid);
        return "redirect:/user";
    }
}
