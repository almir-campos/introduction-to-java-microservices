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
    private static int msgNumber = 0;

    /**
     *
     * @param msg
     */
    public static void consoleMsg(String msg)
    {
        consoleMsg( msg, "default");
    }

    /**
     *
     * @param msg
     * @param color
     */
    public static void consoleMsg(String msg, String color)
    {
        String ansiColor;
        switch (color)
        {
            case "ok":
            {
                ansiColor = "[32m"; //green
                break;
            }
            case "error":
            {
                ansiColor = "[31m"; //red
                break;
            }
            default:
            {
                ansiColor = "[34m"; //blue
            }
        }
        SimpleDateFormat sdf = new SimpleDateFormat(
                "MMM dd,yyyy HH:mm:ss.SSS");
        
        System.out.println(
                "\n" +
                "\033" +
                ansiColor +
                "===>>> " +
                sdf.format(new java.util.Date()) +
                " <<<===" +
                "\n" +
                "\033" +
                ansiColor +
                msg +
                "\n"
        );
    }
}
