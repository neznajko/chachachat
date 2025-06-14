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
import lombok.Data;
import lombok.NoArgsConstructor;
////////////////////////////////////////////////////////////////
import com.fasterxml.jackson.annotation.JsonBackReference;
////////////////////////////////////////////////////////////////
import java.util.Date;
////////////////////////////////////////////////////////////////
@Entity
@EntityListeners( AuditingEntityListener.class )
@Data
@NoArgsConstructor
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
    @JoinColumn( name="chat_id" )
    @JsonBackReference
    private Chat chat;

    @ManyToOne( fetch=FetchType.LAZY )
    @JoinColumn( name="user_id" )
    @JsonBackReference
    private User user;

    public Message( String text, Chat chat, User user ){
        this.text = text;
        this.chat = chat;
        this.user = user;
    }
}
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
// 34. A random 5-card poker hand i s dealt from a standard deck
// o f cards. Find the probability of e a c h of t h e following
// p o s s i b i l i t i e s (in terms of binomial coefficients).
// (a) A flush (all 5 cards being of the same suit; do not count
// a r o y a l flush, which i s a flush with an ace, king, queen,
// jack, and 10)
// (b) Two pair (e.g., two 3’s, two 7’s, and an ace)
////////////////////////////////////////////////////////////////
// 2 3 4 5 6 7 8 9 T J Q K A [ c d h s ]
//
// a) Let's pick hands regardless o f cards order so that number
// of all possible hands is C(52,5). If we l o o k at clubs, the
// number of all hands, having o n l y clubs is N = C(13,5), the
// n u m b e r of clubs flushes is N - 1, cos we have to discard
// Tc Jc Qc Kc Ac. S o all f l u s h e s are 4(N - 1), a n d the
// probability is: P = 4(C(13,5) - 1)/C(52,5)
//
// b) Here we can d i v i d e the h a n d in three parts l i k e
// (7c 7d)(Ah As)(Kc). A g i v e n value like 7 can be chosen in
// C(4,2) ways, so t h e number of first pairs is 13*C(4,2). For
// the second pair we h a v e to discard one value so the number
// of pairs is 12*C(4,2). For t h e remaining third part we have
// to discard 2 values we've j u s t selected, zo there are 11*4
// diferent options, that is the t o t a l number of hands a r e
// N = 13C(4,2)*12C(4,2)*11*4
//
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
