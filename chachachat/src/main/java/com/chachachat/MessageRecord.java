////////////////////////////////////////////////////////////////
package com.chachachat;
////////////////////////////////////////////////////////////////
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
////////////////////////////////////////////////////////////////
@Entity
public class MessageRecord {
    @Id
    @GeneratedValue( strategy=GenerationType.AUTO )
    private long id;

    @Column( nullable=false )
    private String text;

    public MessageRecord() {}
    
    public MessageRecord( String text ){
        super();
        this.text = text;
    }
    public String getText() {
        return text;
    }
    public void setText( String text ){
        this.text = text;
    }
}
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
