////////////////////////////////////////////////////////////////
package com.chachachat.controller;
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;    
import org.springframework.ui.Model;
////////////////////////////////////////////////////////////////
import com.chachachat.utils.AuthUtils;
import com.chachachat.service.UserService;
import com.chachachat.service.ChatService;
import com.chachachat.model.User;
////////////////////////////////////////////////////////////////
import java.util.List;
import java.util.ArrayList;
////////////////////////////////////////////////////////////////
@Controller
public class UserController {

    private final UserService userService;
    private final ChatService chatService;

    public UserController( UserService userService,
                           ChatService chatService ){
        this.userService = userService;
        this.chatService = chatService;
    }

    @GetMapping({ "/", "/home" })
    public String home(){
        return "home";
    }

    @GetMapping( "/welcome" )
    public String welcome( Model model ){
        model.addAttribute( "username", AuthUtils.getUsername());
        return "welcome";
    }

    @GetMapping( "/user/all" )
    public String users( Model model ){
        List <User> users = userService.findAll();
        List <List <String>> userchats = new ArrayList <> ();
        for( User user: users ){
            String name = user.getUsername();
            var chats = chatService.findChatsByUsername( name );
            userchats.add( chats );
        }
        model.addAttribute( "users", users );
        model.addAttribute( "userchats", userchats );
        return "user/all";
    }

    @GetMapping( "/user/edit" )
    public String getEdit( Model model ){
        User user = userService.currentUser();
        model.addAttribute( "user", user );
        return "user/edit";
    }

    @PostMapping( "/user/edit" )
    public String postEdit( @RequestParam String oldPassword,
                            @RequestParam String newPassword,
                            @RequestParam String retypePassword,
                            Model model ){
        User user = userService.currentUser();
        String result = userService
            .changePassword( user,
                             oldPassword,
                             newPassword,
                             retypePassword );
        model.addAttribute( "user", user );
        if( result == null ){
            model.addAttribute( "success",
                                "Password updated successfully" );
        } else {
            model.addAttribute( "error", result );
        }
        return "user/edit";
    }
    
    @GetMapping( "/user/details" )
    public String details( Model model ){
        User user = userService.currentUser();
        String username = user.getUsername();
        var userchats = chatService.findChatsByUsername( username );
        model.addAttribute( "username", username );
        model.addAttribute( "userchats", userchats );
        return "user/details";
    }

    @GetMapping( "/user/delete" )
    public String getDelete( Model model ){
        User user = userService.currentUser();
        String username = user.getUsername();
        model.addAttribute( "username", username );
        return "user/delete";
    }

    @PostMapping( "/user/delete" )
    public String postDelete( @RequestParam String confirm ){
        User user = userService.currentUser();
        if( "yes".equals( confirm )){
            userService.delete( user );
            return "redirect:/logout";
        }
        return "redirect:/user/details";
    }
}
////////////////////////////////////////////////////[C][R][U][D]
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
// Exercise 1.3.10 (Cut Property). The Cut Property o f the real
// numbers is the following:
// If A and B a r e nonempty, disjoint sets with A ∪ B = R a n d
// a < b for a l l a ∈ A and b ∈ B, then there exists c ∈ R such
// that x ≤ c whenever x ∈ A and x ≥ c whenever x ∈ B.
//
// (a) Use t h e Axiom of Completeness to prove the Cut Property.
//
// "Axiom of Completeness. Every nonempty set of r e a l numbers
// that is bounded above has a least upper bound."
//
// so A h a s sup, if we pick some b ∈ B we can't have b < sup A
// becoz if we s e t ε = sup A - b > 0, then t h e r e exists an
// e l e m e n t a ∈ A such that sup A - ε = b < a, s o w e have
// a ≤ sup A ≤ b, for all a ∈ A and b ∈ B
// 
// (b) Show that the implication g o e s the other way; that i s,
// assume R possesses the Cut Property and l e t E be a nonempty
// set that is bounded above. Prove sup E exists.
//
// L  e  t  s p i c k t   h   e s  e  t of all upper b o u n d s
// U = {x ∈ R: x is upper bound for E }, obviously U i s bounded
// bellow, now w e can take the complimentary set L = U \ R with
// l < u for all l ∈ L a n d u ∈ U, now t h e cut property gives
// that there is c ∈ R: l ≤ c ≤ u for all l and u. So c is sup E
// becoz it's an upper b o u n d and all upper bounds of E a r e 
// greater or equeal to c
//
// (c) The punchline of p a r t s (a) and (b) i s that the C u t
// Property could be used in place o f the Axiom of Completeness
// a s the fundamental axiom that distinguishes the real numbers
// from t h e rational numbers. To drive this point home, give a
// concrete example showing that the Cut Property is not a valid
// statement when R is replaced by Q.
//
// We can s  p  l  i  t Q in h  a  l  f say { q ∈ Q: q < 1 } and
// { q ∈ Q: q ≥ 1 }, b u t we can't split into { q ∈ Q: q² < 2 }
// and { q ∈ Q: q² ≥ 2 } there is no such element c ∈ Q t o hold
// the Cut Property
//
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
