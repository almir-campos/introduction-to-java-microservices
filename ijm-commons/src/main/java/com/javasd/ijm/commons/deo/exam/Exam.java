/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javasd.ijm.commons.deo.exam;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author acampos
 */
public class Exam implements Serializable
{
    @Getter @Setter
    private Long id;
    @Getter @Setter
    private String description;
    @Getter @Setter
    private Double grade;
    @Getter @Setter
    private boolean deleted;
    @Getter @Setter
    private List<ExamQuestion> examQuestions;

    /**
     *
     * @return
     */
    @JsonIgnore
    public Long[] getQnaQuestionIds()
    {
        Long[] ids = new Long[examQuestions.size()];

        int i = 0;
        for (ExamQuestion examQuestion : examQuestions)
        {
            ids[i] = examQuestion.getQna_question_id();
            i++;
        }
        
        return ids;
    }
}
