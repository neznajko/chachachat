////////////////////////////////////////////////////////////////////////
package com.chachachat.service;
////////////////////////////////////////////////////////////////////////
import org.springframework.stereotype.Service;
////////////////////////////////////////////////////////////////////////
import com.chachachat.repository.MessageRepository;
import com.chachachat.model.User;
import com.chachachat.model.Chat;
import com.chachachat.model.Message;
////////////////////////////////////////////////////////////////////////
@Service
public class MessageService {
    
    private final MessageRepository messageRepository;

    public MessageService( MessageRepository messageRepository ){
        this.messageRepository = messageRepository;
    }
    public Message save( String msg, Chat chat, User user ){
        return messageRepository.save( new Message( msg, chat, user ));
    }
}
////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////
// 37. A deck o f cards is shuffled well. The cards are dealt one by one,
// until the first time an ace appears.
// (a) F i n d the probability t h a t no kings, queens, or jacks appear
// before the first ace.
// (b) Find the probability that exactly one king, exactly one q u e e n,
// and e x a c t l y one jack appear (in any order) before the first ace.
//
// 2c 3c 4c 5c 6c 7c 8c 9c Tc Jc Qc Kc Ac
// 2d 3d 4d 5d 6d 7d 8d 9d Td Jd Qd Kd Ad
// 2h 3h 4h 5h 6h 7h 8h 9h Th Jh Qh Kh Ah
// 2s 3s 4s 5s 6s 7s 8s 9s Ts Js Qs Ks As
//
// a) so w e can p u t instead of all J Q K and A, empty slot cards, the
// n u m b e r of differnt decks i s then 52!/16!, now we can put at the
// places of the slots the positive outcomes; the first c a r d must b e
// an ace t h e r e a 4 posibilites, and for the remaining cards we have
// 15!, so the t o t a l number o f positive outcomes is 52!*4*15!/16! =
// 52!/4, and the probability is P = 1/4
// b) Here we put in the first four slots say J Q K A, cos the order o f
// J Q and K doesn't matter there are 4**3 * 3! options, for the A there
// a r e 4 and for the remaining slots: 12!, so the total n u m b e r of
// positive outcomes is 4**4 * 3!12!52!/16!, a n d t h e probability i z:
// P = 4**4 * 3!12!/16!
////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////
