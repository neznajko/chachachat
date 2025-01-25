////////////////////////////////////////////////////////////////
package chat;
////////////////////////////////////////////////////////////////
import java.util.HashMap;
import java.util.Map;
////////////////////////////////////////////////////////////////
// +--------------------------------+
// | BrokerManager                  |
// +--------------------------------+
// | -brokers    Map<String,Broker> |
// +--------------------------------+
// | +createNewTopic(String)   void |
// | +subscribe(Chat,String)   void |
// | +publish(String,Message)  void |
// +--------------------------------+
////////////////////////////////////////////////////////////////
class BrokerManager {
    private Map <String,Broker> brokers = new HashMap <> ();
    void createNewTopic( String topic ){
        brokers.put( topic, new Broker());
    }
    void subscribe( Chat chat, String userName ){
        String topic = chat.getName();
        brokers.get( topic ).subscribe( chat, userName );
    }
    void publish( String topic, Message msg ){
        brokers.get( topic ).publish( msg );
    }
}
////////////////////////////////////////////////////////////////
// +-------------------------------+
// | Broker                        |
// +-------------------------------+
// | -chats       Map<String,Chat> |
// +-------------------------------+
// | +subscribe(Chat,String)  void |
// | +publish(Message)        void |
// +-------------------------------+
////////////////////////////////////////////////////////////////
class Broker {
    private Map <String,Chat> chats = new HashMap <> ();
    void subscribe( Chat chat, String userName ){
        chats.put( userName, chat );
    }
    void publish( Message msg ){
        for( Chat chat: chats.values()){
            chat.update( msg );
        }
    }
}
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
