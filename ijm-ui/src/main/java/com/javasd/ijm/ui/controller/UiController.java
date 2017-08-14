/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javasd.ijm.ui.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author acampos
 */
@RestController
public class UiController
{

    @RequestMapping(
            value = "/findAll",
            method = RequestMethod.GET)
    public Object findAll()
    {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:9005/findAll";
        Object exams = restTemplate.getForObject(
                url,
                Object.class);
        return exams;
    }
    
    @RequestMapping(
            value = "/examQnaQuestions",
            method = RequestMethod.GET)
    public Object examQnaQuestions(Long examId )
    {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:9005/" +
                "examQnaQuestions?examId=" + examId;
        Object questions = restTemplate.getForObject(
                url,
                Object.class);
        return questions;
    }
}
