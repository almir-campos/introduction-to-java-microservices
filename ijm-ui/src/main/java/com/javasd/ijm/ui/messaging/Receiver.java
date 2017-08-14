/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javasd.ijm.ui.messaging;

import com.javasd.ijm.commons.utils.Utils;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 *
 * @author acampos
 */
@Component
public class Receiver
{

   @Bean
   public Queue examToUiGradedExamQ()
   {
       return new Queue( "examToUiGradedExamQ", false );
   }

   @RabbitListener( queues = "examToUiGradedExamQ")
   public void receiveFromExamToUiGradedExamQ( Object[] objects )
   {
       Long examId = (Long) objects[0];
       Double examGrade = (Double) objects[1];
       
       Utils.consoleMsg( "UI/RECEIVE FROM EXAM TO UI GRADED EXAM/EXAM ID: " + examId +
               ", EXAM GRADE: " + examGrade );
   }
}
