/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package compsi.crlv.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.RSAPublicKeySpec;

/**
 *
 * @author allan
 */
public class SmartCard {

    public SmartCard() throws NoSuchAlgorithmException {
        this.keyFactory = KeyFactory.getInstance("RSA");
        this.keyAES = new byte[16];
        this.r = new SecureRandom();
    }
    
    
    
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

        private String newPin;
    public static final String PROP_NEWPIN = "newPin";

    public String getNewPin() {
        return newPin;
    }

    public void setNewPin(String newPin) {
        String oldNewPin = this.newPin;
        this.newPin = newPin;
        propertyChangeSupport.firePropertyChange(PROP_NEWPIN, oldNewPin, newPin);
    }

        private byte[] newPinAscii;
    public static final String PROP_NEWPINASCII = "newPinAscii";

    public byte[] getNewPinAscii() {
        return newPinAscii;
    }

    public void setNewPinAscii(byte[] newPinAscii) {
        byte[] oldNewPinAscii = this.newPinAscii;
        this.newPinAscii = newPinAscii;
        propertyChangeSupport.firePropertyChange(PROP_NEWPINASCII, oldNewPinAscii, newPinAscii);
    }

        private KeyFactory keyFactory ;
    public static final String PROP_KEYFACTORY = "keyFactory";

    public KeyFactory getKeyFactory() {
        return keyFactory;
    }

    public void setKeyFactory(KeyFactory keyFactory) {
        KeyFactory oldKeyFactory = this.keyFactory;
        this.keyFactory = keyFactory;
        propertyChangeSupport.firePropertyChange(PROP_KEYFACTORY, oldKeyFactory, keyFactory);
    }

        private RSAPublicKeySpec pubKeySpec;
    public static final String PROP_PUBKEYSPEC = "pubKeySpec";

    public RSAPublicKeySpec getPubKeySpec() {
        return pubKeySpec;
    }

    public void setPubKeySpec(RSAPublicKeySpec pubKeySpec) {
        RSAPublicKeySpec oldPubKeySpec = this.pubKeySpec;
        this.pubKeySpec = pubKeySpec;
        propertyChangeSupport.firePropertyChange(PROP_PUBKEYSPEC, oldPubKeySpec, pubKeySpec);
    }

        private RSAPublicKey publicKey;
    public static final String PROP_PUBLICKEY = "publicKey";

    public RSAPublicKey getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(RSAPublicKey publicKey) {
        RSAPublicKey oldPublicKey = this.publicKey;
        this.publicKey = publicKey;
        propertyChangeSupport.firePropertyChange(PROP_PUBLICKEY, oldPublicKey, publicKey);
    }

        private byte[] keyAES;
    public static final String PROP_KEYAES = "keyAES";

    public byte[] getKeyAES() {
        return keyAES;
    }

    public void setKeyAES(byte[] keyAES) {
        byte[] oldKeyAES = this.keyAES;
        this.keyAES = keyAES;
        propertyChangeSupport.firePropertyChange(PROP_KEYAES, oldKeyAES, keyAES);
    }

        private SecureRandom r;
    public static final String PROP_R = "r";

    public SecureRandom getR() {
        return r;
    }

    public void setR(SecureRandom r) {
        SecureRandom oldR = this.r;
        this.r = r;
        propertyChangeSupport.firePropertyChange(PROP_R, oldR, r);
    }
    
        private byte[] enc;
    public static final String PROP_ENC = "enc";

    public byte[] getEnc() {
        return enc;
    }

    public void setEnc(byte[] enc) {
        byte[] oldEnc = this.enc;
        this.enc = enc;
        propertyChangeSupport.firePropertyChange(PROP_ENC, oldEnc, enc);
    }

        private String encS;
    public static final String PROP_ENCS = "encS";

    public String getEncS() {
        return encS;
    }

    public void setEncS(String encS) {
        String oldEncS = this.encS;
        this.encS = encS;
        propertyChangeSupport.firePropertyChange(PROP_ENCS, oldEncS, encS);
    }

        private String parte1;
    public static final String PROP_PARTE1 = "parte1";

    public String getParte1() {
        return parte1;
    }

    public void setParte1(String parte1) {
        String oldParte1 = this.parte1;
        this.parte1 = parte1;
        propertyChangeSupport.firePropertyChange(PROP_PARTE1, oldParte1, parte1);
    }

        private String parte2;
    public static final String PROP_PARTE2 = "parte2";

    public String getParte2() {
        return parte2;
    }

    public void setParte2(String parte2) {
        String oldParte2 = this.parte2;
        this.parte2 = parte2;
        propertyChangeSupport.firePropertyChange(PROP_PARTE2, oldParte2, parte2);
    }

        private Integer len;
    public static final String PROP_LEN = "len";

    public Integer getLen() {
        return len;
    }

    public void setLen(Integer len) {
        Integer oldLen = this.len;
        this.len = len;
        propertyChangeSupport.firePropertyChange(PROP_LEN, oldLen, len);
    }
    
        private String pin;
    public static final String PROP_PIN = "pin";

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        String oldPin = this.pin;
        this.pin = pin;
        propertyChangeSupport.firePropertyChange(PROP_PIN, oldPin, pin);
    }
    private byte[] pinAscii;
    public static final String PROP_PINASCII = "pinAscii";

    public byte[] getPinAscii() {
        return pinAscii;
    }

    public void setPinAscii(byte[] pinAscii) {
        byte[] oldPinAscii = this.pinAscii;
        this.pinAscii = pinAscii;
        propertyChangeSupport.firePropertyChange(PROP_PINASCII, oldPinAscii, pinAscii);
    }
    
        private String newPuk;
    public static final String PROP_NEWPUK = "newPuk";

    public String getNewPuk() {
        return newPuk;
    }

    public void setNewPuk(String newPuk) {
        String oldNewPuk = this.newPuk;
        this.newPuk = newPuk;
        propertyChangeSupport.firePropertyChange(PROP_NEWPUK, oldNewPuk, newPuk);
    }

        private byte[] newPukAscii;
    public static final String PROP_NEWPUKASCII = "newPukAscii";

    public byte[] getNewPukAscii() {
        return newPukAscii;
    }

    public void setNewPukAscii(byte[] newPukAscii) {
        byte[] oldNewPukAscii = this.newPukAscii;
        this.newPukAscii = newPukAscii;
        propertyChangeSupport.firePropertyChange(PROP_NEWPUKASCII, oldNewPukAscii, newPukAscii);
    }


}
