/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javasd.ijm.logger.messaging;

import com.javasd.ijm.commons.utils.Utils;
import com.javasd.ijm.logger.entity.ExamLog;
import com.javasd.ijm.logger.service.LoggerService;
import java.util.Date;
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
    private LoggerService loggerService;
            
    @Bean
    public Queue examToLoggerRequestQ()
    {
        return new Queue( "examToLoggerRequestQ", false );
    }
    
    @RabbitListener( queues = "examToLoggerRequestQ")
    public void receiveFromExamToLoggerRequestQ( Long examId )
    {
        Utils.consoleMsg( "EXAM/LOGGER/RECEIVE FROM EXAM/EXAM ID: " + examId );
        ExamLog examLog = new ExamLog();
        examLog.setExamId(examId);
        examLog.setDateReceived( new Date() );
        examLog.setDeleted( false );
        loggerService.save(examLog);
    }
    
    @Bean
    public Queue graderToLoggerRequestQ()
    {
        return new Queue ( "graderToLoggerRequestQ", false );
    }
    
    @RabbitListener( queues = "graderToLoggerRequestQ" )
    public void receiveFromGraderToLoggerRequestQ( Object[] objects )
    {
        Long examId = (Long) objects[0];
        Double grade = (Double ) objects[1];
        
        Utils.consoleMsg("LOGGER/RECEIVE FROM GRADER TO LOGGER/EXAM ID: " + examId + ", GRADE: " + grade);
        
        ExamLog examLog = (ExamLog) loggerService.findByExamId( examId );
        Utils.consoleMsg("===>>> EXAM LOG: " + examLog );
        Utils.consoleMsg("===>>> EXAM LOG/ID: " + examLog.getId() );
        examLog.setDataGraded(new Date() );
        examLog.setGrade(grade);
        ExamLog savedExamLog = (ExamLog) loggerService.save(examLog);
        Utils.consoleMsg("===>>> LOADED ID: " +  savedExamLog.getId());
    }
}
