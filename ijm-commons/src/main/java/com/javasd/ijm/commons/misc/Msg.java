/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javasd.ijm.commons.misc;

import java.io.Serializable;

/**
 *
 * @author AlmirCampos, ac@javasd.com
 */
public class Msg implements Serializable
{

    private String msg;

    /**
     *
     */
    public Msg()
    {
    }

    /**
     *
     * @param msg
     */
    public Msg(String msg)
    {
        this.msg = msg;
    }

    /**
     *
     * @return
     */
    public String getMsg()
    {
        return msg;
    }

}
