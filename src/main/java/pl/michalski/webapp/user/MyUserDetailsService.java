package pl.michalski.webapp.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.michalski.webapp.user.Authority;
import pl.michalski.webapp.user.User;
import pl.michalski.webapp.user.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class MyUserDetailsService implements UserDetailsService {
    private UserRepository userRepository;

    @Autowired
    public MyUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(s).get();
        return new org.springframework.security.core.userdetails.User(
                user.getEmail(), user.getPassword(),
                user.getEnabled(), user.getAccountNonExpired(),
                user.getCredentialsNonExpired(), user.getAccountNonLocked(),
                getAuthorities(user.getAuthorities()));
    }

    private List<GrantedAuthority> getAuthorities(Set<Authority> authorities) {
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        for (Authority authority : authorities) {
            grantedAuthorities.add(new SimpleGrantedAuthority(authority.getRole()));
        }
        return grantedAuthorities;
    }
}
