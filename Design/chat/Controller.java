////////////////////////////////////////////////////////////////
package chat;
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
// +-------------------+
// | Controller<Table> |
// +-------------------+
// | #table      Table |
// | #app      ChatApp |
// +-------------------+
////////////////////////////////////////////////////////////////
class Controller <T> {
    protected T table;
    protected ChatApp app;
    Controller( T table, ChatApp app ){
        this.table = table;
        this.app = app;
    }
}
////////////////////////////////////////////////////////////////
// +---------------------------+        +------------+
// | UserController            |        | Controller |
// +------------------------------------>------------+
// | +createUser(String)  User |
// +---------------------------+
////////////////////////////////////////////////////////////////
class UserController extends Controller <UserTable> {
    UserController( UserTable table, ChatApp app ){
        super( table, app );
    }
    User createUser( String name ){
        if( table.find( name )){
            Log.error( "User " + name + " already there" );
            return null;
        } else {
            table.save( new UserRecord( name ));
            Log.info( "New User " + name );
            return new User( name, app );
        }
    }
}
////////////////////////////////////////////////////////////////
// +---------------------------------------+     +------------+
// | ChatController                        |     | Controller |
// +--------------------------------------------->------------+
// | -brokerManager          BrokerManager |
// +---------------------------------------+
// | -subscribe(String,String)        Chat |
// | +setBrokermanager(BrokerManager) void |
// | +createChat(String,String)       Chat |
// | +joinChat(String,String)         Chat |
// +---------------------------------------+
////////////////////////////////////////////////////////////////
class ChatController extends Controller <ChatTable> {
    private BrokerManager brokerManager;
    private Chat subscribe( String chatName, String userName ){
        Chat chat = new Chat( chatName, app );
        brokerManager.subscribe( chat, userName );
        return chat;
    }
    ChatController( ChatTable table, ChatApp app ){
        super( table, app );
    }
    void setBrokerManager( BrokerManager brokerManager ){
        this.brokerManager = brokerManager;
    }
    Chat createChat( String chatName, String userName ){
        if( table.find( chatName )){
            Log.error( "Chat " + chatName + " already there" );
            return null;
        } else {
            table.save( new ChatRecord( chatName ));
            Log.info( "New Chat " + chatName );
            brokerManager.createNewTopic( chatName );
        }
        return subscribe( chatName, userName );
    }
    Chat joinChat( String chatName, String userName ){
        if( !table.find( chatName )){
            Log.error( "Chat " + chatName + " ain't here" );
            return null;
        }
        return subscribe( chatName, userName );
    }
}
////////////////////////////////////////////////////////////////
// +----------------------------------------+     +------------+
// | MessageController                      |     | Controller |
// +---------------------------------------------->------------+
// | +setBrokermanager(BrokerManager)  void |
// | +sendMessage(String,Message)      void |
// +----------------------------------------+
////////////////////////////////////////////////////////////////
class MessageController extends Controller <MessageTable> {
    private BrokerManager brokerManager;
    MessageController( MessageTable table, ChatApp app ){
        super( table, app );
    }
    void setBrokerManager( BrokerManager brokerManager ){
        this.brokerManager = brokerManager;
    }
    void sendMessage( String chatName, Message message ){
        brokerManager.publish( chatName, message );
    }
}
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
