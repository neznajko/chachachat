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
import com.chachachat.model.User;
import com.chachachat.model.Message;
import com.chachachat.repository.ChatRepository;
import com.chachachat.repository.UserRepository;
import com.chachachat.repository.MessageRepository;
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
@SpringBootApplication
public class ChachachatApplication implements CommandLineRunner {
    
    private static final Logger log = LoggerFactory
        .getLogger( ChachachatApplication.class );
          
    private final MessageRepository mrepository;
    private final ChatRepository crepository;
    private final UserRepository urepository;
    
    public
    ChachachatApplication( MessageRepository mrepository,
                           ChatRepository crepository,
                           UserRepository urepository ){
        this.mrepository = mrepository;
        this.crepository = crepository;
        this.urepository = urepository;
    }
	public static void main( String[] args ){
        
		SpringApplication.run( ChachachatApplication.class, args );
	}
    @Override
    public void run( String ... args ) throws Exception {
        log.info( "Boom" );
        Chat chat = new Chat( "java" );
        crepository.save( chat );
        User Anton = new User( "Anton" );
        urepository.save( Anton );
        User Bobi = new User( "Bobi" );
        urepository.save( Bobi );
        Message msg = new Message( "Booooom, haHaHa", chat, Anton );
        mrepository.save( msg );
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
// ---- [ com.chachachat ]                  ====================
// #############################################################
// ------ @SpringBootApplication            ====================
// ------ ChachachatApplication             ====================
// #############################################################
// -------- -log:                Logger [s] ====================
// -------- -mrepository: MessageRepository ====================
// -------- -crepository:    ChatRepository ====================
// -------- -urepository:    UserRepository ====================
// #############################################################
////////////////////////////////////////////////////////////////
// #############################################################
// #### [ com.chachachat.model ]      ##########################
// #############################################################
// ###### @Data
// ###### @AllArgsConstructor
// ###### StompMessage                
// #############################################################
// ######## -user: String             ##########################
// ######## -text: String             ##########################
// #############################################################
// ###### @Entity           
// ###### @EntityListeners  
// ###### @Data
// ###### @NoArgsconstructor
// ###### Message           
// #############################################################
// ######## @Id                       ##########################
// ######## @GeneratedValue           ##########################
// ######## -id:                 Long ##########################
// #############################################################
// ######## @Column                   #########_________________
// ######## -text:             String ########/_________________
// ##########################################//                 
// ######## @CreatedDate              ######//                  
// ######## @Column                   #####//  _________________
// ######## -createdAt:          Date ####//  /#################
// ######################################//  /##################
// ######## @ManyToOne                ##//  /###################
// ######## @JoinColumn               #//  /####################
// ######## -chat:               Chat //  /#####################
// ###################################/  /######################
// ######## @ManyToOne                  /#######################
// ######## @JoinColumn                /########################
// ######## -user:               User /#########################
// #############################################################
// ###### @Entity           
// ###### @Data
// ###### @NoArgsconstructor
// ###### Chat              
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
// ###### @Entity           
// ###### @Data
// ###### @NoArgsconstructor
// ###### User              
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
// ###### UserRepository:       CrudRepository <User,Long> #####
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
// ######## -urepository:    UserRepository ####################
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
