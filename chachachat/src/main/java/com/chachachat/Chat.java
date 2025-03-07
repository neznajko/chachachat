////////////////////////////////////////////////////////////////
package com.chachachat;
////////////////////////////////////////////////////////////////
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import jakarta.persistence.CascadeType;
////////////////////////////////////////////////////////////////
import java.util.List;
////////////////////////////////////////////////////////////////
@Entity
public class Chat {
    @Id
    @GeneratedValue( strategy=GenerationType.AUTO )
    private Long id;

    @Column( unique=true, nullable=false )
    private String name;

    @OneToMany( cascade=CascadeType.ALL, mappedBy="chat" )
    private List <Message> messages;

    public Chat() {}
    
    public Chat( String name ){
        super();
        this.name = name;
    }
    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public void setName( String name ){
        this.name = name;
    }
    public List <Message> getMessages() {
        return messages;
    }
    public void setMessages( List <Message> messages ){
        this.messages = messages;
    }
}
////////////////////////////////////////////////////////////////
// 26. A survey is being c-o-n-d-u-cted in a city with 1 million
// residents. It would be far too expensive to survey all of the
// residents, so a random sample o=f s=i=z=e 1000 is chosen ( in
// practice, there are many challenges w_i_t_h sampling, such as
// obtaining a complete list of e`v`e`r`y`o`n`e in the city, and
// dealing with people w-h-o refuse to participate ). The survey
// is c~o~n~d~u~c~t~e~d by choosing people o~n~e at a time, with
// replacement and with equal probabilities.
// (a) Explain how sampling w=i=t=h vs. without replacement here
//     relates to the birthday problem.
// (b) Find the probability t%h%a%t at least one person will get
//     chosen more than once.
////////////////////////////////////////////////////////////////
// What is the birthday problem?
//
