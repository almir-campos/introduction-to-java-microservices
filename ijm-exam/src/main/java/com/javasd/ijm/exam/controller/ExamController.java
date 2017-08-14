/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javasd.ijm.exam.controller;

import com.javasd.ijm.exam.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author acampos
 */
@RestController
public class ExamController
{
    @Autowired
    private ExamService examService;
    
    @RequestMapping(
            value ="/",
            method = RequestMethod.GET )
    public Object root()
    {
        return "Exam Microservice - " +
                new java.util.Date();
    }
    
    @RequestMapping(
            value ="/findAll",
            method = RequestMethod.GET )
    public Object findAll()
    {
        return examService.findAll();
    }
}
