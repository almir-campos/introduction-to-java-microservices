/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javasd.ijm.exam.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author acampos
 */
@Entity
public class Exam implements Serializable
{
    @Id
    @GeneratedValue
    @Getter @Setter
    private Long id;
    @Getter @Setter
    private String description;
    @Getter @Setter
    private Double grade;
    @Getter @Setter
    private boolean deleted;
    @Getter @Setter
    @OneToMany(
    mappedBy = "exam",
            cascade = CascadeType.ALL )
    private List<ExamQuestion> examQuestions;

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
