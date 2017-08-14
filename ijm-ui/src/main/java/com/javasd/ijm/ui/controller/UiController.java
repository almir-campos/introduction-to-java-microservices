/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javasd.ijm.ui.controller;

import com.javasd.ijm.commons.deo.qna.Question;
import com.javasd.ijm.commons.utils.Utils;
import com.javasd.ijm.ui.service.UiService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import java.net.URI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
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
@EnableCircuitBreaker
public class UiController
{

    @Autowired
    private UiService uiService;

    /**
     *
     * @return
     */
    @RequestMapping(
            value = "/findAll",
            method = RequestMethod.GET)
    public Object findAll()
    {
        return uiService.findAll();
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
        return uiService.examQnaQuestions(examId);
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
        return uiService.examQnaQuestionsHideCorrect(examId);
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
        Utils.consoleMsg("EXAM ID/controller/getAnsweredExam: " + examId );
        return uiService.getAnsweredExam(examId);
    }

    /**
     *
     * @param nQuestions
     * @return
     */
    @RequestMapping(value = "/getRandomQuestionsHideCorrect",
            method = RequestMethod.GET)
    public Object getRandomQuestionsHideCorrect(int nQuestions)
    {
        return uiService.getRandomQuestionsHideCorrect(nQuestions);
    }

    /**
     *
     * @param questions
     * @param examDescription
     */
    @RequestMapping(value = "/saveExam",
            method = RequestMethod.POST)
    public void saveExam(
            @RequestBody List<Question> questions,
            String examDescription)
    {
        uiService.saveExam(questions, examDescription);

    }

    @RequestMapping(
            value = "/deleteExam",
            method = RequestMethod.POST)
    public Object deleteExam(Long examId)
    {
//        Utils.consoleMsg("EXAM ID/controller: " + examId);
        return uiService.deleteExam(examId);
    }
    
    @RequestMapping(
            value = "/updateExamDescription",
            method = RequestMethod.POST)
    public Object updateExamDescription( Long examId, String examDescription )
    {
        return uiService.updateExamDescription(examId, examDescription);
    }

    @HystrixCommand(
            fallbackMethod = "checkExamMsFallBack",
            commandProperties =
            {
                @HystrixProperty(
                        name = "execution.isolation.thread.timeoutInMilliseconds",
                        value = "5000")
            }
    )
    @RequestMapping( value = "/checkExamMs", method = RequestMethod.GET )
    public Object checkExamMs()
    {
        URI uri = URI.create("http://localhost:9005");
        RestTemplate restTemplate = new RestTemplate();
        Object returnObject = restTemplate.getForObject(uri, String.class);
        return "{ \"status\": \"OK\" }";
    }
    
    private Object checkExamMsFallBack()
    {
        return "{ \"status\": \"NOK\" }";
    }
}
