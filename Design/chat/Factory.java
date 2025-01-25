////////////////////////////////////////////////////////////////
package chat;
////////////////////////////////////////////////////////////////
// +--------------------------------------------+
// | Factory<Table,Controller>                  |
// +--------------------------------------------+
// | #name                               String |
// +--------------------------------------------+
// | +createTable()                   [a] Table |
// | +createController(ChatApp)  [a] Controller |
// +--------------------------------------------+
////////////////////////////////////////////////////////////////
abstract class Factory <T,C> {
    protected String name;
    Factory( String name ){
        this.name = name;
    }
    abstract T createTable();
    abstract C createController( ChatApp app );
}
////////////////////////////////////////////////////////////////
// +-------------+        +---------+
// | UserFactory |        | Factory |
// +---------------------->---------+
////////////////////////////////////////////////////////////////
class UserFactory extends Factory <UserTable,UserController> {
    UserFactory() {
        super( "Users" );
    }
    @Override
    public UserTable createTable() {
        return new UserTable( name );
    }
    @Override
    public UserController createController( ChatApp app ){
        return new UserController
            (( UserTable ) DB.getTable( name ), app );
    }
}
////////////////////////////////////////////////////////////////
// +-------------+        +---------+
// | ChatFactory |        | Factory |
// +---------------------->---------+
////////////////////////////////////////////////////////////////
class ChatFactory extends Factory <ChatTable,ChatController> {
    ChatFactory() {
        super( "Chats" );
    }
    @Override
    public ChatTable createTable() {
        return new ChatTable( name );
    }
    @Override
    public ChatController createController( ChatApp app ){
        return new ChatController
            (( ChatTable ) DB.getTable( name ), app );
    }
}
////////////////////////////////////////////////////////////////
// +----------------+        +---------+
// | MessageFactory |        | Factory |
// +------------------------->---------+
////////////////////////////////////////////////////////////////
class MessageFactory
    extends Factory <MessageTable,MessageController> {
    MessageFactory() {
        super( "Messages" );
    }
    @Override
    public MessageTable createTable() {
        return new MessageTable( name );
    }
    @Override
    public MessageController createController( ChatApp app ){
        return new MessageController
            (( MessageTable ) DB.getTable( name ), app );
    }
}
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
