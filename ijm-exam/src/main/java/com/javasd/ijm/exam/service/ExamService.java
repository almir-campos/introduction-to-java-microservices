/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javasd.ijm.exam.service;

import com.javasd.ijm.exam.repository.ExamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author acampos
 */
@Service
public class ExamService
{
    @Autowired
    private ExamRepository examRepository;
            
    /**
     *
     * @return
     */
    public Object findAll()
    {
        return examRepository.findAll();
    }
    
    /**
     *
     * @param examId
     * @return
     */
    public Object findOne( Long examId )
    {
        return examRepository.findOne( examId );
    }
}
