/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javasd.ijm.qna.repository;

import com.javasd.ijm.qna.entity.Question;
import java.util.List;
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
    public List<Question> getRandomQuestions(int nQuestions)
    {
        List<Question> randomQuestions = entityManager
                .createQuery(
                        "from Question q order by rand()")
                .setMaxResults( nQuestions )
                .getResultList();
        return randomQuestions;
    }
}
