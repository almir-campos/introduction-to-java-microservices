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
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author acampos
 */
@Entity
public class Answer implements Serializable
{
    @Id
    @GeneratedValue
    @Getter @Setter
    private Long id;
    @Getter @Setter
    private String description;
    @Getter @Setter
    private boolean correct;
    @Getter @Setter
    private boolean deleted;
    @Getter @Setter
    @Transient
    private boolean chosen;
    
    @Getter @Setter
    @ManyToOne
    @JoinColumn( name = "question_id" )
    @JsonIgnore
    private Question question;
   
}
