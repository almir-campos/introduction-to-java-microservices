/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javasd.ijm.exam.controller;

import com.javasd.ijm.commons.deo.qna.Question;
import com.javasd.ijm.commons.utils.Utils;
import com.javasd.ijm.exam.entity.Exam;
import com.javasd.ijm.exam.service.ExamService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
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

    /**
     *
     * @param examId
     * @return
     */
    @RequestMapping(
            value = "/examQnaQuestions",
            method = RequestMethod.GET)
    public Object examQnaQuestions(Long examId)
    {
        return examService.examQnaQuestions(examId);
    }

    /**
     *
     * @param nQuestions
     * @return
     */
    @RequestMapping(
            value = "/getRandomQuestions",
            method = RequestMethod.GET)
    public Object getRandomQuestions(Integer nQuestions)
    {
        return examService.getRandomQuestions(nQuestions);
    }

    /**
     *
     * @param questions
     * @param examDescription
     */
    @RequestMapping(
            value = "/saveExam",
            method = RequestMethod.POST)
    public void saveExam(@RequestBody List<Question> questions, String examDescription )
    {
        examService.saveExam( questions , examDescription );
    }
    
    @RequestMapping(
            value = "/deleteExam",
            method = RequestMethod.POST )
    public Object deleteExam( @RequestBody Exam exam )
    {
        Long examId = exam.getId();
        Utils.consoleMsg( "EXAM/CONTROLLER/DELETE EXAM/EXAM ID: " + examId );
        return examService.deleteExam(examId);
    }
}
