package pl.michalski.webapp.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }


    public List<User> getAllUsers(){
        return userRepository.findAll();
    }


    // wersja prosta- wersja polecam
    public boolean checkIfUserByEmailExists(String email){
        return userRepository.findByEmail(email).isPresent();
    }

    public void saveNewUser(UserSave userSave){
        User user = new User();
        Authority authority = new Authority();
        authority.setRole("ROLE_USER");
        HashSet<Authority> authorities = new HashSet<>();
        authorities.add(authority);
        user.setAuthorities(authorities);
        user.setUuid(UUID.randomUUID());
        user.setName(userSave.getName());
        user.setLastName(userSave.getLastName());
        user.setEmail(userSave.getEmail());
        user.setPassword(passwordEncoder.encode(userSave.getPassword()));
        userRepository.save(user);

    }

    @Transactional
    public void deleteUser(UUID uuid){
        userRepository.deleteByUuid(uuid);
    }
}
