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
    
}
