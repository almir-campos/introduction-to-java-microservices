/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javasd.ijm.commons.deo.qna;

import java.io.Serializable;

/**
 *
 * @author acampos
 */
public class Answer implements Serializable
{
    private Long id;
    private String description;
    private boolean correct;
    private boolean deleted;
    //private Question question;

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
    public String getDescription()
    {
        return description;
    }

    /**
     *
     * @param description
     */
    public void setDescription(String description)
    {
        this.description = description;
    }

    /**
     *
     * @return
     */
    public boolean isCorrect()
    {
        return correct;
    }

    /**
     *
     * @param correct
     */
    public void setCorrect(boolean correct)
    {
        this.correct = correct;
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

    /**
     *
     * @return
     */
//    public Question getQuestion()
//    {
//        return question;
//    }
//
//    /**
//     *
//     * @param question
//     */
//    public void setQuestion(Question question)
//    {
//        this.question = question;
//    }
    
    
}
