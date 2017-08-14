/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javasd.ijm.logger.repository;

import com.javasd.ijm.logger.entity.ExamLog;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author AlmirCampos <ac@javasd.com>
 */
public interface LoggerRepository extends CrudRepository<ExamLog, String>
{
    
}
