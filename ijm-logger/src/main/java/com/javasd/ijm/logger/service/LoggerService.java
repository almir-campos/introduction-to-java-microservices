/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javasd.ijm.logger.service;

import com.javasd.ijm.logger.entity.ExamLog;
import com.javasd.ijm.logger.repository.LoggerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author AlmirCampos <ac@javasd.com>
 */
@Service
public class LoggerService
{
    @Autowired
    private LoggerRepository loggerRepository;
    
    public Object findAll()
    {
        return loggerRepository.findAll();
    }
    
    public Object save( ExamLog examLog )
    {
        return loggerRepository.save( examLog );
    }
    
    public Object findByExamId( Long examId )
    {
        return loggerRepository.findByExamId(examId);
    }
}
