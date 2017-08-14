/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javasd.ijm.grader.messaging;

import com.javasd.ijm.commons.deo.qna.Question;
import com.javasd.ijm.commons.utils.Utils;
import java.util.List;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitMessagingTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 *
 * @author acampos
 */
@Component
public class Sender
{
    @Autowired
    private RabbitMessagingTemplate rmTemplate;
    
    @Bean
    public Queue graderToExamGradeResponseQ()
    {
        return new Queue( "graderToExamGradeResponseQ", false );
    }
    
    public void sendToGraderToExamGradeResponseQ( Long examId, Double grade )
    {
        Utils.consoleMsg( "GRADER/SENDER/EXAM ID: " + examId + ", GRADE: " + grade );
        
        rmTemplate.convertAndSend( "graderToExamGradeResponseQ", new Object[]{ examId, grade } );
    }
}
