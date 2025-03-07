////////////////////////////////////////////////////////////////
package com.chachachat;
////////////////////////////////////////////////////////////////
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
////////////////////////////////////////////////////////////////
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
////////////////////////////////////////////////////////////////
@RestController
@RequestMapping( "api/chat" )
public class ChatController {

    private final ChatRepository crepository;

    public ChatController( ChatRepository crepository ){
        this.crepository = crepository;
    }
    @PostMapping( "/{name}" )
    public ResponseEntity <Chat> createChat( @PathVariable String name ){
        if( crepository.findByName( name ).isPresent()) {
            throw new RuntimeException( "That chat already exists" );
        }
        Chat chat = crepository.save( new Chat( name ));
        return ResponseEntity.status( HttpStatus.CREATED ).body( chat );
    }
}
////////////////////////////////////////////////////////////////
