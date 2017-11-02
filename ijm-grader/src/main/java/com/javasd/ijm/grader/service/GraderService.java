/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javasd.ijm.grader.service;

import com.javasd.ijm.commons.deo.qna.Question;
import com.javasd.ijm.commons.utils.Utils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author acampos
 */
@Service
public class GraderService
{

    @Autowired
    private RestTemplate restTemplate;
    
    @Autowired
    private String qnaBase;

    public List<Question> findOriginalQuestions(List<Question> answeredQuestions)
    {
        List<Long> answeredQuestionIds = new ArrayList();
        for (Question answeredQuestion : answeredQuestions)
        {
            answeredQuestionIds.add(answeredQuestion.getId());
        }

        String qnaFindAllByIdUrl = qnaBase + "/findAllById";

        Question[] originalQuestionsArr = restTemplate.postForObject(
                qnaFindAllByIdUrl,
                answeredQuestionIds,
                Question[].class
        );
        
        for ( Question originalQuestion : originalQuestionsArr )
        {
            Utils.consoleMsg("GRADER SERVICE/ORIGINAL QUESTION: "
                    + originalQuestion.getDescription());
        }
        
        return Arrays.asList(originalQuestionsArr);
    }
}
