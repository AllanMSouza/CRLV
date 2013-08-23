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
public class ModelCRLV {
    
        private Integer idCrlv;
    public static final String PROP_IDCRLV = "idCrlv";

    public Integer getIdCrlv() {
        return idCrlv;
    }

    public void setIdCrlv(Integer idCrlv) {
        Integer oldIdCrlv = this.idCrlv;
        this.idCrlv = idCrlv;
        propertyChangeSupport.firePropertyChange(PROP_IDCRLV, oldIdCrlv, idCrlv);
    }

    
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

        private String codRenavam;
    public static final String PROP_CODRENAVAM = "codRenavam";

    public String getCodRenavam() {
        return codRenavam;
    }

    public void setCodRenavam(String codRenavam) {
        String oldCodRenavam = this.codRenavam;
        this.codRenavam = codRenavam;
        propertyChangeSupport.firePropertyChange(PROP_CODRENAVAM, oldCodRenavam, codRenavam);
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

        private String ufPlaca;
    public static final String PROP_UFPLACA = "ufPlaca";

    public String getUfPlaca() {
        return ufPlaca;
    }

    public void setUfPlaca(String ufPlaca) {
        String oldUfPlaca = this.ufPlaca;
        this.ufPlaca = ufPlaca;
        propertyChangeSupport.firePropertyChange(PROP_UFPLACA, oldUfPlaca, ufPlaca);
    }

        private String placaAnt;
    public static final String PROP_PLACAANT = "placaAnt";

    public String getPlacaAnt() {
        return placaAnt;
    }

    public void setPlacaAnt(String placaAnt) {
        String oldPlacaAnt = this.placaAnt;
        this.placaAnt = placaAnt;
        propertyChangeSupport.firePropertyChange(PROP_PLACAANT, oldPlacaAnt, placaAnt);
    }

        private String ufPlacaAnt;
    public static final String PROP_UFPLACAANT = "ufPlacaAnt";

    public String getUfPlacaAnt() {
        return ufPlacaAnt;
    }

    public void setUfPlacaAnt(String ufPlacaAnt) {
        String oldUfPlacaAnt = this.ufPlacaAnt;
        this.ufPlacaAnt = ufPlacaAnt;
        propertyChangeSupport.firePropertyChange(PROP_UFPLACAANT, oldUfPlacaAnt, ufPlacaAnt);
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

        private String especieTipo;
    public static final String PROP_ESPECIETIPO = "especieTipo";

    public String getEspecieTipo() {
        return especieTipo;
    }

    public void setEspecieTipo(String especieTipo) {
        String oldEspecieTipo = this.especieTipo;
        this.especieTipo = especieTipo;
        propertyChangeSupport.firePropertyChange(PROP_ESPECIETIPO, oldEspecieTipo, especieTipo);
    }

        private String combustivel;
    public static final String PROP_COMBUSTIVEL = "combustivel";

    public String getCombustivel() {
        return combustivel;
    }

    public void setCombustivel(String combustivel) {
        String oldCombustivel = this.combustivel;
        this.combustivel = combustivel;
        propertyChangeSupport.firePropertyChange(PROP_COMBUSTIVEL, oldCombustivel, combustivel);
    }

        private String marca;
    public static final String PROP_MARCA = "marca";

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        String oldMarca = this.marca;
        this.marca = marca;
        propertyChangeSupport.firePropertyChange(PROP_MARCA, oldMarca, marca);
    }

        private String modelo;
    public static final String PROP_MODELO = "modelo";

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        String oldModelo = this.modelo;
        this.modelo = modelo;
        propertyChangeSupport.firePropertyChange(PROP_MODELO, oldModelo, modelo);
    }

        private Integer anoFab;
    public static final String PROP_ANOFAB = "anoFab";

    public Integer getAnoFab() {
        return anoFab;
    }

    public void setAnoFab(Integer anoFab) {
        Integer oldAnoFab = this.anoFab;
        this.anoFab = anoFab;
        propertyChangeSupport.firePropertyChange(PROP_ANOFAB, oldAnoFab, anoFab);
    }

        private Integer anoMod;
    public static final String PROP_ANOMOD = "anoMod";

    public Integer getAnoMod() {
        return anoMod;
    }

