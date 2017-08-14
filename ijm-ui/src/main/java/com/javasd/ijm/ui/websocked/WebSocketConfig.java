/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javasd.ijm.ui.websocked;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

/**
 *
 * @author acampos
 */
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer
{

    /**
     *
     * @param ser
     */
    @Override
    public void registerStompEndpoints(StompEndpointRegistry ser)
    {
        ser.addEndpoint("/uiWebSocket").withSockJS();
    }
    
    /**
     *
     * @param mbr
     */
    @Override
    public void configureMessageBroker( MessageBrokerRegistry mbr )
    {
        mbr.enableSimpleBroker("/uiMessageBroker");
    }
}

