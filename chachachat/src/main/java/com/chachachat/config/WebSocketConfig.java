////////////////////////////////////////////////////////////////////////////////////////
package com.chachachat.config;
////////////////////////////////////////////////////////////////////////////////////////
import org.springframework.context.annotation.Configuration;
////////////////////////////////////////////////////////////////////////////////////////
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
////////////////////////////////////////////////////////////////////////////////////////
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
////////////////////////////////////////////////////////////////////////////////////////
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
    @Override
    public void configureMessageBroker( MessageBrokerRegistry config ){
        config.enableSimpleBroker( "/topic" );
        config.setApplicationDestinationPrefixes( "/app" );
    }
    @Override
    public void registerStompEndpoints( StompEndpointRegistry registry ){
        registry.addEndpoint( "/websocket" );
    }
}
////////////////////////////////////////////////////////////////////////////////////////
// 28. A college has 10 time slots for its c--o--u-rses, and blithely assigns courses to
// completely random time slots, independently. Th-e college offers exactly 3 statistics
// courses. What is the probability that 2 or more o=f the statistics courses are in the
// same time slot?
// We can r==epresent an elementary event as (i,j,k), meaning the first course is in the
// ith slot, t--he second course is in the jth slot and the third course in the kth slot,
// so the size of the sa==mple space is #(Omega) = 10*10*10, let E is the event that all
// i,j,k are d=i=f=f=e=r====e=n=t so #(E) = 10*9*8, and the desired probability is P(!E):
// P(!E) = 1 - P(E) = 1 - 10*9*8/10*10*10 = 10*(100 - 72)/1000 = 28/100 = 28%
////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////
