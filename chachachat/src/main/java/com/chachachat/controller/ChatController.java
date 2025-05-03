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
    @PostMapping( "/{name}" )
    public ResponseEntity <?> create( @PathVariable String name ){
        
        if( chatService.isPresent( name )){
            
            return ResponseEntity
                .status( HttpStatus.CONFLICT )
                .body( "That chat already exists" );
        }
        Chat chat = chatService.createChat( name );
        
        return ResponseEntity
            .status( HttpStatus.CREATED )
            .body( chat );
    }
}
////////////////////////////////////////////////////////////////
