/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javasd.ijm.ui.controller;

import com.javasd.ijm.commons.deo.qna.Question;
import com.javasd.ijm.ui.service.UiService;
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

}
