/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package compsi.crlv.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.math.BigInteger;

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

        private String modulo;
    public static final String PROP_MODULO = "modulo";

    public String getModulo() {
        return modulo;
    }

    public void setModulo(String modulo) {
        String oldModulo = this.modulo;
        this.modulo = modulo;
        propertyChangeSupport.firePropertyChange(PROP_MODULO, oldModulo, modulo);
    }

        private String result;
    public static final String PROP_RESULT = "result";

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        String oldResult = this.result;
        this.result = result;
        propertyChangeSupport.firePropertyChange(PROP_RESULT, oldResult, result);
    }

        private BigInteger n;
    public static final String PROP_N = "n";

    public BigInteger getN() {
        return n;
    }

    public void setN(BigInteger n) {
        BigInteger oldN = this.n;
        this.n = n;
        propertyChangeSupport.firePropertyChange(PROP_N, oldN, n);
    }

        private BigInteger e;
    public static final String PROP_E = "e";

    public BigInteger getE() {
        return e;
    }

    public void setE(BigInteger e) {
        BigInteger oldE = this.e;
        this.e = e;
        propertyChangeSupport.firePropertyChange(PROP_E, oldE, e);
    }

        private String puk;
    public static final String PROP_PUK = "puk";

    public String getPuk() {
        return puk;
    }

    public void setPuk(String puk) {
        String oldPuk = this.puk;
        this.puk = puk;
        propertyChangeSupport.firePropertyChange(PROP_PUK, oldPuk, puk);
    }

        private byte[] pukAscii;
    public static final String PROP_PUKASCII = "pukAscii";

    public byte[] getPukAscii() {
        return pukAscii;
    }

    public void setPukAscii(byte[] pukAscii) {
        byte[] oldPukAscii = this.pukAscii;
        this.pukAscii = pukAscii;
        propertyChangeSupport.firePropertyChange(PROP_PUKASCII, oldPukAscii, pukAscii);
    }

        private String desafioEnc;
    public static final String PROP_DESAFIOENC = "desafioEnc";

    public String getDesafioEnc() {
        return desafioEnc;
    }

    public void setDesafioEnc(String desafioEnc) {
        String oldDesafioEnc = this.desafioEnc;
        this.desafioEnc = desafioEnc;
        propertyChangeSupport.firePropertyChange(PROP_DESAFIOENC, oldDesafioEnc, desafioEnc);
    }

        private byte[] desafioByte;
    public static final String PROP_DESAFIOBYTE = "desafioByte";

    public byte[] getDesafioByte() {
        return desafioByte;
    }

    public void setDesafioByte(byte[] desafioByte) {
        byte[] oldDesafioByte = this.desafioByte;
        this.desafioByte = desafioByte;
        propertyChangeSupport.firePropertyChange(PROP_DESAFIOBYTE, oldDesafioByte, desafioByte);
    }

        private String iv;
    public static final String PROP_IV = "iv";

    public String getIv() {
        return iv;
    }

    public void setIv(String iv) {
        String oldIv = this.iv;
        this.iv = iv;
        propertyChangeSupport.firePropertyChange(PROP_IV, oldIv, iv);
    }

        private byte[] original;
    public static final String PROP_ORIGINAL = "original";

    public byte[] getOriginal() {
        return original;
    }

    public void setOriginal(byte[] original) {
        byte[] oldOriginal = this.original;
        this.original = original;
        propertyChangeSupport.firePropertyChange(PROP_ORIGINAL, oldOriginal, original);
    }

        private String originalS;
    public static final String PROP_ORIGINALS = "originalS";

    public String getOriginalS() {
        return originalS;
    }

    public void setOriginalS(String originalS) {
        String oldOriginalS = this.originalS;
        this.originalS = originalS;
        propertyChangeSupport.firePropertyChange(PROP_ORIGINALS, oldOriginalS, originalS);
    }

        private String hostInfo;
    public static final String PROP_HOSTINFO = "hostInfo";

    public String getHostInfo() {
        return hostInfo;
    }

    public void setHostInfo(String hostInfo) {
        String oldHostInfo = this.hostInfo;
        this.hostInfo = hostInfo;
        propertyChangeSupport.firePropertyChange(PROP_HOSTINFO, oldHostInfo, hostInfo);
    }

        private byte[] hostInfoByte;
    public static final String PROP_HOSTINFOBYTE = "hostInfoByte";

    public byte[] getHostInfoByte() {
        return hostInfoByte;
    }

    public void setHostInfoByte(byte[] hostInfoByte) {
        byte[] oldHostInfoByte = this.hostInfoByte;
        this.hostInfoByte = hostInfoByte;
        propertyChangeSupport.firePropertyChange(PROP_HOSTINFOBYTE, oldHostInfoByte, hostInfoByte);
    }

        private byte[] destino;
    public static final String PROP_DESTINO = "destino";

    public byte[] getDestino() {
        return destino;
    }

    public void setDestino(byte[] destino) {
        byte[] oldDestino = this.destino;
        this.destino = destino;
        propertyChangeSupport.firePropertyChange(PROP_DESTINO, oldDestino, destino);
    }

        private String destinoS;
    public static final String PROP_DESTINOS = "destinoS";

    public String getDestinoS() {
        return destinoS;
    }

    public void setDestinoS(String destinoS) {
        String oldDestinoS = this.destinoS;
        this.destinoS = destinoS;
        propertyChangeSupport.firePropertyChange(PROP_DESTINOS, oldDestinoS, destinoS);
    }

}
