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
import com.chachachat.repository.ChatRepository;
////////////////////////////////////////////////////////////////
@RestController
@RequestMapping( "api/chat" )
public class ChatController {

    private final ChatRepository crepository;

    public ChatController( ChatRepository crepository ){
        this.crepository = crepository;
    }
    @PostMapping( "/{name}" )
    public ResponseEntity <?> create( @PathVariable String name ){
        
        if( crepository.findByName( name ).isPresent()) {
            
            return ResponseEntity
                .status( HttpStatus.CONFLICT )
                .body( "That chat already exists" );
        }
        Chat chat = crepository.save( new Chat( name ));
        
        return ResponseEntity
            .status( HttpStatus.CREATED )
            .body( chat );
    }
}
////////////////////////////////////////////////////////////////
