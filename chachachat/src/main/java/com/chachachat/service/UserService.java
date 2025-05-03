////////////////////////////////////////////////////////////////////////
package com.chachachat.service;
////////////////////////////////////////////////////////////////////////
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
////////////////////////////////////////////////////////////////////////
import com.chachachat.repository.UserRepository;
import com.chachachat.model.User;
////////////////////////////////////////////////////////////////////////
@Service
public class UserService {
    
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService( UserRepository userRepository,
                        PasswordEncoder passwordEncoder ){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }
    public User findByUsername( String username ){
        return userRepository
            .findByUsername( username )
            .orElseThrow(() -> new RuntimeException( "User not found" ));
    }
    public User register( String username, String password ){
        password = passwordEncoder.encode( password );
        return userRepository.save( new User( username, password ));
    }
    public UserDetails getUserDetails( String username ){
        User user = findByUsername( username );
        return org.springframework.security.core.userdetails.User
            .builder()
            .username( user.getUsername())
            .password( user.getPassword())
            .authorities( new SimpleGrantedAuthority( "NONE" ))
            .build();
    }
}
////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////
// Exercise 1.3.1. (a) W r i t e a formal definition in the s t y l e of
// Definition 1.3.2 for the infimum or greatest l o w e r bound of a set.
// (b) Now, state and prove a version o f Lemma 1.3.8 for greatest lower
// bounds.
////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////
