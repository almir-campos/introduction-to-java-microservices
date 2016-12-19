/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javasd.ijm.exam.service;

import com.javasd.ijm.commons.deo.qna.Question;
import com.javasd.ijm.exam.entity.Exam;
import com.javasd.ijm.exam.repository.ExamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author acampos
 */
@Service
public class ExamService
{

    @Autowired
    private ExamRepository examRepository;

    /**
     *
     * @return
     */
    public Object findAll()
    {
        return examRepository.findAll();
    }

    /**
     *
     * @param examId
     * @return
     */
    public Object findOne(Long examId)
    {
        return examRepository.findOne(examId);
    }

    /**
     *
     * @param examId
     * @return
     */
    public Object examQnaQuestions(Long examId)
    {
        Exam exam = (Exam) findOne(examId);
        Long[] examIds = exam.getQnaQuestionIds();

        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:9017/findAllById";

        ResponseEntity<Question[]> qnaQuestions
                = restTemplate.postForEntity(
                        url,
                        examIds,
                        Question[].class);

        return qnaQuestions;

    }

    public Object getRandomQuestions(int nQuestions)
    {
        RestTemplate restTemplate = new RestTemplate();
        String url
                = "http://localhost:9017/getRandomQuestions" +
                "?nQuestions=" + nQuestions;

//        ResponseEntity<Question[]> randomQuestions
//                = restTemplate.getForEntity(url,
//                        Question[].class);
        Object randomQuestions = restTemplate.
                getForObject(url, Object.class);

        return randomQuestions;
    }
}
