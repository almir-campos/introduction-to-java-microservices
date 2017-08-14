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
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author acampos
 */
@Entity
public class ExamQuestion implements Serializable
{
    @Id
    @GeneratedValue
    @Getter @Setter
    private Long id;
    @Getter @Setter
    private Long qna_question_id;
    @Getter @Setter
    private Long qna_answer_id;
    @Getter @Setter
    private boolean deleted;
    
    @ManyToOne
    @JoinColumn( name = "exam_id")
    @JsonIgnore
    @Getter @Setter
    private Exam exam;

}
