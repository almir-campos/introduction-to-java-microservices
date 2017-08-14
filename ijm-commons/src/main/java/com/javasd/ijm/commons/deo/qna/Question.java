/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javasd.ijm.commons.deo.qna;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author acampos
 */
public class Question implements Serializable
{

    private Long id;
    private String description;
    private boolean deleted;
    private List<Answer> answers;

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
    public List<Answer> getAnswers()
    {
        return answers;
    }

    /**
     *
     * @param answers
     */
    public void setAnswers(List<Answer> answers)
    {
        this.answers = answers;
    }

}
