////////////////////////////////////////////////////////////////
package com.chachachat.controller;
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.security.core.Authentication;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.authentication.AuthenticationManager;
////////////////////////////////////////////////////////////////
import com.chachachat.model.User;
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
@Controller
public class AuthController {

    private final AuthenticationManager authManager;

    AuthController( AuthenticationManager authManager ){
        this.authManager = authManager;
    }

    @GetMapping( "/login" )
    public String getlogin( Model model ){
        model.addAttribute( "user", new User());
        return "login";
    }

    @PostMapping( "/login" )
    public String postLogin( @ModelAttribute User user ){
        try {
            Authentication auth = authManager.authenticate( 
                    new UsernamePasswordAuthenticationToken( 
                        user.getUsername(), user.getPassword()));
            SecurityContextHolder.getContext().setAuthentication( auth );
            return "redirect:/welcome";
        } catch( AuthenticationException e ){
            return "redirect:/login?error";
        }
    }
}
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
// <> 2.1.30*: A body o f mass m₁ lies o n a board of m a s s m₂,
// which i s o n a smooth (frictionless) horizontal surface. The
// coefficient o f friction between the body and the board i s μ.
//
// a. What force must be applied to t h e board so that the body
// starts to slip off it?  Also, if a force F₀ is applied to the
// board and the length of t h e board is L, after how much time
// will the body slide off?
//
// b. With what acceleration do the body a n d the board move if
// the force F₀ is applied to the body of mass m₁?
//
// #############################################################
// #############################################################
// ##  +----+  #################################################
// ##  | m₁ |  #################################################
// ##  +----+-----------------------------+  ###################
// ##  | m₂                               |  ###################
// ----+----------------------------------+---------------------
// #############################################################
// ## a) So let's apply some force f₀ on m₂ directed on left and 
// ## look at m₁ i n a system moving alongside m₂, i f m₁ starts  
// ## slipping it will go to ryte s o the force of friction f is 
// ## directed to left:
// ##            +----+
// ##    f <-----| m₁ |-----> m₁a
// ##            +----+--------------------+-----> f
// ##   f₀ <-----| m₂                      |
// ##            +-------------------------+-----> m₂a
// ## Here m₁₂a are the phony forces which allow us to write the
// ## Newton equation in non-inertial s y s t e m moving w i t h
// ## acceleration a, if f₀ i s increasing the m₂ acceleration a
// ## in the l a b system will increase as well and f will reach
// ## its critical value μN₁ = μm₁g:
// ## f = μm₁g = m₁a, a = μg
// ## f₀ = f + m₂a = (m₁ + m₂)a = μ(m₁ + m₂)g                  «
// ##
// ## if f₀ is bigger that t h i s critical value, m₁ will start
// ## moving with some relative acceleration say w:
// ## m₁w = m₁a - μm₁g
// ## f₀ = μm₁g + m₂a,
// ## w = a - μg = (m₂a - μm₂g)/m₂ = (f₀ - μm₁g - μm₂g)/m₂ =
// ##   = (f₀ - μ(m₁ + m₂)g)/m₂, for the slide off time w e have
// ## L = wt²/2, so t = √(2L/w) = √(2Lm₂/(f₀ - μ(m₁ + m₂)g))   «
// ##
// ## b) Let's here write the laws directly in the lab system so
// ## so we don't need to go back and forth:
// ## f₀ - μm₁g = m₁a₁
// ## μm₁g = m₂a₂,
// ## a₁ = (f₀ - μm₁g)/m₁, a₂ = μgm₁/m₂                        «
// #############################################################
// #############################################################
// #############################################################
// #############################################################
// #############################################################
//
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
