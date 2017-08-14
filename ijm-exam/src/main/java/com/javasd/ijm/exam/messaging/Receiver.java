/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javasd.ijm.exam.messaging;

import com.javasd.ijm.commons.utils.Utils;
import com.javasd.ijm.exam.entity.Exam;
import com.javasd.ijm.exam.service.ExamService;
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
    private ExamService examService;

    @Autowired
    private Sender sender;

    /**
     *
     * @return
     */
    @Bean
    public Queue graderToExamGradeResponseQ()
    {
        return new Queue("graderToExamGradeResponseQ", false);
    }

    /**
     *
     * @param objects
     */
    @RabbitListener(queues = "graderToExamGradeResponseQ")
    public void receiveFromGraderToExamGradeResponseQ(Object[] objects)
    {
        Long examId = (Long) objects[0];
        Double grade = (Double) objects[1];

        Utils.consoleMsg(
                "EXAM/RECEIVER/EXAM ID: " + examId +
                ", GRADE: " + grade);

        Exam updatedExam = (Exam) examService.updateExamGrade(examId, grade);
        
        sender.sendToExamToUiGradedExamQ(examId, grade );
    }
}
