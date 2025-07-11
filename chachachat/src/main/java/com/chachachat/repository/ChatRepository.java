////////////////////////////////////////////////////////////////
package com.chachachat.repository;
////////////////////////////////////////////////////////////////
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
////////////////////////////////////////////////////////////////
import java.util.Optional;
import java.util.List;
////////////////////////////////////////////////////////////////
import com.chachachat.model.Chat;
////////////////////////////////////////////////////////////////
public interface ChatRepository
    extends CrudRepository <Chat,Long> {
    
    Optional <Chat> findByChatname( String chatname );
    boolean existsByChatname( String chatname );
    List <Chat> findAll();
    @Query (
    "SELECT DISTINCT m.chat.chatname " +
    "FROM Message m " +
    "WHERE m.user.username = :username" )
    List <String> findChatsByUsername( @Param( "username" )
                                       String username );
}
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
// #############################################################
// #############################################################
// #############################################################
// #############################################################
// #####          __________________________    ################
// #####         /                         /    ################
// #####        /                         //    ################
// #####       /    (1)                  //     ################
// #####      /          (3)    (2)     //      ################
// #####     /                         ///      ################
// #####    /_________________________///       ################
// #####    |_________________________//        ################
// #####       | |  /            | |  /         ################
// #####       | | /     (4)     | | /    (5)   ################
// #####       |_|/              |_|/           ################
// #####                                        ################
// #############################################################
// #############################################################
// #############################################################
// #############################################################
// ##### (1) 辞書はつくえの上です。
// #############################################################
// ##### (2) 時計もつくえの上です。
// #############################################################
// ##### (3) ぼうしはじしょと時計の間です。
// #############################################################
// ##### (4) かばんはつくえの下です。
// #############################################################
// ##### (5) つくえはテレビの近くです。
// #############################################################
// #############################################################
// #############################################################
// #############################################################
