////////////////////////////////////////////////////////////////////////
package com.chachachat.controller;
////////////////////////////////////////////////////////////////////////
import org.springframework.stereotype.Controller;
////////////////////////////////////////////////////////////////////////
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.handler.annotation.DestinationVariable;
////////////////////////////////////////////////////////////////////////
import com.chachachat.model.StompMessage;
import com.chachachat.model.Chat;
import com.chachachat.model.User;
import com.chachachat.service.UserService;
import com.chachachat.service.ChatService;
import com.chachachat.service.MessageService;
////////////////////////////////////////////////////////////////////////
@Controller
public class StompMessageController {
    
    private final MessageService messageService;
    private final UserService userService;
    private final ChatService chatService;
    
    StompMessageController( MessageService messageService,
                            ChatService chatService,
                            UserService userService ){
        this.messageService = messageService;
        this.chatService = chatService;
        this.userService = userService;
    }
    @MessageMapping( "/chat/{chatname}" )
    @SendTo(   "/topic/chat/{chatname}" )
    public StompMessage broadcast( @DestinationVariable( "chatname" )String chatname,
                                   StompMessage stompMessage ){
        Chat chat = chatService.findByChatname( chatname );
        User user = userService.findByUsername( stompMessage.getUser());

        messageService.save( stompMessage.getText(), chat, user );
        
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
