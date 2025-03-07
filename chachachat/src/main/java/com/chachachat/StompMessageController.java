////////////////////////////////////////////////////////////////////////
package com.chachachat;
////////////////////////////////////////////////////////////////////////
import org.springframework.stereotype.Controller;
////////////////////////////////////////////////////////////////////////
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.handler.annotation.DestinationVariable;
////////////////////////////////////////////////////////////////////////
@Controller
public class StompMessageController {
    
    private final MessageRepository mrepository;
    private final ChatRepository crepository;
    
    StompMessageController( MessageRepository mrepository,
                            ChatRepository crepository ){
        this.mrepository = mrepository;
        this.crepository = crepository;
    }
    @MessageMapping( "/chat/{name}" )
    @SendTo(   "/topic/chat/{name}" )
    public StompMessage broadcast( @DestinationVariable( "name" )String name,
                                   StompMessage stompMessage ){
        Chat chat = crepository
            .findByName( name )
            .orElseThrow(() -> new RuntimeException( "Chat not found" ));
        
        mrepository.save( new Message( stompMessage.getText(), chat ));
        
        return stompMessage;
    }
}
////////////////////////////////////////////////////////////////////////
// 1. あそこにバス亭があります。
// 2. 木曜日にクラスがありません。
// 3. じしょがありません。
// 4. あそこに山下先生がいます。
// 5. 子供がいます。
////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////
