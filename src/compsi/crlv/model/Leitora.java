/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package compsi.crlv.model;

import compsi.crlv.controller.Logger;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.smartcardio.CardException;
import javax.swing.JOptionPane;
//import pkcs11_lea.log.Logger;
import compsi.crlv.controller.PCSCManager;
import java.util.ArrayList;
import java.util.Iterator;
import static pkcs11_lea.prompt.CommandProcessor.getCommand;
//import compsi.crlv.model.ModelCommand;
import pkcs11_lea.util.Hex;
import pkcs11_lea.util.StringUtil;

/**
 *
 * @author allan
 */
public class Leitora {
    
    private Object[] readers;
    public static final String PROP_READERS = "readers";

    public Object[] getReaders() {
        Object[] readers = null;

        try {
            readers = PCSCManager.getTerminalsList().toArray();
        } catch (CardException e) {
            JOptionPane.showMessageDialog(null, "Nenhuma leitora instalada",
                    "Erro", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }

        return readers;
    }

    public void setReaders(Object[] readers) {
        Object[] oldReaders = this.readers;
        this.readers = readers;
        propertyChangeSupport.firePropertyChange(PROP_READERS, oldReaders, readers);
    }
    private transient final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }

        private String console;
    public static final String PROP_CONSOLE = "console";

    public String getConsole() {
        return console;
    }

    public void setConsole(String console) {
        String oldConsole = this.console;
        this.console = console;
        propertyChangeSupport.firePropertyChange(PROP_CONSOLE, oldConsole, console);
    }
    
    public String Select_APPL() throws CardException,
            FileNotFoundException,
            IOException {
        byte[] response = null;
        String resultado = null;

        PCSCManager.LOGAR("SELECIONAR O APLICATIVO");
        response = PCSCManager.sendAPDU("00A4040007A04C5349444F43");
        resultado = Hex.printBytesHexa(response);

        return resultado.substring(resultado.length() - 4, resultado.length());
    }

   
    
    
}
