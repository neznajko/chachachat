////////////////////////////////////////////////////////////////
package chat;
////////////////////////////////////////////////////////////////
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
// +--------------------------+
// | View                     |
// +--------------------------+
// | +brush(String)  [s] void |
// | +display()      [a] void |
// +--------------------------+
////////////////////////////////////////////////////////////////
abstract class View {
    static void brush( String patron ){
        System.out.println( patron );
    }
    abstract void display();
}
////////////////////////////////////////////////////////////////
// +----------------------------+       +------+
// | User                       |       | View |
// +------------------------------------>------+
// | -name               String |
// | -app               ChatApp |
// | -chatz    Map<String,Chat> |
// | -kibitz   Map<String,Chat> |
// +----------------------------+
// | +createChat(String)   void |
// | +joinChat(String)     void |
// | +getName()          String |
// +----------------------------+
////////////////////////////////////////////////////////////////
class User extends View {
    private String name;
    private ChatApp app;
    private Map <String,Chat>  chatz = new HashMap <> ();
    private Map <String,Chat> kibitz = new HashMap <> ();
    private Chat active = null;
    User( String name, ChatApp app ){
        this.name = name;
        this.app = app;
    }
    void createChat( String chatName ){
        Chat chat = app.createChat( chatName, name );
        chat.setOwner( this );
        chatz.put( chatName, chat );
        active = chat;
    }
    void joinChat( String chatName ){
        Chat chat = app.joinChat( chatName, name );
        chat.setOwner( this );
        chatz.put( chatName, chat );
        active = chat;
    }
    String getName() {
        return name;
    }
    @Override
    public void display() {
        for( Chat chat: chatz.values()){
            chat.display();
        }
        for( Chat chat: kibitz.values()){
            chat.display();
        }
    }
    void sendMessage( String msg ){
        app.sendMessage( active.getName(), new Message( name, msg ));
    }
}
////////////////////////////////////////////////////////////////
// +--------------------------+     +------+
// | Chat                     |     | View |
// +-------------------------------->------+
// | -DISPLAY_LENGTH  [f] int |
// | -name             String |
// | -app             ChatApp |
// | -owner              User |
// | -deck      List<Message> |
// +--------------------------+
// | +setOwner(User)     void |
// | +getName()        String |
// | +update(Message)    void |
// +--------------------------+
////////////////////////////////////////////////////////////////
class Chat extends View {
    private final int DISPLAY_LENGTH = 10;
    private String name;
    private ChatApp app;
    private User owner;
    private List <Message> deck = new ArrayList <> ();
    Chat( String name, ChatApp app ){
        this.name = name;
        this.app = app;
    }
    void setOwner( User owner ){
        this.owner = owner;
    }
    String getName() {
        return name;
    }
    void update( Message msg ){
        deck.add( msg );
        owner.display();
    }
    @Override
    public void display() {
        int j = Math.max( 0, deck.size() - DISPLAY_LENGTH );
        brush( "[ " + name + " ]" );
        while( j < deck.size()){
            deck.get( j++ ).display();
        }
    }
}
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
// +---------------------+     +------+
// | Message             |     | View |
// +--------------------------->------+
// | -userName    String |
// | -text        String |
// +---------------------+
////////////////////////////////////////////////////////////////
class Message extends View {
    private String userName;
    private String text;
    Message( String userName, String text ){
        this.userName = userName;
        this.text = text;
    }
    @Override
    public void display() {
        brush( userName + ": " + text );
    }
}
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
