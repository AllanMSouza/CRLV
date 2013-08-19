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

        private String vencPrimeiraCota;
    public static final String PROP_VENCPRIMEIRACOTA = "vencPrimeiraCota";

    public String getVencPrimeiraCota() {
        return vencPrimeiraCota;
    }

    public void setVencPrimeiraCota(String vencPrimeiraCota) {
        String oldVencPrimeiraCota = this.vencPrimeiraCota;
        this.vencPrimeiraCota = vencPrimeiraCota;
        propertyChangeSupport.firePropertyChange(PROP_VENCPRIMEIRACOTA, oldVencPrimeiraCota, vencPrimeiraCota);
    }

        private String vencSegundaCota;
    public static final String PROP_VENCSEGUNDACOTA = "vencSegundaCota";

    public String getVencSegundaCota() {
        return vencSegundaCota;
    }

    public void setVencSegundaCota(String vencSegundaCota) {
        String oldVencSegundaCota = this.vencSegundaCota;
        this.vencSegundaCota = vencSegundaCota;
        propertyChangeSupport.firePropertyChange(PROP_VENCSEGUNDACOTA, oldVencSegundaCota, vencSegundaCota);
    }

        private String vencTerceiraCota;
    public static final String PROP_VENCTERCEIRACOTA = "vencTerceiraCota";

    public String getVencTerceiraCota() {
        return vencTerceiraCota;
    }

    public void setVencTerceiraCota(String vencTerceiraCota) {
        String oldVencTerceiraCota = this.vencTerceiraCota;
        this.vencTerceiraCota = vencTerceiraCota;
        propertyChangeSupport.firePropertyChange(PROP_VENCTERCEIRACOTA, oldVencTerceiraCota, vencTerceiraCota);
    }

    
}
