/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javasd.ijm.logger.controller;

import com.javasd.ijm.logger.entity.ExamLog;
import com.javasd.ijm.logger.service.LoggerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author AlmirCampos <ac@javasd.com>
 */
@RestController
public class LoggerController
{
    @Autowired
    private LoggerService loggerService;
    
    @RequestMapping( value = "/findAll", method = RequestMethod.GET )
    public Object findAll()
    {
        return loggerService.findAll();
    }
    
    @RequestMapping( value = "/saveExamLog", method = RequestMethod.POST )
    public Object saveExamLog( @RequestBody ExamLog examLog )
    {
        return loggerService.save(examLog);
    }
    
    @RequestMapping( value = "/findByExamId", method=RequestMethod.GET)
    public Object findOne( Long examId )
    {
        return loggerService.findByExamId(examId);
    }
            
}
