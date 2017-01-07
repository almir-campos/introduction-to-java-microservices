/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javasd.ijm.qna.entity;

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
public class Question implements Serializable
{

    @Id
    @GeneratedValue
    @Getter @Setter
    private Long id;
    @Getter @Setter
    private String description;
    @Getter @Setter
    private boolean deleted;

    @Getter @Setter
    @OneToMany(
            mappedBy = "question",
            cascade = CascadeType.ALL)
    private List<Answer> answers;

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
//    public String getDescription()
//    {
//        return description;
//    }
//
//    /**
//     *
//     * @param description
//     */
//    public void setDescription(String description)
//    {
//        this.description = description;
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
//    /**
//     *
//     * @return
//     */
//    public List<Answer> getAnswers()
//    {
//        return answers;
//    }
//
//    /**
//     *
//     * @param answers
//     */
//    public void setAnswers(List<Answer> answers)
//    {
//        this.answers = answers;
//    }

}
