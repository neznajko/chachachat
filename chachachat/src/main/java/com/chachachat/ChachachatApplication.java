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
// #### @SpringBootApplication           #######################
// #### ChachachatApplication            #######################
// #### -mrepository: MessageRepository  #######################
// #### -crepository: ChatRepository     #######################
// #############################################################
// #### MessageRepository: CrudRepository <Message,Long> #######
// #############################################################
// #### ChatRepository: CrudRepository <Chat,Long> #############
// #############################################################
// #### @Configuration     #####################################
// #### @EnableJpaAuditing #####################################
// #### JpaConfig          #####################################
// #############################################################
// #############################################################
// #### @Entity          #### @Entity                   ########
// #### @EntityListeners #### Chat                      ########
// #### Message          #### @Id                       ########
// #### @Id              #### @GeneratedValue           ########
// #### @GeneratedValue  #### -id: Long                 ########
// #### -id: Long        #### @Column                   ########
// #### @Column          #### -name: String             ########
// #### -text: String    #### @OneToMany                ########
// #### @CreatedDate     #### -messages: List <Message> ########
// #### @Column          #######################################
// #### -createdAt: Date #######################################
// #### @ManyToOne       #######################################
// #### @JoinColumn      #######################################
// #### -chat: Chat      #######################################
// #############################################################
// #############################################################
// #### @RestController              ###########################
// #### @RequestMapping              ###########################
// #### ChatController               ###########################
// #### -crepository: ChatRepository ###########################
// #############################################################
// #############################################################
// #### StompMessage  #### StompMessageController          #####
// #### -text: String #### -mrepository: MessageRepository #####
// ####################### -crepository: ChatRepository    #####
// #############################################################
// #### @Configuration                                    ######
// #### @EnableWebSocketMessageBroker                     ######
// #### WebSocketConfig: WebSocketMessageBrokerConfigurer ######
// #############################################################
// #############################################################
// #############################################################
// #############################################################
// #############################################################
// #############################################################
// #### http://localhost:8080
// ####
// #### /api/chat/{name} POST ChatController: create 
// ####
// #############################################################
// #############################################################
// #############################################################
// #############################################################
// #### ws://localhost:8080/websocket
// ####
// #### /app/chat/{name} => /topic/chat/{name} 
// #### StompMessageController: broadcast 
// ####
// #############################################################
// #############################################################
// #############################################################
// #############################################################
// #############################################################
// #############################################################
// #############################################################
// #############################################################
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
