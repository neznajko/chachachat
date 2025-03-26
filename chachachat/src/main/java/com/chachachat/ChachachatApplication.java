////////////////////////////////////////////////////////////////
package com.chachachat;
////////////////////////////////////////////////////////////////
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
////////////////////////////////////////////////////////////////
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.CommandLineRunner;
////////////////////////////////////////////////////////////////
import com.chachachat.model.Chat;
import com.chachachat.model.Message;
import com.chachachat.repository.ChatRepository;
import com.chachachat.repository.MessageRepository;
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
@SpringBootApplication
public class ChachachatApplication implements CommandLineRunner {
    
    private static final Logger logger = LoggerFactory
        .getLogger( ChachachatApplication.class );
          
    private final MessageRepository mrepository;
    private final ChatRepository crepository;
    
    public
    ChachachatApplication( MessageRepository mrepository,
                           ChatRepository crepository ){
        this.mrepository = mrepository;
        this.crepository = crepository;
    }
	public static void main( String[] args ){
        
		SpringApplication.run( ChachachatApplication.class, args );
	}
    @Override
    public void run( String ... args ) throws Exception {
        Chat chat = new Chat( "java" );
        crepository.save( chat );
        mrepository.save( new Message( "Hello World!", chat )); 
        mrepository.save( new Message( "Hi Anton!", chat )); 
    }
}
////////////////////////////////////////////////////////////////
//
// #############################################################
// #############################################################
// #############################################################
// #############################################################
////////////////////////////////////////////////////////////////
// 1. あした、アルバイトがありますか。
//    いいえ、ありません。
////////////////////////////////////////////////////////////////
// 2. いつ日本語のクラスがありますか。
//    木曜日にあります。
////////////////////////////////////////////////////////////////
// 3. 日本に友だちがいますか。
//    いいえ、いません。
////////////////////////////////////////////////////////////////
// 4. 兄弟がいますか。
//    はい、おねえさんがいます。
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
// #############################################################
// #### [ com.chachachat ]                  ####################
// #############################################################
// ###### @SpringBootApplication            ####################
// ###### ChachachatApplication             ####################
// #############################################################
// ######## -logger:             Logger [s] ####################
// ######## -mrepository: MessageRepository ####################
// ######## -crepository:    ChatRepository ####################
// #############################################################
////////////////////////////////////////////////////////////////
// #############################################################
// #### [ com.chachachat.model ]      ##########################
// #############################################################
// ###### StompMessage                ##########################
// #############################################################
// ######## -text: String             ##########################
// #############################################################
// ###### @Entity                     ##########################
// ###### @EntityListeners            ##########################
// ###### Message                     ##########################
// #############################################################
// ######## @Id                       ##########################
// ######## @GeneratedValue           ##########################
// ######## -id:                 Long ##########################
// #############################################################
// ######## @Column                   ##########################
// ######## -text:             String ##########################
// #############################################################
// ######## @CreatedDate              ##########################
// ######## @Column                   ##########################
// ######## -createdAt:          Date ##########################
// #############################################################
// ######## @ManyToOne                ##########################
// ######## @JoinColumn               ##########################
// ######## -chat:               Chat ##########################
// #############################################################
// ###### @Entity                     ##########################
// ###### Chat                        ##########################
// #############################################################
// ######## @Id                       ##########################
// ######## @GeneratedValue           ##########################
// ######## -id:                 Long ##########################
// #############################################################
// ######## @Column                   ##########################
// ######## -name:             String ##########################
// #############################################################
// ######## @OneToMany                ##########################
// ######## -messages: List <Message> ##########################
// #############################################################
////////////////////////////////////////////////////////////////
// #############################################################
// #### [ com.chachachat.repository ]                      #####
// #############################################################
// ###### MessageRepository: CrudRepository <Message,Long> #####
// #############################################################
// ###### ChatRepository:       CrudRepository <Chat,Long> #####
// #############################################################
////////////////////////////////////////////////////////////////
// #############################################################
// #### [ com.chachachat.controller ]       ####################
// #############################################################
// ###### @Controller                       ####################
// ###### StompMessageController            ####################
// #############################################################
// ######## -mrepository: MessageRepository ####################
// ######## -crepository:    ChatRepository ####################
// #############################################################
// ###### @RestController                   ####################
// ###### @RequestMapping                   ####################
// ###### ChatController                    ####################
// #############################################################
// ######## -crepository:    ChatRepository ####################
// #############################################################
////////////////////////////////////////////////////////////////
// #############################################################
// #### [ com.chachachat.config ]                           ####
// #############################################################
// ###### @Configuration                                    ####
// ###### @EnableJpaAuditing                                ####
// ###### JpaConfig                                         ####
// #############################################################
// ###### @Configuration                                    ####
// ###### @EnableWebSocketMessageBroker                     ####
// ###### WebSocketConfig: WebSocketMessageBrokerConfigurer ####
// #############################################################
////////////////////////////////////////////////////////////////
// #############################################################
// #### http                                        ############
// #############################################################
// #### POST /api/chat/{name} ChatController.create ############
// #############################################################
// #############################################################
// #### ws                                                ######
// #############################################################
// #### /app/chat/{name} StompMessageController.broadcast ######
// #############################################################
////////////////////////////////////////////////////////////////
// #############################################################
// #############################################################
// #############################################################
// #############################################################
// #############################################################
// #############################################################
// #############################################################
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
