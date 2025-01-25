////////////////////////////////////////////////////////////////
package chat;
////////////////////////////////////////////////////////////////
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
////////////////////////////////////////////////////////////////
// +--------------------+
// | UserRecord         |
// +--------------------+
// | -name       String |
// +--------------------+
// | +getName()  String |
// +--------------------+
////////////////////////////////////////////////////////////////
class UserRecord {
    private String name;
    UserRecord( String name ){
        this.name = name;
    }
    String getName() {
        return name;
    }
}
////////////////////////////////////////////////////////////////
// +--------------------+
// | ChatRecord         |
// +--------------------+
// | -name       String |
// +--------------------+
// | +getName()  String |
// +--------------------+
////////////////////////////////////////////////////////////////
class ChatRecord {
    private String name;
    ChatRecord( String name ){
        this.name = name;
    }
    String getName() {
        return name;
    }
}
////////////////////////////////////////////////////////////////
// +------------------------+
// | MessageRecord          |
// +------------------------+
// | -sender         String |
// | -receiver       String |
// | -message        String |
// +------------------------+
// | +getSender()    String |
// | +getReceiver()  String |
// | +getMessage()   String |
// +------------------------+
////////////////////////////////////////////////////////////////
class MessageRecord {
    private String sender;
    private String receiver;
    private String message;
    MessageRecord( String sender,
                   String receiver,
                   String message ){
        this.sender = sender;
        this.receiver = receiver;
        this.message = message;
    }
    String getSender() {
        return sender;
    }
    String getReceiver() {
        return receiver;
    }
    String getMessage() {
        return message;
    }
}
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
// +-----------------------------+
// | Table <Record>              |
// +-----------------------------+
// | - name               String |
// | # records      List<Record> |
// +-----------------------------+
// | + getName()          String |
// | + save(Record)         void |
// | + find(String)  [a] boolean |
// +-----------------------------+
////////////////////////////////////////////////////////////////
abstract class Table <R> {
    private String name;
    protected List <R> records = new ArrayList <> ();
    Table( String name ){
        this.name = name;
    }
    String getName() {
        return name;
    }
    void save( R record ){
        records.add( record );
    }
    abstract boolean find( String key );
}
////////////////////////////////////////////////////////////////
// +--------------------------------+
// | DB                             |
// +--------------------------------+
// | -tables  [s] Map<String,Table> |
// +--------------------------------+
// | +createTable(Table)   [s] void |
// | +getTable(name)      [s] Table |
// +--------------------------------+
////////////////////////////////////////////////////////////////
class DB {
    private static Map <String,Table> tables = new HashMap <> ();
    private DB() {}
    static void createTable( Table table ){
        tables.put( table.getName(), table );
    }
    static Table getTable( String name ){
        return tables.get( name );
    }
}
////////////////////////////////////////////////////////////////
// +-----------+      +-------+
// | UserTable |      | Table |
// +------------------>-------+
////////////////////////////////////////////////////////////////
class UserTable extends Table <UserRecord> {
    UserTable( String name ){
        super( name );
    }
    @Override
    public boolean find( String key ){
        for( UserRecord record: records ){
            if( key.equals( record.getName())){
                return true;
            }
        }
        return false;
    }
}
////////////////////////////////////////////////////////////////
// +-----------+      +-------+
// | ChatTable |      | Table |
// +------------------>-------+
////////////////////////////////////////////////////////////////
class ChatTable extends Table <ChatRecord> {
    ChatTable( String name ){
        super( name );
    }
    @Override
    public boolean find( String key ){
        for( ChatRecord record: records ){
            if( key.equals( record.getName())){
                return true;
            }
        }
        return false;
    }
}
////////////////////////////////////////////////////////////////
// +--------------+      +-------+
// | MessageTable |      | Table |
// +--------------------->-------+
////////////////////////////////////////////////////////////////
class MessageTable extends Table <MessageRecord> {
    MessageTable( String name ){
        super( name );
    }
    @Override
    public boolean find( String key ){
        return false;
    }
}
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
