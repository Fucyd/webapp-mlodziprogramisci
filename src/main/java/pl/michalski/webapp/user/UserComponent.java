package pl.michalski.webapp.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserComponent {

    private UserRepository userRepository;

    @Autowired
    public UserComponent(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public List<User> getAllUsers(){
        return userRepository.findAll();
    }


    public void saveNewUser(UserSave userSave){
        User user = new User();
        user.setName(userSave.getName());
        user.setLastName(userSave.getLastName());
        user.setEmail(userSave.getEmail());
        user.setPassword(userSave.getPassword());
        userRepository.save(user);

    }


}
