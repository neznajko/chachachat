////////////////////////////////////////////////////////////////////////
package com.chachachat.service;
////////////////////////////////////////////////////////////////////////
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.authority
                                        .SimpleGrantedAuthority;
////////////////////////////////////////////////////////////////////////
import com.chachachat.repository.UserRepository;
import com.chachachat.model.User;
import com.chachachat.utils.AuthUtils;
////////////////////////////////////////////////////////////////////////
import java.util.List;
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
            .orElseThrow(() -> new RuntimeException("User not found"));
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
    public boolean existsByUsername( String username ){
        return userRepository.existsByUsername( username );
    }
    public List <User> findAll() {
        return userRepository.findAll();
    }
    public User currentUser() {
        return findByUsername( AuthUtils.getUsername());
    }
    public String changePassword( User user,
                                  String oldPassword,
                                  String newPassword,
                                  String retypePassword ){
        // check old password
        if( !passwordEncoder.matches( oldPassword, user.getPassword())){
            return "Old password is incorrect";
        }
        // check retyped password
        if( !newPassword.equals( retypePassword )){
            return "Retyped password didn't match";
        }
        // update db
        user.setPassword( passwordEncoder.encode( newPassword ));
        userRepository.save( user );

        return null;        
    }

    public void delete( User user ){
        userRepository.delete( user );
    }

    public List <String> findUsersByChatname( String chatname ){
        return userRepository.findUsersByChatname( chatname );
    }
}
////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////
//
// Exercise 1.3.1. (a) W r i t e a formal definition in the s t y l e of
// Definition 1.3.2 for the infimum or greatest l o w e r bound of a set
// (b) Now, state and prove a version o f Lemma 1.3.8 for greatest lower
// bounds.
//
// It's interesting that for real numbers there is a sup A for e v e r y
// non empty set A bounded from above, but this is not true for rational
// numbers; { q ∈ Q: q² < 2 } has neither m a x i m u m or supremum. The
// definition for infimum is more or less the same:
//
// Definition. A real number s is the greatest lower bound for a
// set A ⊆ R if it meets the following two criteria:
// (i) s is a lower bound for A;
// (ii) if b is any lower bound for A, then b ≤ s.
//
// Lemma. Assume s ∈ R is a lower bound for a set A ⊆ R. Then s = inf A
// if and only if, for every choice of ε > 0, there exists an element
// a ∈ A satisfying s + ε > a.
//
// => [ if s = inf A, then ∃ a ∈ A: s + ε > a, for any ε > 0 ]
// Let's pick some ε > 0, becoz s is infimum that is the greatest lower
// bound, s + ε is n o t a l o w e r bound, so there exist a: a < s + ε
// <= [ if for e v e r y ε > 0, ∃ a ∈ A: s + ε > a, t h e n s = inf A ]
// Here we have to p r o v e (ii) becoz (i) i s true by assumption, let
// b is some other lower bound and let s < b, if we take ε = b - s then
// from s + ε > a, w e ' l l get s + b - s > a, that is b > a, and b is
// not a lower bound, so by contradiction b ≤ s and s = inf A
//
////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////
