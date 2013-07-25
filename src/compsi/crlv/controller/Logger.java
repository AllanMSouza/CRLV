/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package compsi.crlv.controller;

import compsi.crlv.view.JIFLeitora;

/**
 *
 * @author allan
 */
public class Logger {
    
    public static void log(String text){

         JIFLeitora.getConsole().setText(JIFLeitora.getConsole().getText() + "\n" + text);
    }
}
