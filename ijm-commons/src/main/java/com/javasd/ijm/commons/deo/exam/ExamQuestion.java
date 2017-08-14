/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javasd.ijm.commons.deo.exam;

import java.io.Serializable;

/**
 *
 * @author acampos
 */
public class ExamQuestion implements Serializable
{
    private Long id;
    private Long qna_question_id;
    private Long qna_answer_id;
    private boolean deleted;
    

    /**
     *
     * @return
     */
    public Long getId()
    {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(Long id)
    {
        this.id = id;
    }

    /**
     *
     * @return
     */
    public Long getQna_question_id()
    {
        return qna_question_id;
    }

    /**
     *
     * @param qna_question_id
     */
    public void setQna_question_id(Long qna_question_id)
    {
        this.qna_question_id = qna_question_id;
    }

    /**
     *
     * @return
     */
    public Long getQna_answer_id()
    {
        return qna_answer_id;
    }

    /**
     *
     * @param qna_answer_id
     */
    public void setQna_answer_id(Long qna_answer_id)
    {
        this.qna_answer_id = qna_answer_id;
    }

    /**
     *
     * @return
     */
    public boolean isDeleted()
    {
        return deleted;
    }

    /**
     *
     * @param deleted
     */
    public void setDeleted(boolean deleted)
    {
        this.deleted = deleted;
    }

}
