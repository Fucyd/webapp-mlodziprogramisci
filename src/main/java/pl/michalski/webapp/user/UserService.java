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
    private AuthorityRepository authorityRepository;
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(AuthorityRepository authorityRepository,
                       UserRepository userRepository,
                       PasswordEncoder passwordEncoder) {
        this.authorityRepository = authorityRepository;
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

    public void saveNewUser(UserForm userForm){
        User user = new User();

        user.setAuthorities(getUserRole());
        user.setUuid(UUID.randomUUID());
        user.setName(userForm.getName());
        user.setLastName(userForm.getLastName());
        user.setEmail(userForm.getEmail());
        user.setPassword(passwordEncoder.encode(userForm.getPassword()));
        userRepository.save(user);

    }

    //Stworzyć metodę prywatną, która zwróci HashSet<Authority> o nazwie getUserRole()
    // która ma pobrać z  bazy danych Obiekt Roli Użytkownika (Authority),
    // którego pole Role jest "ROLE_USER"
    // i dodać ten obiekt do nowego HashSetu. [ HashSet<Authority> hashSet = new Hash...]
    // na koniec zwrócić ten hashSet.

    private HashSet<Authority> getUserRole(){
        Authority authority = authorityRepository.findByRole("ROLE_USER").get();
        HashSet<Authority> authorities = new HashSet<>();
        authorities.add(authority);
        return authorities;
    }


    @Transactional
    public void deleteUser(UUID uuid){
        userRepository.deleteByUuid(uuid);
    }
}
