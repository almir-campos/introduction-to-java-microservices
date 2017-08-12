package com.javasd.ijm.basics.controller;

import com.javasd.ijm.commons.misc.Msg;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author AlmirCampos, ac@javasd.com
 */
@RestController
public class BasicsController
{

    /**
     *
     * @return
     */
    @RequestMapping( value = "/", method = RequestMethod.GET )
    public Object root()
    {
        return "Basics Microservices - Up and Running!";
    }

    
    /**
     *
     * @return
     */
    @RequestMapping( value = "/msgGet", method = RequestMethod.GET )
    public Object msgGet()
    {
        return new Msg( "Sending an object!");
    }
    
}
