////////////////////////////////////////////////////////////////
package com.chachachat.model;
////////////////////////////////////////////////////////////////
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
////////////////////////////////////////////////////////////////
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
////////////////////////////////////////////////////////////////
import java.util.Date;
////////////////////////////////////////////////////////////////
@Entity
@EntityListeners( AuditingEntityListener.class )
public class Message {
    @Id
    @GeneratedValue( strategy=GenerationType.AUTO )
    private Long id;

    @Column( nullable=false )
    private String text;

    @CreatedDate
    @Column( name="created_at", nullable=false, updatable=false )
    private Date createdAt;

    @ManyToOne( fetch=FetchType.LAZY )
    @JoinColumn( name="chat" )
    private Chat chat;

    public Message() {}
    
    public Message( String text, Chat chat ){
        this.text = text;
        this.chat = chat;
    }
    public Long getId() {
        return id;
    }
    public String getText() {
        return text;
    }
    public void setText( String text ){
        this.text = text;
    }
    public Date getCreatedAt() {
        return createdAt;
    }
    public Chat getChat() {
        return chat;
    }
    public void setChat( Chat chat ){
        this.chat = chat;
    }
}
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
