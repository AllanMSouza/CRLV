/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package compsi.crlv.controller;

import compsi.crlv.model.SmartCard;
import compsi.crlv.view.JIFCrlv;
import compsi.crlv.view.JIFLeitora;
import compsi.crlv.view.MainWondow;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
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
import javax.swing.JFileChooser;
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
    private JIFLeitora jifLeitora;

    public ControllerSmartCard(MainWondow m, JIFLeitora lei) throws NoSuchAlgorithmException {
        sc = new SmartCard();    
        mw = m;
        jifLeitora = lei;
        
        mw.getMiVersao().addActionListener(this);
        mw.getMiInicializarCartao().addActionListener(this);
        mw.getMiDesbloquearPIN().addActionListener(this);
        mw.getMiTrocarPIN().addActionListener(this);
        mw.getMiTrocarPUK().addActionListener(this);
        mw.getMiVerificarDocumento().addActionListener(this);
        mw.getMiDeletarDocumento().addActionListener(this);
        mw.getMiGravarDocumento().addActionListener(this);
        mw.getMiRecuperarDocumento().addActionListener(this);
        mw.getMiFormularioCrlv().addActionListener(this);
    }    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        try {
            String op = ae.getActionCommand();
            //System.out.println(op);
            switch(op){
                case "Conectar":
                    jifLeitora.setVisible(true);
                    break;
                    
                case "Formulário CRLV":
                    JIFCrlv crlv = new JIFCrlv();
                    mw.getDesktop().add(crlv);
                    crlv.setVisible(true);
                    break;
                
                case "Inicializar Cartão":
                    result = inicializaCartao();
                    ShowError("Inicializar Cartão", result);
                    break;
                                       
                case "Versão":
                    result = getVersion();
                    JOptionPane.showMessageDialog(mw.getDesktop(), "Versão: "+result);
                    break;
                    
                case "Desbloquear PIN":
                    result = trocarPinPuk();
                    ShowError("Trocar PIN com PUK", result);
                    break;
                    
                case "Trocar PIN":
                    result = trocarPinPin();
                    ShowError("Trocar PIN com PIN", result);
                    break;
                    
                case "Trocar PUK":
                    result = trocarPukPuk();
                    ShowError("Trocar PUK com PUK", result);
                    break;
                    
                case "Verificar Documento":
                    result = autenticaPin();
                    if(result.equals("9000")){
                        result = verificaDocumento();
                        if(result.equals("01"))
                            JOptionPane.showMessageDialog(null, "Possui Documento armazenado neste Container");
                        
                        if(result.equals("00"))
                            JOptionPane.showMessageDialog(null, "Não Possui Documento armazenado neste Container");
                        
                        if(result.equals("0C00"))
                            ShowError("Verificar Documento", result);
                    }
                    else
                        ShowError("Autentica PIN", result);
                    
                    break;
                    
                case "Gravar Documento":
                    result = autenticaPin();
                    if(result.equals("9000")){
                        result = importarDocumento();
                        ShowError("Gravar Documento", result);
                    }
                    else
                        ShowError("Autentica PIN", result);
                    break;
                    
                case "Recuperar Documento":
                    result = autenticaPin();
                    if(result.equals("9000")){
                        result = exportarDocumento();
                        ShowError("Recuperar Documento", result);
                    }
                    else
                        ShowError("Autentica PIN", result);
                    
                    break;
                    
                case "Deletar Documento":
                    result =  autenticaPin();
                    if(result.equals("9000")){
                        result = deletarDocumento();
                        if(result.equals("00"))
                            JOptionPane.showMessageDialog(null, "Não Possui documento armazenado neste container");
                        else
                            ShowError("Deletar Documento", result);                                    
                    }
                    else
                        ShowError("Autentica PIN", result);
                    break;                    
                    
                    
            }
                   
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
    
    private String inicializaCartao() throws UnsupportedEncodingException, CardException, FileNotFoundException, IOException, InvalidKeySpecException, NoSuchAlgorithmException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, NoSuchPaddingException, InvalidAlgorithmParameterException {
        PCSCManager.LOGAR("Inicializa Cartão");        
        requestPuk();        
        if (sc.getPuk() == null) {
            return "0C00";
        }
        sc.setPukAscii(sc.getPuk().getBytes("US-ASCII"));        
        Cursor hourglassCursor = new Cursor(Cursor.WAIT_CURSOR);
        mw.setCursor(hourglassCursor);
        // GET AUTH PUBLIC KEY
        sendKeyAESpt1("8056000000","80570000EF");
        sendKeyAESpt2("8057800011", "8057810020",  Hex.printBytesHexa(sc.getPukAscii()) + "0000000000000000");
        Cursor normalCursor = new Cursor(Cursor.DEFAULT_CURSOR);
        mw.setCursor(normalCursor);
        return sc.getResultado().substring(sc.getResultado().length() - 4, sc.getResultado().length());
    } // FIM INICIALIZACAO
    
    
    private String trocarPinPuk() throws CardException,
            FileNotFoundException,
            IOException,
            NoSuchPaddingException,
            NoSuchAlgorithmException,
            InvalidKeyException,
            InvalidKeySpecException,
            IllegalBlockSizeException,
            BadPaddingException,
            InvalidAlgorithmParameterException {
        
        PCSCManager.LOGAR("Trocar PIN com PUK");

        requestPuk();

        if (sc.getPuk() == null) {
            return "0C00";
        }        
        sc.setPukAscii(sc.getPuk().getBytes("US-ASCII"));
        
        requestNewPin();       

        if (sc.getNewPin() == null) {
            return "0C00";
        }
        
        sc.setNewPinAscii(sc.getNewPin().getBytes("US-ASCII"));
        // GET AUTH PUBLIC KEY
        sendKeyAESpt1("8056000000", "80170000EF");
        sendKeyAESpt2("8017800011", "8017810220", Hex.printBytesHexa(sc.getPukAscii()) + Hex.printBytesHexa(sc.getNewPinAscii()));
                
        return sc.getResultado().substring(sc.getResultado().length() - 4, sc.getResultado().length());
    } // FIM TROCA PIN COM PUK
    
    private void requestPuk(){        
        sc.setPuk("");
        while (sc.getPuk().length() != 8) {
            sc.setPuk(JOptionPane.showInputDialog("Digite o PUK com oito caracteres"));
            if (sc.getPuk() == null) {
                break;
            }
            if (sc.getPuk().length() != 8) {
                sc.setPuk(JOptionPane.showInputDialog("Digite o PUK com oito caracteres"));
                sc.setPuk("");
            }
        }        
    }
    
    private void requestNewPuk(){        
        sc.setNewPuk("");
        while (sc.getNewPuk().length() != 8) {
            sc.setNewPuk(JOptionPane.showInputDialog("Digite o NOVO PUK com oito caracteres"));
            if (sc.getNewPuk() == null) {
                break;
            }
            if (sc.getNewPuk().length() != 8) {
                sc.setNewPuk(JOptionPane.showInputDialog("Digite o NOVO PUK com oito caracteres"));
                sc.setNewPuk("");
            }
        }        
    }
    
    private void requestNewPin(){
        sc.setNewPin("");
        while (sc.getNewPin().length() != 8) {
            sc.setNewPin(JOptionPane.showInputDialog("Digite o NOVO PIN com oito caracteres"));
            if (sc.getNewPin() == null) {
                break;
            }
            if (sc.getNewPin().length() != 8) {
                JOptionPane.showMessageDialog(null, "Digite o NOVO PIN com oito caracteres!!!");
                sc.setNewPin("");
            }
        }
    }
    
    private void requestPin(){
        sc.setPin("");
        while (sc.getPin().length() != 8) {
            sc.setPin(JOptionPane.showInputDialog("Digite o PIN com oito caracteres"));
            if (sc.getPin() == null) {
                break;
            }
            if (sc.getPin().length() != 8) {
                JOptionPane.showMessageDialog(null, "Digite o PIN com oito caracteres!!!");
                sc.setPin("");
            }
        }
    }
    
    private void sendKeyAESpt1(String apdu1, String apdu2) throws CardException, FileNotFoundException, IOException, InvalidKeySpecException, NoSuchAlgorithmException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, NoSuchPaddingException{
        
        sc.setResponse(PCSCManager.sendAPDU(apdu1));
        sc.setResultado(Hex.printBytesHexa(sc.getResponse()));
        sc.setResult(sc.getResultado().substring(sc.getResultado().length() - 4, sc.getResultado().length() - 2));

        if ((sc.getResult().equals(Constants.RESPONSE_APDU_OK))) {
            PCSCManager.LOGAR("ENVIAR CHAVE AES PARTE 1");
            sc.setModulo(sc.getResultado().substring(0, sc.getResultado().length() - 4));

            sc.setN(new BigInteger(sc.getModulo(), 16));
            sc.setE(new BigInteger("010001", 16));
            
            sc.setPubKeySpec(new RSAPublicKeySpec(sc.getN(), sc.getE()));
            sc.setPublicKey((RSAPublicKey) sc.getKeyFactory().generatePublic(sc.getPubKeySpec()));

            sc.getR().nextBytes(sc.getKeyAES());           

            Provider cp = Security.getProvider("SunJCE");
            Cipher c = Cipher.getInstance("RSA/ECB/OAEPwithSHA1andMGF1Padding", cp);
            c.init(Cipher.ENCRYPT_MODE, sc.getPublicKey());
            
            sc.setEnc(c.doFinal(sc.getKeyAES()));
            sc.setEncS(Hex.printBytesHexa(sc.getEnc()));
            
            sc.setParte1(sc.getEncS().substring(0, 478));
            sc.setLen(sc.getParte1().length());
            sc.setParte2(sc.getEncS().substring(478, 512));
            sc.setLen(sc.getParte2().length());            
            sc.setResponse(PCSCManager.sendAPDU(apdu2 + sc.getParte1()));
            sc.setResultado(Hex.printBytesHexa(sc.getResponse()));
            sc.setResult(sc.getResultado().substring(sc.getResultado().length() - 4, sc.getResultado().length() - 2));
        }
    }
    
    private void sendKeyAESpt2(String apdu1, String apdu2, String dadosToSend) throws CardException, FileNotFoundException, IOException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException{
        
         if ((sc.getResult().equals(Constants.RESPONSE_APDU_OK))) {
                PCSCManager.LOGAR("ENVIAR CHAVE AES PARTE 2");
                sc.setResponse(PCSCManager.sendAPDU(apdu1 + sc.getParte2()));
                sc.setResultado(Hex.printBytesHexa(sc.getResponse()));
                sc.setResult(sc.getResultado().substring(sc.getResultado().length() - 4, sc.getResultado().length() - 2));
                if ((sc.getResult().equals(Constants.RESPONSE_APDU_OK))) {
                    PCSCManager.LOGAR("PEGAR DESAFIO E ENVIAR PUK");

                    sc.setDesafioEnc(sc.getResultado().substring(0, sc.getResultado().length() - 4));
                    sc.setDesafioByte(Hex.toByteHexArray(sc.getDesafioEnc()));
                    
                    String iv = "0000000000000000";
                    javax.crypto.spec.IvParameterSpec ivspec = new javax.crypto.spec.IvParameterSpec(iv.getBytes());
                    SecretKeySpec secretKeySpec = new SecretKeySpec(sc.getKeyAES(), "AES");

                    // Instantiate the cipher
                    Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
                    cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, ivspec);
                    
                    sc.setOriginal(cipher.doFinal(sc.getDesafioByte()));
                    sc.setOriginalS(Hex.printBytesHexa(sc.getOriginal()));

                    sc.setHostInfo(sc.getOriginalS() + dadosToSend);
                    sc.setHostInfoByte(Hex.toByteHexArray(sc.getHostInfo()));

                    cipher = Cipher.getInstance("AES/CBC/NoPadding");
                    cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivspec);
                    sc.setDestino(cipher.doFinal(sc.getHostInfoByte()));
                    sc.setDestinoS(Hex.printBytesHexa(sc.getDestino()));
                    
                    sc.setResponse(PCSCManager.sendAPDU(apdu2 + sc.getDestinoS()));
                    sc.setResultado(Hex.printBytesHexa(sc.getResponse()));

                }            
        }
    }
    
    private String autenticaPin() throws CardException,
            FileNotFoundException,
            IOException,
            NoSuchPaddingException,
            NoSuchAlgorithmException,
            InvalidKeyException,
            InvalidKeySpecException,
            IllegalBlockSizeException,
            BadPaddingException,
            InvalidAlgorithmParameterException {
        

        PCSCManager.LOGAR("Autentica PIN");
        requestPin();

        if (sc.getPin() == null) {
            return "0C00";
        }

        //byte[] PIN_ascii = PIN.getBytes("US-ASCII");
        sc.setPinAscii(sc.getPin().getBytes("US-ASCII"));

        // GET AUTH PUBLIC KEY
        //apdu 1 = 8056000000
        //apdu 2 = 80270000EF
        sendKeyAESpt1("8056000000", "80270000EF");
        //apdu 1 = 8027800011
        //apdu 2 = 8027810020
        sendKeyAESpt2("8027800011", "8027810020", Hex.printBytesHexa(sc.getPinAscii()) + "0000000000000000");
        
        return sc.getResultado().substring(sc.getResultado().length() - 4, sc.getResultado().length());
    } // FIM PIN
    
     private String trocarPinPin() throws CardException,
            FileNotFoundException,
            IOException,
            NoSuchPaddingException,
            NoSuchAlgorithmException,
            InvalidKeyException,
            InvalidKeySpecException,
            IllegalBlockSizeException,
            BadPaddingException,
            InvalidAlgorithmParameterException {
        
        PCSCManager.LOGAR("TrocaPinPin");

        requestPin();

        if (sc.getPin() == null) {
            return "0C00";
        }
        
        sc.setPinAscii(sc.getPin().getBytes("US-ASCII"));        
        requestNewPin();
        if (sc.getNewPin() == null) {
            return "0C00";
        }
        
        sc.setNewPinAscii(sc.getNewPin().getBytes("US-ASCII"));

        // GET AUTH PUBLIC KEY
        //apdu 1 = "8056000000"
        //apdu 2 = "80170000EF"
        sendKeyAESpt1("8056000000", "80170000EF");
        //apdu 1 = "8017800011"
        //apdu 2 = "8017810120"
        sendKeyAESpt2("8017800011", "8017810120", Hex.printBytesHexa(sc.getPinAscii()) + Hex.printBytesHexa(sc.getNewPinAscii()));
             

        return sc.getResultado().substring(sc.getResultado().length() - 4, sc.getResultado().length());
    } // FIM TROCA PIN COM PIN
     
     private String trocarPukPuk() throws CardException,
            FileNotFoundException,
            IOException,
            NoSuchPaddingException,
            NoSuchAlgorithmException,
            InvalidKeyException,
            InvalidKeySpecException,
            IllegalBlockSizeException,
            BadPaddingException,
            InvalidAlgorithmParameterException {
        

        PCSCManager.LOGAR("trocarPukPuk");
        requestPuk();

        if (sc.getPuk()== null) {
            return "0C00";
        }

        //byte[] PUK_ascii = PUK.getBytes("US-ASCII");
        sc.setPukAscii(sc.getPuk().getBytes("US-ASCII"));
        
        requestNewPuk();

        if (sc.getNewPuk()== null) {
            return "0C00";
        }

        sc.setNewPukAscii(sc.getNewPuk().getBytes("US-ASCII"));

        // GET AUTH PUBLIC KEY
        //apdu 1 = 8056000000
        //apdu 2 = 80170000EF
        sendKeyAESpt1("8056000000", "80170000EF");
        //apdu 1 = 8017800011
        //apdu 2 = 8017810320
        sendKeyAESpt2("8017800011", "8017810320", Hex.printBytesHexa(sc.getPukAscii()) + Hex.printBytesHexa(sc.getNewPukAscii()));
        
        return sc.getResultado().substring(sc.getResultado().length() - 4, sc.getResultado().length());
    } // FIM TROCA PUK COM PUK
    
     private String verificaDocumento() throws CardException,
            FileNotFoundException,
            IOException {
        byte[] response = null;
        String resultado = null;
        String result = null;


        PCSCManager.LOGAR("VERIFICA CONTAINER");

        String Container = new String("");

        while (Container.length() != 1) {

            Container = JOptionPane.showInputDialog("Digite o numero do container de 0 a 7");

            if (Container == null) {
                break;
            }

            if (Container.length() != 1) {
                JOptionPane.showMessageDialog(null, "Digite o numero do container com um digito !!!");
                Container = "";
            }
        }

        if (Container == null) {
            return "0C00";
        }

        byte[] Container_ascii = Container.getBytes("US-ASCII");
        Container_ascii[0] -= 48;
        response = PCSCManager.sendAPDU("8037" + Hex.printBytesHexa(Container_ascii) + "0000");
        resultado = Hex.printBytesHexa(response);
        result = resultado.substring(resultado.length() - 4, resultado.length() - 2);
        if (result.equals(Constants.RESPONSE_APDU_OK)) {
            result = resultado.substring(0, resultado.length() - 4);
        } else {
            resultado.substring(resultado.length() - 4, resultado.length());
        }

        return result;
    }
     
     private String importarDocumento() throws CardException,
            FileNotFoundException,
            IOException,
            NoSuchAlgorithmException {
        byte[] response = null;
        String resultado = null;
        String result = null;
        MessageDigest md = MessageDigest.getInstance("SHA-256");

        PCSCManager.LOGAR("Importar Documento");


        String Container = new String("");
        while (Container.length() != 1) {
            Container = JOptionPane.showInputDialog("Digite o numero do container de 0 a 7");
            if (Container == null) {
                break;
            }
            if (Container.length() != 1) {
                JOptionPane.showMessageDialog(null, "Digite o numero do container com um digito !!!");
                Container = "";
            }
        }

        if (Container == null) {
            return "0C00";
        }

        byte[] Container_ascii = Container.getBytes("US-ASCII");
        Container_ascii[0] -= 48;

        String Sequencia = new String("0");
        byte[] Sequencia_ascii = Sequencia.getBytes("US-ASCII");
        Sequencia_ascii[0] -= 48;

        JFileChooser file = new JFileChooser();
        file.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int i = file.showSaveDialog(null);
        int max_buffer = 239;
        long contador = 0;
        int lido = 0;
        String lido_s = null;
        String comando = null;

        byte[] buffer_in = new byte[239];


        if (i != 1) {
            FileInputStream fis;
            DataInputStream dis;
            File arquivo = file.getSelectedFile();
            String fi = arquivo.getPath();
            fis = new FileInputStream(fi);
            dis = new DataInputStream(fis);

            File arq = new File(fi);
            long tam_arq = arq.length();

            md.reset();
            while (contador != tam_arq) {
                lido = dis.read(buffer_in, 0, 239);

                md.update(buffer_in, 0, lido);

                contador += lido;
                if (lido < max_buffer) {
                    Container_ascii[0] += 128;
                }

                lido_s = Long.toHexString(lido).toUpperCase();

                if (lido_s.length() < 2) {
                    lido_s = "0" + lido_s;
                }

                //    buffer.length = Integer.valueOf(lido.toString());

                comando = "8077" + Hex.printBytesHexa(Container_ascii)
                        + Hex.printBytesHexa(Sequencia_ascii)
                        + lido_s
                        + Hex.printBytesHexa(buffer_in, lido);

                response = PCSCManager.sendAPDU(comando);

                resultado = Hex.printBytesHexa(response);
                result = resultado.substring(resultado.length() - 4, resultado.length() - 2);
                if (result.equals(Constants.RESPONSE_APDU_OK)) {
                    Sequencia_ascii[0]++;
                    continue;
                } else {
                    break;
                }
            }
            dis.close();
            fis.close();
        }

        byte[] mdbytes = md.digest();

        //convert the byte to hex format method 1
        StringBuilder sb = new StringBuilder();
        for (i = 0; i < mdbytes.length; i++) {
            sb.append(Integer.toString((mdbytes[i] & 0xff) + 0x100, 16).substring(1));
        }

        //     System.out.println("Hex format : " + sb.toString().toUpperCase());

        if (resultado.substring(0, resultado.length() - 4).equals(sb.toString().toUpperCase())) {
            resultado = "9000";
        } else {
            resultado = "6984"; // dados invalidos
        }


        return resultado;
    }
     
     private String exportarDocumento() throws CardException,
            FileNotFoundException,
            IOException {
        byte[] response = null;
        String resultado = null;
        String result = null;


        PCSCManager.LOGAR("Exporta Documento");

        String Container = new String("");
        while (Container.length() != 1) {
            Container = JOptionPane.showInputDialog("Digite o numero do container de 0 a 7");
            if (Container == null) {
                break;
            }
            if (Container.length() != 1) {
                JOptionPane.showMessageDialog(null, "Digite o numero do container com um digito !!!");
                Container = "";
            }
        }

        if (Container == null) {
            return "0C00";
        }

        byte[] Container_ascii = Container.getBytes("US-ASCII");
        Container_ascii[0] -= 48;

        String Sequencia = new String("0");
        byte[] Sequencia_ascii = Sequencia.getBytes("US-ASCII");
        Sequencia_ascii[0] -= 48;

        JFileChooser dir = new JFileChooser();
        dir.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int i = dir.showSaveDialog(null);
        String comando = null;

        if (i != 1) {
            String Name_File = null;

            while (Name_File == null) {
                Name_File = JOptionPane.showInputDialog("Digite o nome do arquivo");

                if (Name_File == null) {
                    JOptionPane.showMessageDialog(null, "Digite o nome do arquivo !!!");
                    Name_File = "";
                }
            }

            FileOutputStream fos;
            DataOutputStream dos;

            String fi = dir.getSelectedFile() + "/" + Name_File;
            fos = new FileOutputStream(fi);
            dos = new DataOutputStream(fos);

            String retorno = "00";

            while (retorno.equals("00")) {
                comando = "8078" + Hex.printBytesHexa(Container_ascii)
                        + Hex.printBytesHexa(Sequencia_ascii) + "00";
                response = PCSCManager.sendAPDU(comando);
                resultado = Hex.printBytesHexa(response);
                result = resultado.substring(resultado.length() - 4, resultado.length() - 2);

                if (result.equals(Constants.RESPONSE_APDU_OK)) {
                    dos.write(response, 2, response.length - 4);
                    retorno = resultado.substring(0, 2);
                    Sequencia_ascii[0]++;
                    continue;
                } else {
                    break;
                }
            }

            if (!retorno.equals("00")) {
                dos.close();
                fos.close();
            }
        }
        return resultado.substring(resultado.length() - 4, resultado.length());
    }
     
     private String deletarDocumento() throws CardException,
            FileNotFoundException,
            IOException {
        byte[] response = null;
        String resultado = null;
        String result = null;

        PCSCManager.LOGAR("DELETA CONTAINER");

        String Container = new String("");

        while (Container.length() != 1) {
            Container = JOptionPane.showInputDialog("Digite o numero do container de 0 a 7");
            if (Container == null) {
                break;
            }
            if (Container.length() != 1) {
                JOptionPane.showMessageDialog(null, "Digite o numero do container com um digito !!!");
                Container = "";
            }
        }

        if (Container == null) {
            return "0C00";
        }

        byte[] Container_ascii = Container.getBytes("US-ASCII");
        Container_ascii[0] -= 48;

        // PRIMEIRO VERIFICA SE TEM DOCUMENTO ARMAZENADO NESTE CONTAINER
        response = PCSCManager.sendAPDU("8037" + Hex.printBytesHexa(Container_ascii) + "0000");
        resultado = Hex.printBytesHexa(response);
        result = resultado.substring(resultado.length() - 4, resultado.length() - 2);
        if (result.equals(Constants.RESPONSE_APDU_OK)) {
            result = resultado.substring(0, resultado.length() - 4);
            if (result.equals("01")) {// tem documento neste container então deletar
                response = PCSCManager.sendAPDU("8011" + Hex.printBytesHexa(Container_ascii) + "0000");
                resultado = Hex.printBytesHexa(response);
                return resultado.substring(resultado.length() - 4, resultado.length());
            }
            else{
              return resultado.substring(0,resultado.length() - 4);
            }
         
        } else {
            return resultado.substring(resultado.length() - 4, resultado.length());
        }
   }
     
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
