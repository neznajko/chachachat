////////////////////////////////////////////////////////////////
package com.chachachat.controller;
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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
    public String home( Model model ){
        model.addAttribute( "isAnonymous",
                            AuthUtils.isAnonymous());
        return "home";
    }

    @GetMapping( "/welcome" )
    public String welcome(){
        return "welcome";
    }

    @GetMapping( "/users" )
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
        return "users";
    }
}
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
