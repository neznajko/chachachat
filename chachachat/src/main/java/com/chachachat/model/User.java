////////////////////////////////////////////////////////////////
package com.chachachat.model;
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
public class User {
    @Id
    @GeneratedValue( strategy=GenerationType.AUTO )
    private Long id;

    @Column( unique=true, nullable=false )
    private String name;

    @OneToMany( cascade=CascadeType.ALL, mappedBy="chat" )
    private List <Message> messages;

    public User() {}
    
    public User( String name ){
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
////////////////////////////// /////////////////    //// /  ////
///////////////////////////// /////////////////    //// /  /////
//////////////////////////// /////////////////    //// /  //////
/////////////////////////// /////////////////    //// /  ///////

////////////////////////////////////////////////////////////////
// 1. きのうは月曜日でしたか。
//    いいえ、月曜日じゃなかったです。
////////////////////////////////////////////////////////////////
// 2. きのうは十五日でしたか。
//    いいえ、十五日じゃなかったです。
////////////////////////////////////////////////////////////////
// 3. 今日の朝ご飯はハンバーガーでしたか。
//    いいえ、ハンバーガーじゃなかったです。
////////////////////////////////////////////////////////////////
// 4. 子供の時、いい子供でしたか。
//    いいえ、いい子供じゃなかったです。
////////////////////////////////////////////////////////////////
// 5. 高校の時、いい学生でしたか。
//    いいえ、いい学生じゃなかったです。
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
// 30. With definitions as in the previous problem, find the
// probability that a random n-letter word is a palindrome for
// n = 7 and for n = 8.
////////////////////////////////////////////////////////////////
// Ok, so we have only lower letters: Sigma = [ a..z ] zo how to
//     represent an elementary event here, and what is the Omega
//            Space. Be coz we have n-letter words we pick thus:
//   ( a1, a2, ..., an ); vhere aj is from Sigma, for example if
//      n = 10, one elementary event is ( a,b,z,b,d,f,g,a,w,f ).
//       Omega is the space of all such tuples, and its size is:
// |Omega| = 26^n. We have to consider two cases where n is even
//  and odd. If it's even the first half can be anything and the
//   second can be only one so |Palindrome| = 26^(n/2), iif n is
//  odd we have to take (n - 1)/2 as the fyorst half, the middle
//   letter can be anything and the second half can be only one,
//   so we'll get 26^[(n - 1)/2] times 26 = 26^[(n - 1)/2 + 1] =
//                                           26^[(n + 1)/2], so:
//                       P(Palindrome) = 1/26^(n/2) if n is even
//                                 1/26^[(n - 1)/2] iif n is odd
//     n = 7, P = 1/26^[(7 - 1)/2] = 1/26^3 = 1/17,576 ≈ 0.0057%
//                      n = 8, P = 1/26^(8/2) = 1/26^4 ≈ 0.0002%
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
// 2.1.22: After what time will the speed of a body, which was
// given a speed v up an inclined plane, again be equal to v?
// The coefficient of friction is _, the angle between the plane
// and the horizon is a, tga > _.
////////////////////////////////////////////////////////////////
//                                . 
//           N                  .`        The condition tga > _,
//          .             f   .`        guarantees that the body
//           `.         .`  .`      will not stop and will start
//             `. .`. .`  .`        moving back, after v becomes
//              .`   `. .`             zero, be cos the critical
//             `.  m  .`                           condition is:
//              .`. .`.                f = _N = _mgcosa = mgsina
//    mgsina  .`  .`   `.  mgcosa        In the first phase f is
//           `  .`       `.         directed downwards, cos v is
//            .`                               directed upwards:
//          .`                       ma₁ = mgsina + _mgcosa, and
//        .`a                              a₁ = g(sina + _cosa),
// ################################  so v will become zero after 
// ################################       time t₁ = v/a₁. In the
// ################################       second phase f will be
// ################################            directed upwards:
// ################################        a₂ = g(sina - _cosa),
// ################################            and t₂ = v/a₂, so 
// ################################                t = t₁ + t₂ =
// ################################           = v(1/a₁ + 1/a₂) =
// ################################   = (v/g)[1/(sina + _cosa) + 
// ################################        + 1/(sina - _cosa)] =
// ################################ = (v/g)[(sina - _cosa + sina
// ################################            + _cosa)/(sin²a - 
// ################################                - _²cos²a)] =
// ################################  = 2vsina/g(sin²a - _²cos²a)
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
