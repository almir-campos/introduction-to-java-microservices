/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javasd.ijm.commons.deo.exam;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author acampos
 */
public class ExamQuestion implements Serializable
{
    @Getter @Setter
    private Long id;
    @Getter @Setter
    private Long qna_question_id;
    @Getter @Setter
    private Long qna_answer_id;
    @Getter @Setter
    private boolean deleted;
    @Getter @Setter
    @JsonIgnore
    private Exam exam = new Exam();
    

//    /**
//     *
//     * @return
//     */
//    public Long getId()
//    {
//        return id;
//    }
//
//    /**
//     *
//     * @param id
//     */
//    public void setId(Long id)
//    {
//        this.id = id;
//    }
//
//    /**
//     *
//     * @return
//     */
//    public Long getQna_question_id()
//    {
//        return qna_question_id;
//    }
//
//    /**
//     *
//     * @param qna_question_id
//     */
//    public void setQna_question_id(Long qna_question_id)
//    {
//        this.qna_question_id = qna_question_id;
//    }
//
//    /**
//     *
//     * @return
//     */
//    public Long getQna_answer_id()
//    {
//        return qna_answer_id;
//    }
//
//    /**
//     *
//     * @param qna_answer_id
//     */
//    public void setQna_answer_id(Long qna_answer_id)
//    {
//        this.qna_answer_id = qna_answer_id;
//    }
//
//    /**
//     *
//     * @return
//     */
//    public boolean isDeleted()
//    {
//        return deleted;
//    }
//
//    /**
//     *
//     * @param deleted
//     */
//    public void setDeleted(boolean deleted)
//    {
//        this.deleted = deleted;
//    }
//
//    public Exam getExam()
//    {
//        return exam;
//    }
//
//    public void setExam(Exam exam)
//    {
//        this.exam = exam;
//    }

    
}
