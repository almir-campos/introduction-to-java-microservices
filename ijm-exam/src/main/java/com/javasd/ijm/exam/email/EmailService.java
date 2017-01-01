/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javasd.ijm.exam.email;

import com.javasd.ijm.commons.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 *
 * @author acampos
 */
@Service
public class EmailService
{

    @Autowired
    private JavaMailSender javaMailSender;

    @Async
    public void sendMail( String subject, String text )
    {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo("supervisor@javasd.com");
        simpleMailMessage.setFrom("instructor@javasd.com");
        simpleMailMessage.setSubject( subject );
        simpleMailMessage.setText( text );
        javaMailSender.send(simpleMailMessage);
    }
}
