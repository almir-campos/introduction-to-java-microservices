/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javasd.ijm.exam.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author acampos
 */
@Entity
public class Exam implements Serializable
{
    @Id
    @GeneratedValue
    private Long id;
    private String description;
    private Double grade;
    private boolean deleted;
    
    @OneToMany(
    mappedBy = "exam",
            cascade = CascadeType.ALL )
    private List<ExamQuestion> examQuestions;

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
    public Double getGrade()
    {
        return grade;
    }

    /**
     *
     * @param grade
     */
    public void setGrade(Double grade)
    {
        this.grade = grade;
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
    public List<ExamQuestion> getExamQuestions()
    {
        return examQuestions;
    }

    /**
     *
     * @param examQuestions
     */
    public void setExamQuestions(
                                 List<ExamQuestion> examQuestions)
    {
        this.examQuestions = examQuestions;
    }
    
    /**
     *
     * @return
     */
    public Long[] getQnaQuestionIds()
    {
        Long[] ids = new Long[examQuestions.size()];

        int i = 0;
        for (ExamQuestion examQuestion : examQuestions)
        {
            ids[i] = examQuestion.getQna_answer_id();
            i++;
        }
        
        return ids;
    }
}
