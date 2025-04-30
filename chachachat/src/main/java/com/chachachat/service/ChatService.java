////////////////////////////////////////////////////////////////////////
package com.chachachat.service;
////////////////////////////////////////////////////////////////////////
import org.springframework.stereotype.Service;
////////////////////////////////////////////////////////////////////////
import com.chachachat.repository.ChatRepository;
import com.chachachat.model.Chat;
////////////////////////////////////////////////////////////////////////
import java.util.Optional;
////////////////////////////////////////////////////////////////////////
@Service
public class ChatService {
    
    private final ChatRepository chatRepository;

    public ChatService( ChatRepository chatRepository ){
        this.chatRepository = chatRepository;
    }
    public Optional <Chat> findByName( String name ){
        return chatRepository.findByName( name );
    }
    public Chat createChat( String chatName ){
        return chatRepository.save( new Chat( chatName ));
    }
}
////////////////////////////////////////////////////////////////////////
//
// 1. Mary went to the park. Takeshi went to the park, too.
//    メアリーさんは 公園に 行きました。
//    たけしさんも 公園に 行きました。
// 2. There is a bookstore over there. There is a resturant too.
//    あそこに 本屋が あります。
//    あそこに レストランも あります。
// 3. I drink tea. I drink coffee too.
//    私は、お茶を 飲みます。
//    私は、コーヒーも 飲みます。
// 4. Mary will go to Korea. She will go to China too.
//    メアリーさんは 韓国に 行きます。
//    メアリーさんは 中国も 行きます。
// 5. Michiko ate hamburgers on Friday. She ate hamburgers on Saturday
//    too.
//    みちこさんは 金曜日に ハンバーガーを たべました。
//    土曜日にも ハンバーガーを たべました。
// 6. Yumi bought souvenirs at a temple. She bought souvenirs at a
//    department store, too.
//    ゆみさんは お寺で お土産が 買いました。
//    デパートでも お土産が 買いました。
// 7. I took pictures at school yesterday. I took pictures at home, too.
//    私は、きのう 学校で 写真を 取りました。
//    家でも 写真を 取りました。
//    
////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////
