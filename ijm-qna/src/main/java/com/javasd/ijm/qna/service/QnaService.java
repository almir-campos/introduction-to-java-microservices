/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javasd.ijm.qna.service;

import com.javasd.ijm.qna.repository.QnaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author acampos
 */
@Service
public class QnaService
{
    @Autowired
    private QnaRepository qnaRepository;
    
    public Object findAll()
    {
        return qnaRepository.findAll();
    }
}
