package pl.michalski.webapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
import pl.michalski.webapp.user.Authority;
import pl.michalski.webapp.user.AuthorityRepository;

@Service
public class LoadDatabase implements CommandLineRunner {
    private AuthorityRepository authorityRepository;

    @Autowired
    public LoadDatabase(AuthorityRepository authorityRepository) {
        this.authorityRepository = authorityRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        addAuthorities();
    }

    private void addAuthorities(){
        Authority userAuthority = new Authority();
        userAuthority.setRole("ROLE_USER");
        authorityRepository.save(userAuthority);

        Authority moderatorAuthority = new Authority();
        moderatorAuthority.setRole("ROLE_MODERATOR");
        authorityRepository.save(moderatorAuthority);

        Authority adminAuthority = new Authority();
        adminAuthority.setRole("ROLE_ADMIN");
        authorityRepository.save(adminAuthority);
    }



}
