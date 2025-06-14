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
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
@Controller
public class UserController {

    @GetMapping({ "/", "/home" })
    public String home( Model model ){
        model.addAttribute( "isAnonymous", AuthUtils.isAnonymous());
        return "home";
    }

    @GetMapping( "/welcome" )
    public String welcome(){
        return "welcome";
    }
}
////////////////////////////////////////////////////////////////

