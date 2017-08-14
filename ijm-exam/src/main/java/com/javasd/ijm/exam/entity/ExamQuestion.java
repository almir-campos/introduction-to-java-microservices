/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javasd.ijm.exam.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author acampos
 */
@Entity
public class ExamQuestion implements Serializable
{
    @Id
    @GeneratedValue
    private Long id;
    private Long qna_question_id;
    private Long qna_answer_id;
    private boolean deleted;
    
    @ManyToOne
    @JoinColumn( name = "exam_id")
    @JsonIgnore
    private Exam exam;

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getQna_question_id()
    {
        return qna_question_id;
    }

    public void setQna_question_id(Long qna_question_id)
    {
        this.qna_question_id = qna_question_id;
    }

    public Long getQna_answer_id()
    {
        return qna_answer_id;
    }

    public void setQna_answer_id(Long qna_answer_id)
    {
        this.qna_answer_id = qna_answer_id;
    }


    public boolean isDeleted()
    {
        return deleted;
    }

    public void setDeleted(boolean deleted)
    {
        this.deleted = deleted;
    }

    public Exam getExam()
    {
        return exam;
    }

    public void setExam(Exam exam)
    {
        this.exam = exam;
    }
    
}
