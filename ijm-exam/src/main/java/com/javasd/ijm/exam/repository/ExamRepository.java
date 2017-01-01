/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javasd.ijm.exam.repository;

import com.javasd.ijm.exam.entity.Exam;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author acampos
 */
@Transactional
public interface ExamRepository
        extends CrudRepository<Exam, Long>
{

    /**
     *
     * @return
     */
    List<Exam> findByOrderByIdDesc();

    /**
     *
     * @return
     */
    List<Exam> findByDeletedFalseOrderByIdDesc();
}
