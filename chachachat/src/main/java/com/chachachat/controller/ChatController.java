////////////////////////////////////////////////////////////////
package com.chachachat.controller;
////////////////////////////////////////////////////////////////
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
////////////////////////////////////////////////////////////////
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
////////////////////////////////////////////////////////////////
import com.chachachat.model.Chat;
import com.chachachat.service.ChatService;
////////////////////////////////////////////////////////////////
@RestController
@RequestMapping( "api/chat" )
public class ChatController {

    private final ChatService chatService;

    public ChatController( ChatService chatService ){
        this.chatService = chatService;
    }
    @PostMapping( "/{chatname}" )
    public ResponseEntity <?> create( @PathVariable String chatname ){
        
        if( chatService.isPresent( chatname )){
            
            return ResponseEntity
                .status( HttpStatus.CONFLICT )
                .body( "That chat already exists" );
        }
        Chat chat = chatService.createChat( chatname );
        
        return ResponseEntity
            .status( HttpStatus.CREATED )
            .body( chat );
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
