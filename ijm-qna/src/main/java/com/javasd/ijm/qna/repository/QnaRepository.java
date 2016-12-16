/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javasd.ijm.qna.repository;

import com.javasd.ijm.qna.entity.Question;
import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author acampos
 */
@Transactional
public interface QnaRepository extends
        CrudRepository<Question, Long>
{
    
}
