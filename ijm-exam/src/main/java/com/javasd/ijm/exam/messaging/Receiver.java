/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javasd.ijm.exam.messaging;

import com.javasd.ijm.commons.deo.qna.Question;
import com.javasd.ijm.commons.utils.Utils;
import java.util.List;
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
    public Queue graderToExamGradeResponseQ()
    {
        return new Queue("graderToExamGradeResponseQ", false);
    }

    @RabbitListener(queues = "graderToExamGradeResponseQ")
    public void receiveFromGraderToExamGradeResponseQ(Object[] objects)
    {
        Long examId = (Long) objects[0];
        Double grade = (Double) objects[1];
        
        Utils.consoleMsg("EXAM/RECEIVER/EXAM ID: " + examId + ", GRADE: " + grade );
        
    }
}
