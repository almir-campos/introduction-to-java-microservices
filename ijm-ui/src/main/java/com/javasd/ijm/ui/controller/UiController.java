/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javasd.ijm.ui.controller;

import com.javasd.ijm.commons.deo.exam.Exam;
import com.javasd.ijm.commons.deo.exam.ExamQuestion;
import com.javasd.ijm.commons.deo.qna.Answer;
import com.javasd.ijm.commons.deo.qna.Question;
import com.javasd.ijm.commons.utils.Utils;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author acampos
 */
@RestController
public class UiController
{
    @Autowired
    private RestTemplate restTemplate;

    /**
     *
     * @return
     */
    @RequestMapping(
            value = "/findAll",
            method = RequestMethod.GET)
    public Object findAll()
    {
        String url = "http://localhost:9005/findAll";
        Object exams = restTemplate.getForObject(
                url,
                Object.class);
        return exams;
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
        String url = "http://localhost:9005/" +
                "examQnaQuestions?examId=" + examId;
        Object questions = restTemplate.getForObject(
                url,
                Object.class);
        return questions;
    }

    /**
     *
     * @param examId
     * @return
     */
    @RequestMapping(
            value = "/examQnaQuestionsHideCorrect",
            method = RequestMethod.GET)
    public Object examQnaQuestionsHideCorrect(Long examId)
    {
        String url = "http://localhost:9005/" +
                "examQnaQuestions?examId=" + examId;
        Question[] questions = restTemplate.getForObject(
                url,
                Question[].class);
        for (Question question : questions)
        {
            for (Answer answer : question.getAnswers())
            {
                answer.setCorrect(false);
            }
        }
        return questions;
    }

    /**
     *
     * @param examId
     * @return
     */
    @RequestMapping(
            value = "/getAnsweredExam",
            method = RequestMethod.GET)
    public Object getAnsweredExam(Long examId)
    {
        String url = "http://localhost:9005/" +
                "findOne?examId=" + examId;

        Exam exam = restTemplate.getForObject(
                url,
                Exam.class
        );

        url = "http://localhost:9005/" +
                "examQnaQuestions?examId=" + examId;
        Question[] questions = restTemplate.getForObject(
                url,
                Question[].class);
        for (Question question : questions)
        {
            for (Answer answer : question.getAnswers())
            {
                answer.setChosen(
                        isAnsweredAsCorrect(exam, answer));
            }
        }
        return questions;
    }
    
    /**
     *
     * @param nQuestions
     * @return
     */
    @RequestMapping( value = "/getRandomQuestionsHideCorrect",
            method = RequestMethod.GET )
    public Object getRandomQuestionsHideCorrect( int nQuestions)
    {
        String url = "http://localhost:9005/" +
                "getRandomQuestions?nQuestions=" + nQuestions;
        Question[] questions = restTemplate.getForObject(
                url,
                Question[].class);
        for (Question question : questions)
        {
            for (Answer answer : question.getAnswers())
            {
                answer.setCorrect(false);
            }
        }
        return questions;
    }
    
    
    @RequestMapping( value = "/saveExam",
            method = RequestMethod.POST )
    public void saveExam ( @RequestBody List<Question> questions, String examDescription )
    {
        Utils.consoleMsg( examDescription );
        for ( Question question : questions )
        {
            Utils.consoleMsg( question.getDescription() );
        }
    }

    //
    //
    private boolean isAnsweredAsCorrect(Exam exam,
                                        Answer answer)
    {
        for (ExamQuestion examQuestion : exam.
                getExamQuestions())
        {
            if (examQuestion
                    .getQna_answer_id()
                    .longValue() == answer.getId().
                            longValue())
            {
                return true;
            }
        }
        return false;
    }
}
