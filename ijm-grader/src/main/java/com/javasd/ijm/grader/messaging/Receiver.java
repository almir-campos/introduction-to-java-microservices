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
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 *
 * @author acampos
 */
@Component
public class Receiver
{
    @Autowired
    private Sender sender;

    @Bean
    public Queue examToGraderGradeRequestQ()
    {
        return new Queue("examToGraderGradeRequestQ", false);
    }

    @RabbitListener(queues = "examToGraderGradeRequestQ")
    public void receiveFromExamToGraderGradeRequestQ(Object[] objects)
    {
        Long examId = (Long) objects[0];
        List<Question> questions = (List<Question>) objects[1];
        
        Utils.consoleMsg("GRADER/RECEIVER/EXAM ID: " + examId);
        
        for (Question question : questions)
        {
            Utils.consoleMsg("GRADER/RECEIVER/QUESTION: " + question.getDescription());
        }
        
        double grade = -1.0;
        
        sender.sendToGraderToExamGradeResponseQ( examId, grade );
    }
}
