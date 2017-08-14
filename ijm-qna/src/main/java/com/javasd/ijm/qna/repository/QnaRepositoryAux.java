/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javasd.ijm.qna.repository;

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
public class QnaRepositoryAux
{

    @PersistenceContext
    private EntityManager entityManager;

    /**
     *
     * @param nQuestions
     * @return
     */
    public Object getRandomQuestions(int nQuestions)
    {
        Object randomQuestions = entityManager
                .createQuery(
                        "from Question q order by rand()")
                .setMaxResults( nQuestions )
                .getResultList();
        return randomQuestions;
    }
}
