/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javasd.ijm.ui.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

/**
 *
 * @author acampos
 */
@Controller // Not a RestController
@MessageMapping( "/uiMessageBroker")
public class WebSocketController
{
    @SendTo("/sendExamGradeToFrontEnd")
    public Object uiMessageBrokerExamGrade( Object examGrade )
    {
        return examGrade;
    }
}