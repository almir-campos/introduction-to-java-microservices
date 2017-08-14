/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javasd.ijm.grader.messaging;

import com.javasd.ijm.commons.deo.qna.Question;
import com.javasd.ijm.commons.utils.Utils;
import com.javasd.ijm.grader.service.GradeCalculator;
import com.javasd.ijm.grader.service.GraderService;
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
    
    @Autowired
    private GraderService graderService;

    @Bean
    public Queue examToGraderGradeRequestQ()
    {
        return new Queue("examToGraderGradeRequestQ", false);
    }

    @RabbitListener(queues = "examToGraderGradeRequestQ")
    public void receiveFromExamToGraderGradeRequestQ(Object[] objects)
    {
        Long examId = (Long) objects[0];
        List<Question> answeredQuestions = (List<Question>) objects[1];
        
        Utils.consoleMsg("GRADER/RECEIVER/EXAM ID: " + examId);
        
        for (Question question : answeredQuestions)
        {
            Utils.consoleMsg("GRADER/RECEIVER/QUESTION: " + question.getDescription());
        }
        
        List<Question> originalQuestions = graderService.findOriginalQuestions(answeredQuestions);
        
        GradeCalculator gradeCalculator = new GradeCalculator( 
                answeredQuestions,
                originalQuestions);
        
        double grade = gradeCalculator.calcGrade();
        
        sender.sendToGraderToExamGradeResponseQ( examId, grade );
    }
}
