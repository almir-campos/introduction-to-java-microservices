/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javasd.ijm.commons.deo.qna;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author acampos
 */
public class Answer implements Serializable
{

    @Getter
    @Setter
    private Long id;
    @Getter
    @Setter
    private String description;
    @Getter
    @Setter
    private boolean correct;
    @Getter
    @Setter
    private boolean deleted;
    @Getter
    @Setter
    private boolean chosen;

}
