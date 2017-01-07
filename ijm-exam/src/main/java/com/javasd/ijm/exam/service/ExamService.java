/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javasd.ijm.exam.service;

import com.javasd.ijm.commons.deo.qna.Answer;
import com.javasd.ijm.commons.deo.qna.Question;
import com.javasd.ijm.commons.utils.Utils;
import com.javasd.ijm.exam.entity.Exam;
import com.javasd.ijm.exam.entity.ExamQuestion;
import com.javasd.ijm.exam.messaging.Sender;
import com.javasd.ijm.exam.repository.ExamRepository;
import com.javasd.ijm.exam.repository.ExamRepositoryAux;
import java.util.ArrayList;
import java.util.List;
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
    @Autowired
    private ExamRepositoryAux examRepositoryAux;
    @Autowired
    private Sender sender;

    /**
     *
     * @param includeDeleted
     * @return
     */
    public Object findAll(boolean includeDeleted)
    {
        if (includeDeleted)
        {
            return examRepository.findByOrderByIdDesc();
        }
        return examRepository.findByDeletedFalseOrderByIdDesc();
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

    /**
     *
     * @param nQuestions
     * @return
     */
    public Object getRandomQuestions(int nQuestions)
    {
        RestTemplate restTemplate = new RestTemplate();
        String url
                = "http://localhost:9017/getRandomQuestions" +
                "?nQuestions=" + nQuestions;

        Object randomQuestions = restTemplate.
                getForObject(url, Object.class);

        return randomQuestions;
    }

    /**
     *
     * @param questions
     * @param examDescription
     */
    public void saveExam(List<Question> questions, String examDescription)
    {
        Exam exam = new Exam();
        exam.setId(0L);
        exam.setDescription(examDescription);

//        Utils.consoleMsg(examDescription);
        List<ExamQuestion> examQuestions = new ArrayList();
        ExamQuestion examQuestion;
        for (Question question : questions)
        {
            //Utils.consoleMsg(question.getDescription());

            examQuestion = new ExamQuestion();
            examQuestion.setExam(exam);
            examQuestion.setQna_question_id(question.getId());

            for (Answer answer : question.getAnswers())
            {
                if (answer.isChosen())
                {
                    examQuestion.setQna_answer_id(answer.getId());

                    break;
                }
            }
            examQuestions.add(examQuestion);
        }

        exam.setExamQuestions(examQuestions);
        Exam savedExam = examRepositoryAux.saveExam(exam);

        sender.sendToExamToLoggerRequestQ(savedExam.getId());
        sender.sendToExamToGraderGradeRequestQ(savedExam.getId(), questions);

    }

    /**
     *
     * @param examId
     * @return
     */
    public Object deleteExam(Long examId)
    {
        Exam examToDelete = examRepository.findOne(examId);
        examToDelete.setDeleted(true);
        return examRepository.save(examToDelete);
    }

    /**
     *
     * @param examId
     * @param examDescription
     * @return
     */
    public Object updateExamDescription(Long examId, String examDescription)
    {
        Exam examToDelete = examRepository.findOne(examId);
        examToDelete.setDescription(examDescription);
        return examRepository.save(examToDelete);
    }

    /**
     *
     * @param examId
     * @param grade
     * @return
     */
    public Object updateExamGrade(Long examId, Double grade)
    {
        Exam loadedExam = (Exam) findOne(examId);
        loadedExam.setGrade(grade);
        return examRepository.save(loadedExam);
    }

}
