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
public class CRLV {
    
    private Integer via;
    public static final String PROP_VIA = "via";

    public Integer getVia() {
        return via;
    }

    public void setVia(Integer via) {
        Integer oldVia = this.via;
        this.via = via;
        propertyChangeSupport.firePropertyChange(PROP_VIA, oldVia, via);
    }
    private transient final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }

        private String codigoRenavam;
    public static final String PROP_CODIGORENAVAM = "codigoRenavam";

    public String getCodigoRenavam() {
        return codigoRenavam;
    }

    public void setCodigoRenavam(String codigoRenavam) {
        String oldCodigoRenavam = this.codigoRenavam;
        this.codigoRenavam = codigoRenavam;
        propertyChangeSupport.firePropertyChange(PROP_CODIGORENAVAM, oldCodigoRenavam, codigoRenavam);
    }

        private String rntrc;
    public static final String PROP_RNTRC = "rntrc";

    public String getRntrc() {
        return rntrc;
    }

    public void setRntrc(String rntrc) {
        String oldRntrc = this.rntrc;
        this.rntrc = rntrc;
        propertyChangeSupport.firePropertyChange(PROP_RNTRC, oldRntrc, rntrc);
    }

        private String exercicio;
    public static final String PROP_EXERCICIO = "exercicio";

    public String getExercicio() {
        return exercicio;
    }

    public void setExercicio(String exercicio) {
        String oldExercicio = this.exercicio;
        this.exercicio = exercicio;
        propertyChangeSupport.firePropertyChange(PROP_EXERCICIO, oldExercicio, exercicio);
    }

        private String nome;
    public static final String PROP_NOME = "nome";

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        String oldNome = this.nome;
        this.nome = nome;
        propertyChangeSupport.firePropertyChange(PROP_NOME, oldNome, nome);
    }

        private String cpfCnpj;
    public static final String PROP_CPFCNPJ = "cpfCnpj";

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public void setCpfCnpj(String cpfCnpj) {
        String oldCpfCnpj = this.cpfCnpj;
        this.cpfCnpj = cpfCnpj;
        propertyChangeSupport.firePropertyChange(PROP_CPFCNPJ, oldCpfCnpj, cpfCnpj);
    }

        private String placa;
    public static final String PROP_PLACA = "placa";

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        String oldPlaca = this.placa;
        this.placa = placa;
        propertyChangeSupport.firePropertyChange(PROP_PLACA, oldPlaca, placa);
    }

        private String placaAnterior;
    public static final String PROP_PLACAANTERIOR = "placaAnterior";

    public String getPlacaAnterior() {
        return placaAnterior;
    }

    public void setPlacaAnterior(String placaAnterior) {
        String oldPlacaAnterior = this.placaAnterior;
        this.placaAnterior = placaAnterior;
        propertyChangeSupport.firePropertyChange(PROP_PLACAANTERIOR, oldPlacaAnterior, placaAnterior);
    }

        private String chassi;
    public static final String PROP_CHASSI = "chassi";

    public String getChassi() {
        return chassi;
    }

    public void setChassi(String chassi) {
        String oldChassi = this.chassi;
        this.chassi = chassi;
        propertyChangeSupport.firePropertyChange(PROP_CHASSI, oldChassi, chassi);
    }

    
}
