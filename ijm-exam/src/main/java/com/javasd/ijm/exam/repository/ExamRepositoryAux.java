/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javasd.ijm.exam.repository;

import com.javasd.ijm.exam.entity.Exam;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

/**
 *
 * @author acampos
 */
@Repository
@Transactional
public class ExamRepositoryAux
{
    @PersistenceContext
    private EntityManager entityManager;
    
    public Exam saveExam( Exam exam )
    {
        return (Exam) entityManager.merge( exam );
    }
}