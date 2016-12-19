/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javasd.ijm.exam.controller;

import com.javasd.ijm.exam.entity.Exam;
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

    /**
     *
     * @return
     */
    @RequestMapping(
            value = "/",
            method = RequestMethod.GET)
    public Object root()
    {
        return "Exam Microservice - " +
                new java.util.Date();
    }

    /**
     *
     * @return
     */
    @RequestMapping(
            value = "/findAll",
            method = RequestMethod.GET)
    public Object findAll()
    {
        return examService.findAll();
    }

    /**
     *
     * @param examId
     * @return
     */
    @RequestMapping(
            value = "/findOne",
            method = RequestMethod.GET)
    public Object findOne(Long examId)
    {
        return examService.findOne(examId);
    }

    /**
     *
     * @param examId
     * @return
     */
    @RequestMapping(
            value = "/examQnaQuestionIds",
            method = RequestMethod.GET)
    public Object examQnaQuestionIds(Long examId)
    {
        Exam exam = (Exam) examService.findOne(examId);
        return exam.getQnaQuestionIds();
    }
    
    @RequestMapping(
            value = "/examQnaQuestions",
            method = RequestMethod.GET)
    public Object examQnaQuestions(Long examId)
    {
        return examService.examQnaQuestions(examId);
    }

}
