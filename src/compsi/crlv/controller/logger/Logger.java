/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package compsi.crlv.controller.logger;

import compsi.crlv.view.ViewLeitora;

/**
 *
 * @author allan
 */
public class Logger {
    
    public static void log(String text){

         ViewLeitora.getConsole().setText(ViewLeitora.getConsole().getText() + "\n" + text);
    }
}
