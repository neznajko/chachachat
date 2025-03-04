////////////////////////////////////////////////////////////////
package com.chachachat;
////////////////////////////////////////////////////////////////
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
////////////////////////////////////////////////////////////////
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
////////////////////////////////////////////////////////////////
import java.util.Date;
////////////////////////////////////////////////////////////////
@Entity
@EntityListeners( AuditingEntityListener.class )
public class MessageRecord {
    @Id
    @GeneratedValue( strategy=GenerationType.AUTO )
    private Long id;

    @Column( nullable=false )
    private String text;

    @CreatedDate
    @Column( name="created_at", nullable=false, updatable=false )
    private Date createdAt;

    public MessageRecord() {}
    
    public MessageRecord( String text ){
        super();
        this.text = text;
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
}
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
