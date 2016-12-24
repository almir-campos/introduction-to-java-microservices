/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javasd.ijm.ui.service;

import com.javasd.ijm.commons.deo.exam.Exam;
import com.javasd.ijm.commons.deo.exam.ExamQuestion;
import com.javasd.ijm.commons.deo.qna.Answer;
import com.javasd.ijm.commons.deo.qna.Question;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author acampos
 */
@Service
public class UiService
{

    @Autowired
    private RestTemplate restTemplate;

    /**
     *
     * @return
     */
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
    public Object getRandomQuestionsHideCorrect(int nQuestions)
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

    /**
     *
     * @param questions
     * @param examDescription
     */
    public void saveExam(
            @RequestBody List<Question> questions,
            String examDescription)
    {

        

        String url = "http://localhost:9005/saveExam" +
                "?examDescription="+examDescription;

        restTemplate.postForObject(
                url,
                questions,
                List.class
        );
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
