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

    /**
     *
     * @return
     */
    @Bean
    public Queue examToGraderGradeRequestQ()
    {
        return new Queue("examToGraderGradeRequestQ", false);
    }

    /**
     *
     * @param examId
     * @param questions
     */
    public void sendToExamToGraderGradeRequestQ(
            Long examId, List<Question> questions)
    {
        Utils.consoleMsg("EXAM/SEND TO GRADER/EXAM ID: " + examId);
        for (Question question : questions)
        {
            Utils.consoleMsg("EXAM/SEND TO GRADER/QUESTION: " + 
                    question.getDescription());
        }
        rmTemplate.convertAndSend("examToGraderGradeRequestQ", new Object[]
        {
            examId, questions
        });
    }

    /**
     *
     * @return
     */
    @Bean
    public Queue examToLoggerRequestQ()
    {
        return new Queue("examToLoggerRequestQ", false);
    }

    /**
     *
     * @param examId
     */
    public void sendToExamToLoggerRequestQ(Long examId)
    {
        Utils.consoleMsg("EXAM/SEND TO LOGGER/EXAM ID: " + examId);
        rmTemplate.convertAndSend("examToLoggerRequestQ", examId);
    }
    
    @Bean
    public Queue examToUiGradedExamQ()
    {
        return new Queue( "examToUiGradedExamQ", false );
    }
    
    public void sendToExamToUiGradedExamQ( Long examId, Double examGrade )
    {
        Utils.consoleMsg("EXAM/SEND GRADED EXAM TO UI/EXAM ID:  " + examId 
        + ", EXAM GRADE: " + examGrade );
        rmTemplate.convertAndSend( "examToUiGradedExamQ", new Object[]{ examId, examGrade} );
    }
}