    public void setAnoMod(Integer anoMod) {
        Integer oldAnoMod = this.anoMod;
        this.anoMod = anoMod;
        propertyChangeSupport.firePropertyChange(PROP_ANOMOD, oldAnoMod, anoMod);
    }

        private String cap;
    public static final String PROP_CAP = "cap";

    public String getCap() {
        return cap;
    }

    public void setCap(String cap) {
        String oldCap = this.cap;
        this.cap = cap;
        propertyChangeSupport.firePropertyChange(PROP_CAP, oldCap, cap);
    }

        private String pot;
    public static final String PROP_POT = "pot";

    public String getPot() {
        return pot;
    }

    public void setPot(String pot) {
        String oldPot = this.pot;
        this.pot = pot;
        propertyChangeSupport.firePropertyChange(PROP_POT, oldPot, pot);
    }

        private String cil;
    public static final String PROP_CIL = "cil";

    public String getCil() {
        return cil;
    }

    public void setCil(String cil) {
        String oldCil = this.cil;
        this.cil = cil;
        propertyChangeSupport.firePropertyChange(PROP_CIL, oldCil, cil);
    }

        private String categoria;
    public static final String PROP_CATEGORIA = "categoria";

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        String oldCategoria = this.categoria;
        this.categoria = categoria;
        propertyChangeSupport.firePropertyChange(PROP_CATEGORIA, oldCategoria, categoria);
    }

        private String cor;
    public static final String PROP_COR = "cor";

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        String oldCor = this.cor;
        this.cor = cor;
        propertyChangeSupport.firePropertyChange(PROP_COR, oldCor, cor);
    }
    
        private ModelIPVA ipva;
    public static final String PROP_IPVA = "ipva";

    public ModelIPVA getIpva() {
        return ipva;
    }

    public void setIpva(ModelIPVA ipva) {
        ModelIPVA oldIpva = this.ipva;
        this.ipva = ipva;
        propertyChangeSupport.firePropertyChange(PROP_IPVA, oldIpva, ipva);
    }


        private String premioTarifario;
    public static final String PROP_PREMIOTARIFARIO = "premioTarifario";

    public String getPremioTarifario() {
        return premioTarifario;
    }

    public void setPremioTarifario(String premioTarifario) {
        String oldPremioTarifario = this.premioTarifario;
        this.premioTarifario = premioTarifario;
        propertyChangeSupport.firePropertyChange(PROP_PREMIOTARIFARIO, oldPremioTarifario, premioTarifario);
    }

        private String iof;
    public static final String PROP_IOF = "iof";

    public String getIof() {
        return iof;
    }

    public void setIof(String iof) {
        String oldIof = this.iof;
        this.iof = iof;
        propertyChangeSupport.firePropertyChange(PROP_IOF, oldIof, iof);
    }

        private String premioTotal;
    public static final String PROP_PREMIOTOTAL = "premioTotal";

    public String getPremioTotal() {
        return premioTotal;
    }

    public void setPremioTotal(String premioTotal) {
        String oldPremioTotal = this.premioTotal;
        this.premioTotal = premioTotal;
        propertyChangeSupport.firePropertyChange(PROP_PREMIOTOTAL, oldPremioTotal, premioTotal);
    }

        private String dataPag;
    public static final String PROP_DATAPAG = "dataPag";

    public String getDataPag() {
        return dataPag;
    }

    public void setDataPag(String dataPag) {
        String oldDataPag = this.dataPag;
        this.dataPag = dataPag;
        propertyChangeSupport.firePropertyChange(PROP_DATAPAG, oldDataPag, dataPag);
    }

        private String observacoes;
    public static final String PROP_OBSERVACOES = "observacoes";

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        String oldObservacoes = this.observacoes;
        this.observacoes = observacoes;
        propertyChangeSupport.firePropertyChange(PROP_OBSERVACOES, oldObservacoes, observacoes);
    }

        private String local;
    public static final String PROP_LOCAL = "local";

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        String oldLocal = this.local;
        this.local = local;
        propertyChangeSupport.firePropertyChange(PROP_LOCAL, oldLocal, local);
    }

        private String data;
    public static final String PROP_DATA = "data";

    public String getData() {
        return data;
    }

    public void setData(String data) {
        String oldData = this.data;
        this.data = data;
        propertyChangeSupport.firePropertyChange(PROP_DATA, oldData, data);
    }

    
}
