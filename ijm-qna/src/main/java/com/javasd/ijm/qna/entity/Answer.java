/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javasd.ijm.qna.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

/**
 *
 * @author acampos
 */
@Entity
public class Answer implements Serializable
{
    @Id
    @GeneratedValue
    private Long id;
    private String description;
    private boolean correct;
    private boolean deleted;
    @Transient
    private boolean chosen;
    
    @ManyToOne
    @JoinColumn( name = "question_id" )
    @JsonIgnore
    private Question question;

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
    public Question getQuestion()
    {
        return question;
    }

    /**
     *
     * @param question
     */
    public void setQuestion(Question question)
    {
        this.question = question;
    }

    public boolean isChosen()
    {
        return chosen;
    }

    public void setChosen(boolean chosen)
    {
        this.chosen = chosen;
    }
    
    
    
}
