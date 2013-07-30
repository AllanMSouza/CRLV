/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package compsi.crlv.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 *
 * @author allan
 */
public class SmartCard {
    
    private String resultado;
    public static final String PROP_RESULTADO = "resultado";

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        String oldResultado = this.resultado;
        this.resultado = resultado;
        propertyChangeSupport.firePropertyChange(PROP_RESULTADO, oldResultado, resultado);
    }
    private transient final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }

        private byte[] response;
    public static final String PROP_RESPONSE = "response";

    public byte[] getResponse() {
        return response;
    }

    public void setResponse(byte[] response) {
        byte[] oldResponse = this.response;
        this.response = response;
        propertyChangeSupport.firePropertyChange(PROP_RESPONSE, oldResponse, response);
    }

}
