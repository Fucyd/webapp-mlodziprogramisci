package pl.michalski.webapp.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

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


    // wersja prosta- wersja polecam
    public boolean checkIfUserByEmailExists(String email){
        return userRepository.findByEmail(email).isPresent();
    }



    // ciekawostka - wersja trudna - wersja nie polecam
//    public boolean checkIfUserByEmailExistsVersionTwo(String email){
//        boolean exists = false;
//        List<User> userList = userRepository.findAll();
//        for(User userFromList: userList){
//            exists = userFromList.getEmail().equals(email);
//            if(exists) return exists;
//        }
//
//        return exists;
//    }





    public void saveNewUser(UserSave userSave){
        User user = new User();
        user.setUuid(UUID.randomUUID());
        user.setName(userSave.getName());
        user.setLastName(userSave.getLastName());
        user.setEmail(userSave.getEmail());
        user.setPassword(userSave.getPassword());
        userRepository.save(user);

    }

    @Transactional
    public void deleteUser(UUID uuid){
        userRepository.deleteByUuid(uuid);
    }
}
