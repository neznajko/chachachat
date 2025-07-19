////////////////////////////////////////////////////////////////
package com.chachachat.controller;
////////////////////////////////////////////////////////////////
import org.springframework.stereotype.Controller; 
////////////////////////////////////////////////////////////////
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
import com.chachachat.model.User;
import com.chachachat.model.Chat;
import com.chachachat.model.Message;
import com.chachachat.service.UserService;
import com.chachachat.service.ChatService;
import com.chachachat.service.MessageService;
////////////////////////////////////////////////////////////////
import org.springframework.ui.Model;
////////////////////////////////////////////////////////////////
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
////////////////////////////////////////////////////////////////
@Controller
@RequestMapping( "/chat" )
public class ChatController {

    private final UserService userService;
    private final ChatService chatService;
    private final MessageService messageService;

    public ChatController( UserService userService,
                           ChatService chatService,
                           MessageService messageService ){
        this.userService = userService;
        this.chatService = chatService;
        this.messageService = messageService;
    }
    @GetMapping( "/{chatname}" )
    public String getChat( @PathVariable String chatname,
                           Model model ){
        model.addAttribute( "chatname", chatname );
        List <Message> messages = messageService
            .findMessagesByChatname( chatname );
        Collections.reverse( messages );
        model.addAttribute( "messages", messages );
        return "chat/chat";
    }
    @GetMapping( "/user/{name}" )
    public String userChats( @PathVariable String name,
                             Model model ){
        var chats = chatService.findChatsByUsername( name );
        model.addAttribute( "name", name );
        model.addAttribute( "chats", chats );
        return "chat/user";
    }
    @GetMapping( "" )
    public String getNewChat() {
        return "chat/new";
    }
    @PostMapping( "" )
    public String postNewChat( @RequestParam String chatname,
                               Model model ){
        if( chatService.existsByChatname( chatname )){
            model.addAttribute( "error",
                                chatname + " already exists" );
            return "chat/new";
        }
        chatService.createChat( chatname );
        return "redirect:/chat/" + chatname;
    }
    @GetMapping( "/all" )
    public String allChats( Model model ){
        List <Chat> chats = chatService.findAll();
        List <List <String>> chatusers = new ArrayList <> ();
        for( var chat: chats ){
            String chatname = chat.getChatname();
            var users = userService.findUsersByChatname( chatname );
            chatusers.add( users );
        }
        model.addAttribute( "chats", chats );
        model.addAttribute( "chatusers", chatusers );
        return "chat/all";
    }
}
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
// <> 2.1.31 On a smooth horizontal table there i s a system o f
// weights, shown in the figure. T h e lower r i g h t weight is
// pulled along the table with a f o r c e F, a s shown in t h e
// figure. T h e coefficient of friction between weights of mass
// m₁ and m₂ is e q u a l to μ.  Find the acceleration o f a l l
// weights in the system.
// #############################################################
// 
//         +----+                  +----+
//         | m₁ |------------------| m₁ |
//        ++----++                ++----++
//        |  m₂  |                |  m₂  |----> F
// -------+------+----------------+------+----------------------
// #############################################################
// ## Ok let's write the forces: ###############################
// 
//         +----+              T    +----+
// fL <----| m₁ |---->---------<----| m₁ |----> fR
//        ++----++   T             ++----++
//        |  m₂  |----> fL fR <----|  m₂  |----> F
// -------+------+-----------------+------+---------------------
// ## This looks very complicated, but becoz m₁ masses have same
// ## acceleration, we can simplify:
// ## fR - T = m₁a, T - fL = m₁a, so 
// ## fR ≥ T ≥ fL that is fL ≤ fR plus they can't become b o t h
// ## equal to the critical value μm₁g; so a l l three masses m₁
// ## ryte, m₁ left and m₂ left have same acceleration, the only
// ## thing we have t o consider is when fR reaches its critical
// ## value:
// ## F - μm₁g = m₂a                                         (1)
// ## μm₁g - T = m₁w                                         (2)
// ## T - fL = m₁w                                           (3)
// ## fL = m₂w                                               (4)
// ## Here we write the equations when fR h a s reached μm₁g and
// ## the of the t h r e e masses are moving with acceleration w
// ## T = fL + m₁w = w(m₁ + m₂), from (4) and (3)
// ## μm₁g = T + m₁w = w(m₂ + 2m₁), from (2), so
// ## a = (F - μm₁g)/m₂, and                                   «
// ## w = μm₁g/(m₂ + 2m₁)                                      «
// ## Below s o m e critical value F₀ the whole system will have
// ## same acceleration, to find F₀ we write a = w:
// ## (F₀ - μm₁g)/m₂ = μm₁g/(m₂ + 2m₁),
// ## F₀ - μm₁g = μm₁m₂g/(m₂ + 2m₁),
// ## F₀ = μm₁g(1 + m₂/(m₂ + 2m₁)) = 2μm₁g(m₁ + m₂)/(m₂ + 2m₁),
// ## so for F ≤ F₀ a = w = μm₁g/(m₂ + 2m₁) = F/2(m₁ + m₂)     «
// #############################################################
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
// Exercise 1.3.7. Prove that if a is a n upper bound for A, and
// if a is also an element of A, then i t must be that a = sup A.
//
// T   h   i   s s h o u l d f  o  l  l  o  w f r o m this lemma:
//
// Lemma 1.3.8. Assume s ∈ R is an upper bound f o r a set A ⊆ R.
// T h e n, s = sup A if and only if, for every choice o f ε > 0,
// t h e r e exists a n e l e m e n t a ∈ A satisfying s − ε < a.
//
// b  e c  o  z a - ε < a f  o  r e  v  e  r  y choice o f ε > 0
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
// Exercise 1.4.1. Recall that I stands for the set of
// irrational numbers.
// (a) Show that if a, b ∈ Q, then ab and a + b are elements of
//     Q as well.
//
//     This is kind of obvious if we set:
//     a = p/q, b = s/t for p,s ∈ Z and q,t ∈ N, then
//     ab = ps/qt and a + b = (pt + sq)/qt
//
// (b) Show that if a ∈ Q and t ∈ I, then a + t ∈ I and at ∈ I
//     as long as a ≠ 0.
//
//     if b = a + t ∈ Q, then t = b - a ∈ Q, same for at
//
// (c) Part (a) can be summarized by saying that Q is closed
//     under addition and multiplication. Is I closed under
//     addition and multiplication? Given two irrational numbers
//     s and t, what can we say about s + t and st?
//
//     if we take t = 2 - s, then t + s = 2 ∈ N, same if we pick
//     t = 2/s, then ts = 2 ∈ N, zo I is not closed under
//     addition and multiplication
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
