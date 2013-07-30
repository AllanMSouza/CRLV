/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package compsi.crlv.controller;

import compsi.crlv.model.SmartCard;
import compsi.crlv.view.MainWondow;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.security.SecureRandom;
import java.security.Security;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.RSAPublicKeySpec;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import javax.smartcardio.CardException;
import javax.swing.JOptionPane;
import pkcs11_lea.constants.Constants;
import pkcs11_lea.util.Hex;

/**
 *
 * @author allan
 */
public class ControllerSmartCard implements ActionListener {

    private SmartCard sc;
    private MainWondow mw;
    private String result;

    public ControllerSmartCard(MainWondow m) {
        sc = new SmartCard();    
        mw = m;
        
        mw.getMiVersao().addActionListener(this);
        mw.getMiInicializarCartao().addActionListener(this);
    }    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        String op = ae.getActionCommand();
        
        switch(op){
            case "Inicializar Cartão":
                    try {
                        result = inicializaCartao();
                        ShowError("Inicializar Cartão", result);
                    } catch (CardException ex) {
                        Logger.getLogger(ControllerSmartCard.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(ControllerSmartCard.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(ControllerSmartCard.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (NoSuchPaddingException ex) {
                        Logger.getLogger(ControllerSmartCard.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (NoSuchAlgorithmException ex) {
                        Logger.getLogger(ControllerSmartCard.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (InvalidKeyException ex) {
                        Logger.getLogger(ControllerSmartCard.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (InvalidKeySpecException ex) {
                        Logger.getLogger(ControllerSmartCard.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IllegalBlockSizeException ex) {
                        Logger.getLogger(ControllerSmartCard.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (BadPaddingException ex) {
                        Logger.getLogger(ControllerSmartCard.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (InvalidAlgorithmParameterException ex) {
                        Logger.getLogger(ControllerSmartCard.class.getName()).log(Level.SEVERE, null, ex);
                    }
                break;
                
            case "Versão":
                    try {
                        result = getVersion();
                        JOptionPane.showMessageDialog(null, "Versão: "+result);
                    } catch (CardException ex) {
                        Logger.getLogger(ControllerSmartCard.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(ControllerSmartCard.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(ControllerSmartCard.class.getName()).log(Level.SEVERE, null, ex);
                    }
        }
    }
    
    private String getVersion() throws 
            CardException, 
            FileNotFoundException, 
            IOException {
        PCSCManager.LOGAR("Obter a versão do Applet");
        sc.setResponse(PCSCManager.sendAPDU("8007000000"));
        sc.setResultado(Hex.printBytesHexa(sc.getResponse()));
        return sc.getResultado().substring(0, sc.getResultado().length() - 4 );        
    }
    
    private String inicializaCartao() throws CardException,
            FileNotFoundException,
            IOException,
            NoSuchPaddingException,
            NoSuchAlgorithmException,
            InvalidKeyException,
            InvalidKeySpecException,
            IllegalBlockSizeException,
            BadPaddingException,
            InvalidAlgorithmParameterException {

        PCSCManager.LOGAR("Inicializa_Cartao");

        sc.setPuk("");
        while (sc.getPuk().length() != 8) {
            sc.setPuk(JOptionPane.showInputDialog("Digite o PUK com oito caracteres"));
            if (sc.getPuk() == null) {
                break;
            }
            if (sc.getPuk().length() != 8) {
                sc.setPuk(JOptionPane.showInputDialog("Digite o PUK com oito caracteres"));
                sc.setPuk(null);
            }
        }

        if (sc.getPuk() == null) {
            return "0C00";
        }

        sc.setPukAscii(sc.getPuk().getBytes("US-ASCII"));
        Cursor hourglassCursor = new Cursor(Cursor.WAIT_CURSOR);
        mw.setCursor(hourglassCursor);

        // GET AUTH PUBLIC KEY

        sc.setResponse(PCSCManager.sendAPDU("8056000000"));
        sc.setResultado(Hex.printBytesHexa(sc.getResponse()));
        sc.setResult(sc.getResultado().substring(sc.getResultado().length() - 4, sc.getResultado().length() - 2));

        if ((sc.getResult().equals(Constants.RESPONSE_APDU_OK))) {
            PCSCManager.LOGAR("ENVIAR CHAVE AES PARTE 1");
            sc.setModulo(sc.getResultado().substring(0, sc.getResultado().length() - 4));

            sc.setN(new BigInteger(sc.getModulo(), 16));
            sc.setE(new BigInteger("010001", 16));

            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            RSAPublicKeySpec pubKeySpec = new RSAPublicKeySpec(sc.getN(), sc.getE());
            RSAPublicKey publicKey = (RSAPublicKey) keyFactory.generatePublic(pubKeySpec);


            byte[] key_AES = new byte[16];
            SecureRandom r = new SecureRandom();
            r.nextBytes(key_AES);

            Provider cp = Security.getProvider("SunJCE");
            Cipher c = Cipher.getInstance("RSA/ECB/OAEPwithSHA1andMGF1Padding", cp);
            c.init(Cipher.ENCRYPT_MODE, publicKey);
            byte[] enc = c.doFinal(key_AES);
            String enc_s = Hex.printBytesHexa(enc);
            String parte1 = enc_s.substring(0, 478);
            int len = parte1.length();
            String parte2 = enc_s.substring(478, 512);
            len = parte2.length();
            
            sc.setResponse(PCSCManager.sendAPDU("80570000EF" + parte1));
            sc.setResultado(Hex.printBytesHexa(sc.getResponse()));
            sc.setResult(sc.getResultado().substring(sc.getResultado().length() - 4, sc.getResultado().length() - 2));
            if ((sc.getResult().equals(Constants.RESPONSE_APDU_OK))) {
                PCSCManager.LOGAR("ENVIAR CHAVE AES PARTE 2");
                sc.setResponse(PCSCManager.sendAPDU("8057800011" + parte2));
                sc.setResultado(Hex.printBytesHexa(sc.getResponse()));
                sc.setResult(sc.getResultado().substring(sc.getResultado().length() - 4, sc.getResultado().length() - 2));
                if ((sc.getResult().equals(Constants.RESPONSE_APDU_OK))) {
                    PCSCManager.LOGAR("PEGAR DESAFIO E ENVIAR PUK");

                    sc.setDesafioEnc(sc.getResultado().substring(0, sc.getResultado().length() - 4));
                    sc.setDesafioByte(Hex.toByteHexArray(sc.getDesafioEnc()));
                    
                    String iv = "0000000000000000";
                    javax.crypto.spec.IvParameterSpec ivspec = new javax.crypto.spec.IvParameterSpec(iv.getBytes());
                    SecretKeySpec secretKeySpec = new SecretKeySpec(key_AES, "AES");

                    // Instantiate the cipher
                    Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
                    cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, ivspec);
                    
                    sc.setOriginal(cipher.doFinal(sc.getDesafioByte()));
                    sc.setOriginalS(Hex.printBytesHexa(sc.getOriginal()));

                    sc.setHostInfo(sc.getOriginalS() + Hex.printBytesHexa(sc.getPukAscii()) + "0000000000000000");
                    sc.setHostInfoByte(Hex.toByteHexArray(sc.getHostInfo()));

                    cipher = Cipher.getInstance("AES/CBC/NoPadding");
                    cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivspec);
                    sc.setDestino(cipher.doFinal(sc.getHostInfoByte()));
                    sc.setDestinoS(Hex.printBytesHexa(sc.getDestino()));
                    
                    sc.setResponse(PCSCManager.sendAPDU("8057810020" + sc.getDestinoS()));
                    sc.setResultado(Hex.printBytesHexa(sc.getResponse()));

                }
            }
        }

        Cursor normalCursor = new Cursor(Cursor.DEFAULT_CURSOR);
        mw.setCursor(normalCursor);

        return sc.getResultado().substring(sc.getResultado().length() - 4, sc.getResultado().length());
    } // FIM INICIALIZACAO
    
    void ShowError(String rotina, String rv) {
        JOptionPane.showMessageDialog(null, "Função: " + rotina);

        Integer rv1 = Integer.parseInt(rv.substring(0, 2), 16);
        Integer rv2 = Integer.parseInt(rv.substring(2, 4), 16);

        switch (rv1) {

            case 0x000001:
                JOptionPane.showMessageDialog(null, "ERRO DE CONEXAO\n");
                break;
            case 0x000002:
                JOptionPane.showMessageDialog(null, "ERRO AO SELECIONAR O APPLET LSIDOC\n");
                break;
            case 0x000003:
                JOptionPane.showMessageDialog(null, "ERRO NA GERACAO DE NUMEROS RANDOMICOS\n");
                break;
            case 0x000004:
                JOptionPane.showMessageDialog(null, "TAMANHO DIFERENTE DE 258 BYTES\n");
                break;
            case 0x000005:
                JOptionPane.showMessageDialog(null, "ERRO DO BLOCO OAEP\n");
                break;
            case 0x000006:
                JOptionPane.showMessageDialog(null, "TAMANHO DIFERENTE DE 18 BYTES\n");
                break;
            case 0x000007:
                JOptionPane.showMessageDialog(null, "ERRO AO DECRIPTAR AES128\n");
                break;
            case 0x000008:
                JOptionPane.showMessageDialog(null, "ERRO AO ENCRIPTAR AES128\n");
                break;
            case 0x000009:
                JOptionPane.showMessageDialog(null, "ERRO NOME DO ARQUIVO INEXISTENTE\n");
                break;
            case 0x00000A:
                JOptionPane.showMessageDialog(null, "ERRO SEM ESPACO DE MEMORIA\n");
                break;
            case 0x00000B:
                JOptionPane.showMessageDialog(null, "ERRO DE GRAVACAO DO ARQUIVO\n");
                break;
            case 0x00000C:
                JOptionPane.showMessageDialog(null, "OPERAÇÃO CANCELADA !!!! \n");
                break;
            case 0x00000D:
                JOptionPane.showMessageDialog(null, "\n");
                break;
            case 0x00000E:
                JOptionPane.showMessageDialog(null, "\n");
                break;
            case 0x00000F:
                JOptionPane.showMessageDialog(null, "\n");
                break;
            case 0x000010:
                JOptionPane.showMessageDialog(null, "\n");
                break;
            case 0x000011:
                JOptionPane.showMessageDialog(null, "\n");
                break;
            case 0x000012:
                JOptionPane.showMessageDialog(null, "\n");
                break;
            case 0x000013:
                JOptionPane.showMessageDialog(null, "\n");
                break;
            case 0x000014:
                JOptionPane.showMessageDialog(null, "\n");
                break;


            case 0x000090:
                JOptionPane.showMessageDialog(null, "OPERAÇÃO REALIZADA COM SUCESSO !!!! OK\n");
                break;
            case 0x000067:
                JOptionPane.showMessageDialog(null, "TAMANHO INVALIDO\n");
                break;
            case 0x00006D:
                JOptionPane.showMessageDialog(null, "CODIGO DE INSTRUCAO INVALIDO OU NAO SUPORTADO\n");
                break;
            case 0x00006E:
                JOptionPane.showMessageDialog(null, "CLASSE NAO SUPORTADA\n");
                break;
            case 0x00006F:
                JOptionPane.showMessageDialog(null, "DIAGNOSTICO NAO PRECISO\n");
                break;
            case 0x000064:
                JOptionPane.showMessageDialog(null, "TROCAR PUK COM PUK\n");
                break;

            case 0x00006A: {
                switch (rv2) {
                    case 0x000080:
                        JOptionPane.showMessageDialog(null, "PRESENCA DE DADOS INVALIDOS\n");
                        break;
                    case 0x000081:
                        JOptionPane.showMessageDialog(null, "FUNCAO NAO SUPORTADA, PARAMETROS P1/P2 INVALIDOS\n");
                        break;
                    case 0x000088:
                        JOptionPane.showMessageDialog(null, "DADOS DE REFERENCIA NAO ENCONTRADOS\n");
                        break;
                    case 0x000086:
                        JOptionPane.showMessageDialog(null, "PARAMETROS P1/P2 INVALIDOS\n");
                        break;
                    case 0x000082:
                        JOptionPane.showMessageDialog(null, "NÃO HÁ DOCUMENTO ARMAZENADO NESTE CONTAINER\n");
                        break;
                }
                break;
            }


            case 0x000069: {
                switch (rv2) {
                    case 0x000082:
                        JOptionPane.showMessageDialog(null, "ESTADO DE SEGURANCA NAO SATISFEITO\n");
                        break;
                    case 0x000083:
                        JOptionPane.showMessageDialog(null, "PIN OU PUK BLOQUEADO OU INVALIDO\n");
                        break;
                    case 0x000085:
                        JOptionPane.showMessageDialog(null, "KID INCORRETO\n");
                        break;
                }
                break;
            }

            case 0x000063: {
                switch (rv2) {
                    case 0x000000C0:
                        JOptionPane.showMessageDialog(null, "PIN OU PUK BLOQUEADOS\n");
                        break;
                    case 0x000000C1:
                        JOptionPane.showMessageDialog(null, "PIN OU PUK INCORRETO, 01 TENTATIVA RESTANTE\n");
                        break;
                    case 0x000000C2:
                        JOptionPane.showMessageDialog(null, "PIN OU PUK INCORRETO, 02 TENTATIVAS RESTANTES\n");
                        break;
                    case 0x000000C3:
                        JOptionPane.showMessageDialog(null, "PIN OU PUK INCORRETO, 03 TENTATIVAS RESTANTES\n");
                        break;
                    case 0x000000C4:
                        JOptionPane.showMessageDialog(null, "PIN OU PUK INCORRETO, 04 TENTATIVAS RESTANTES\n");
                        break;
                    case 0x000000C5:
                        JOptionPane.showMessageDialog(null, "PIN OU PUK INCORRETO, 05 TENTATIVAS RESTANTES\n");
                        break;
                    case 0x000000C6:
                        JOptionPane.showMessageDialog(null, "PIN OU PUK INCORRETO, 06 TENTATIVAS RESTANTES\n");
                        break;
                    case 0x000000C7:
                        JOptionPane.showMessageDialog(null, "PIN OU PUK INCORRETO, 07 TENTATIVAS RESTANTES\n");
                        break;
                    case 0x000000C8:
                        JOptionPane.showMessageDialog(null, "PIN OU PUK INCORRETO, 08 TENTATIVAS RESTANTES\n");
                        break;
                }
                break;
            }
            default:
                JOptionPane.showMessageDialog(null, "INDEFINIDO!!!\n");
                break;
        }

    }

    
    
    
}
