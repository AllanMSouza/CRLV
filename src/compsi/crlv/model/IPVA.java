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
 * 
 *
 */
public class IPVA {
   
        private Boolean isCotaUnica;
    public static final String PROP_ISCOTAUNICA = "isCotaUnica";

    public Boolean getIsCotaUnica() {
        return isCotaUnica;
    }

    public void setIsCotaUnica(Boolean isCotaUnica) {
        Boolean oldIsCotaUnica = this.isCotaUnica;
        this.isCotaUnica = isCotaUnica;
        propertyChangeSupport.firePropertyChange(PROP_ISCOTAUNICA, oldIsCotaUnica, isCotaUnica);
    }

    
    private String cotaUnica;
    public static final String PROP_COTAUNICA = "cotaUnica";

    public String getCotaUnica() {
        return cotaUnica;
    }

    public void setCotaUnica(String cotaUnica) {
        String oldCotaUnica = this.cotaUnica;
        this.cotaUnica = cotaUnica;
        propertyChangeSupport.firePropertyChange(PROP_COTAUNICA, oldCotaUnica, cotaUnica);
    }
    private transient final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }

        private String vencCotaUnica;
    public static final String PROP_VENCCOTAUNICA = "vencCotaUnica";

    public String getVencCotaUnica() {
        return vencCotaUnica;
    }

    public void setVencCotaUnica(String vencCotaUnica) {
        String oldVencCotaUnica = this.vencCotaUnica;
        this.vencCotaUnica = vencCotaUnica;
        propertyChangeSupport.firePropertyChange(PROP_VENCCOTAUNICA, oldVencCotaUnica, vencCotaUnica);
    }

        private String faixaIpva;
    public static final String PROP_FAIXAIPVA = "faixaIpva";

    public String getFaixaIpva() {
        return faixaIpva;
    }

    public void setFaixaIpva(String faixaIpva) {
        String oldFaixaIpva = this.faixaIpva;
        this.faixaIpva = faixaIpva;
        propertyChangeSupport.firePropertyChange(PROP_FAIXAIPVA, oldFaixaIpva, faixaIpva);
    }

        private String parcelamentoCotas;
    public static final String PROP_PARCELAMENTOCOTAS = "parcelamentoCotas";

    public String getParcelamentoCotas() {
        return parcelamentoCotas;
    }

    public void setParcelamentoCotas(String parcelamentoCotas) {
        String oldParcelamentoCotas = this.parcelamentoCotas;
        this.parcelamentoCotas = parcelamentoCotas;
        propertyChangeSupport.firePropertyChange(PROP_PARCELAMENTOCOTAS, oldParcelamentoCotas, parcelamentoCotas);
    }

    private String[] vencCotas = new String[3];

    public String[] getVencCotas() {
        return vencCotas;
    }

    public void setVencCotas(String[] vencCotas) {
        this.vencCotas = vencCotas;
    }
    
}
