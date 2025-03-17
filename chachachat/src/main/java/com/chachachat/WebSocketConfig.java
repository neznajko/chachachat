////////////////////////////////////////////////////////////////////////////////////////
package com.chachachat;
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
////////////////////////////////////////////////////////////////////////////////////////
