////////////////////////////////////////////////////////////////////////////////
package com.chachachat.config;
////////////////////////////////////////////////////////////////////////////////
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.authentication.AuthenticationManager;
////////////////////////////////////////////////////////////////////////////////
import com.chachachat.service.UserService;
////////////////////////////////////////////////////////////////////////////////
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public UserDetailsService userDetailsService( UserService userService ){
        return username -> userService.getUserDetails( username );
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain( HttpSecurity http ) throws Exception {
        http.authorizeHttpRequests( auth -> auth
                .requestMatchers(
                        "/h2-console/**",
                        "/webjars/**",
                        "/css/**",
                        "/js/**",
                        "/",
                        "/home",
                        "/register",
                        "/login"
                ).permitAll()
                .anyRequest().authenticated()
        ).formLogin( form -> form
                .loginPage( "/login" )
                .defaultSuccessUrl( "/welcome", true )
        ).logout( logout -> logout
                .logoutUrl( "/logout" )
                .logoutSuccessUrl( "/home" )
        );

        http.csrf(csrf -> csrf.disable());
        http.headers(headers -> headers.frameOptions(frame -> frame.disable()));

        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager( AuthenticationConfiguration authConfig )
    throws Exception {
        return authConfig.getAuthenticationManager();
    }
}
////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
// 38. Tyrion, Cersei, and ten o t h e r people are sitting at a
// round table, with their s e a t i n g arrangement having been
// randomly assigned. What is the probability t h a t Tyrion and
// Cersei are sitting next to each other? Find this i n two ways:
// (a) using a sample space of size 12!, w h e r e an outcome is
// fully detailed about the seating; (b) using a m u c h smaller
// sample s p a c e, which f o c u s e s o n Tyrion a n d Cersei.
//
// T - Tyrion    _ so we can put the Letters against the numbers
// C - Cersei    _ o f a c l o c k like: T B V G M U I W Z C G A,
// B - Betty     _                       1 2 3 4 5 6 7 8 9 1 1 1
// V - Veronika  _                                         0 1 2
// G - Gwendolyn _ here between T y r i o n (at one o'clock) and
// M - Mazola    _ Cersei (at ten o'clock) are sitting Gwendolyn
// U - Ulrich    _ and Anton. So there a r e 12! permutations of
// A - Anton     _ the letters, i f T is sitting at 1, C must be
// B - Bobi      _ at 2 or 12 and there a r e 2*10! such configs,
// I - Isaac     _ so the probability is P = 12*2*10!/12! = 2/11
// W - Winona    _
// Z - Zoe       _ This is interesting becoz we c a n delete not
//                 only clock's hours, but also the other people
// not participating in The G a m e of Thrones, and get the same
// result, i f T is sitting somewhere there are 11 options for C
// and only two will give positive outcomes
////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////
