/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javasd.ijm.commons.utils;

import java.text.SimpleDateFormat;

/**
 *
 * @author acampos
 */
public class Utils
{

    public static void consoleMsg(String msg)
    {
        SimpleDateFormat sdf = new SimpleDateFormat(
                "MMM dd,yyyy HH:mm:ss.SSS");

        System.out.println(
                "\n===>>> " +
                sdf.format( new java.util.Date() ) +
                " <<<===" +
                "\n" +
                msg +
                "\n"
        );
    }
}
