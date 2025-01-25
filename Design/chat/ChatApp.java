////////////////////////////////////////////////////////////////
package chat;
////////////////////////////////////////////////////////////////
// +-------------------------+
// | Log                     |
// +-------------------------+
// | +error(String) [s] void |
// | +info(String)  [s] void |
// +-------------------------+
////////////////////////////////////////////////////////////////
class Log {
    static void error( String msg ){
        System.out.println( "Error: " + msg );
    }
    static void info( String msg ){
        System.out.println( "Info: " + msg );
    }
}
////////////////////////////////////////////////////////////////
// +---------------------------------------+
// | ChatApp                               |
// +---------------------------------------+
// | -userFactory              UserFactory |
// | -chatFactory              ChatFactory |
// | -messageFactory        MessageFactory |
// | -userController        UserController |
// | -chatController        ChatController |
// | -messageController  MessageController |
// | -brokerManager          BrokerManager |
// +---------------------------------------+
// | +createUser(String)              User |
// | +createChat(String,String)       Chat |
// | +sendMessage(String,String)      void |
// | +main(String[])              [s] void |
// +---------------------------------------+
////////////////////////////////////////////////////////////////
public class ChatApp {
    private BrokerManager brokerManager = new BrokerManager();
    private UserFactory userFactory = new UserFactory();
    private ChatFactory chatFactory = new ChatFactory();
    private MessageFactory messageFactory = new MessageFactory();
    private UserController userController;
    private ChatController chatController;
    private MessageController messageController;
    ChatApp() {
        DB.createTable( userFactory.createTable());
        DB.createTable( chatFactory.createTable());
        DB.createTable( messageFactory.createTable());
        userController = userFactory.createController( this );
        chatController = chatFactory.createController( this );
        messageController = messageFactory.createController( this );
        chatController.setBrokerManager( brokerManager );
        messageController.setBrokerManager( brokerManager );
    }
    User createUser( String name ){
        return userController.createUser( name );
    }
    Chat createChat( String chatName, String userName ){
        return chatController.createChat( chatName, userName );
    }
    void sendMessage( String chatName, Message msg ){
        messageController.sendMessage( chatName, msg );
    }
    public static void main( String args[]) {
        ChatApp chatApp = new ChatApp();
        User Anton = chatApp.createUser( "Anton" );
        Anton.createChat( "MyChat" );
        Anton.sendMessage( "Hello" );
        User Bobi = chatApp.createUser( "Bobi" );
//      Bobi.joinChat( "MyChat" );
//      Bobi.sendMessage( "Hi Anton!" );
    }
}
////////////////////////////////////////////////////////////////
// log: 
