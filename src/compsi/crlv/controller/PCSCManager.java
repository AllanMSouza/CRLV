package compsi.crlv.controller;

import java.awt.HeadlessException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import javax.smartcardio.Card;
import javax.smartcardio.CardChannel;
import javax.smartcardio.CardException;
import javax.smartcardio.CardTerminal;
import javax.smartcardio.CommandAPDU;
import javax.smartcardio.ResponseAPDU;
import javax.smartcardio.TerminalFactory;
import javax.swing.JOptionPane;

import pkcs11_lea.constants.Constants;
import compsi.crlv.controller.Logger;
import pkcs11_lea.util.Hex;

/**
 * A Classe PCSCManager.
 * 
 * @author Igor Medeiros
 */
public class PCSCManager {

    /** O terminal. */
    private static CardTerminal terminal;
    /** O card. */
    private static Card card;

    /**
     * Cria uma nova instancia do GerenciadorPCSC.
     */
    public PCSCManager() {
    }

    /**
     * Connect.
     *
     * @param indexReader a leitora principal
     * @param protocol o protocolo
     *
     * @return verdadeiro, se o resultado for sucesso.
     *
     * @throws CardException the card exception
     * @throws HeadlessException the headless exception
     * @throws FileNotFoundException excecao se o arquivo nao for encontrado
     * @throws IOException Sinais I/O quando a excecao ocorrer.
     */
    public static boolean connect(int indexReader, String protocol)
            throws CardException, IOException {

        boolean sucess = true;

        List<CardTerminal> terminals = getTerminalsList();

        terminal = (CardTerminal) terminals.get(indexReader);

        Logger.log("Leitora: " + terminal.toString() + "\n");

        if (terminal != null) {
            if (terminal.isCardPresent()) {

                card = terminal.connect(protocol);

                if (card != null) {
                   
                    Logger.log("ATR: "
                            + Hex.printBytesHexa(card.getATR().getBytes())
                            + "\n");


                    Logger.log("Protocolo: " + card.getProtocol() + "\n");
                    Logger.log("Basic channel: " + card.getBasicChannel());
                    Logger.log("Conectado com sucesso.");


                } else {
                    Logger.log("Falha ao conectar ");
                    sucess = false;
                }
            } else {
                JOptionPane.showMessageDialog(null, "Cartão nao presente na leitora '" + terminal.getName()
                        + "'", "Cartão não conectado", JOptionPane.WARNING_MESSAGE);
                Logger.log("Cartão não presente ");

                sucess = false;
            }
        }

        return sucess;
    }

    /**
     * Send apdu.
     *
     * @param apdu the apdu
     *
     * @return the byte[]
     *
     * @throws CardException the card exception
     * @throws FileNotFoundException excecao se o arquivo nao for encontrado
     * @throws IOException Sinais I/O quando a excecao ocorrer.
     */
    public static byte[] sendAPDU(String apdu) throws CardException,
            FileNotFoundException, IOException {

        return sendAPDU(apdu, "9000");
    }

    /**
     * Envia comando APDU.
     *
     * @param apdu o comando APDU.
     * @param responseExpected a resposta esperada
     *
     * @return o byte[]
     *
     * @throws CardException excecao do cartao
     * @throws FileNotFoundException excecao se o arquivo nao for encontrado
     * @throws IOException Sinais I/O quando a excecao ocorrer.
     */
    public static byte[] sendAPDU(String apdu, String responseExpected)
            throws CardException, FileNotFoundException, IOException {

        CardChannel channel = card.getBasicChannel();
        String comando;
        byte[] command = Hex.toByteHexArray(apdu);
        byte[] command2;
   //     byte[] apduResponseExpected = Hex.toByteHexArray(responseExpected);

 /*       Logger.log("\n"+">> C-APDU: " + Hex.printBytesHexa(command)
                + " [SW1/SW2 esperado: "
                + Hex.printBytesHexa(Hex.toByteHexArray(responseExpected))
                + "]\n");
*/
        byte[] response = channel.transmit((new CommandAPDU(command))).getBytes();

        ResponseAPDU responseApdu = new ResponseAPDU(response);

        byte[] sw1Sw2 = Hex.toByteHexArray(Integer.toHexString(responseApdu.getSW()));
        if (Hex.printBytesHexa(sw1Sw2).equals("9000"))
        {
         Logger.log("\n"+">> C-APDU: " + Hex.printBytesHexa(command)
                + " [SW1/SW2 esperado: "
                + Hex.printBytesHexa(Hex.toByteHexArray(responseExpected))
                + "]");

          Logger.log("<< R-Data : " + Hex.printBytesHexa(responseApdu.getData()));

          Logger.log("<< SW1 SW2: " + Hex.printBytesHexa(sw1Sw2));

    //     CONVERTE_HEXA(Hex.printBytesHexa(responseApdu.getData()));
  
        }
        else
        { String resultado = Hex.printBytesHexa(response);
          String sw1 = resultado.substring(resultado.length() - 4, resultado.length()-2);
          String sw2 = resultado.substring(resultado.length() - 2, resultado.length());
          if (sw1.equals(Constants.RESPONSE_APDU_61))
           { //apdu = "00C00000" +sw2;
              command2 = Hex.toByteHexArray("00C00000" +sw2);
              response = channel.transmit((new CommandAPDU(command2))).getBytes();
              responseApdu = new ResponseAPDU(response);

              sw1Sw2 = Hex.toByteHexArray(Integer.toHexString(responseApdu.getSW()));
              if (Hex.printBytesHexa(sw1Sw2).equals("9000"))
              {
                 Logger.log("\n"+">> C-APDU: " + Hex.printBytesHexa(command)
                   + " [SW1/SW2 esperado: "
                   + Hex.printBytesHexa(Hex.toByteHexArray(responseExpected))
                   + "]");

                 Logger.log("<< R-Data : " + Hex.printBytesHexa(responseApdu.getData()));

                 Logger.log("<< SW1 SW2: " + Hex.printBytesHexa(sw1Sw2));

               //  CONVERTE_HEXA(Hex.printBytesHexa(responseApdu.getData()));
               }
              }
              if (sw1.equals(Constants.RESPONSE_APDU_6C))
              {  //apdu  = apdu.substring(0, 8)+sw2; //+ apdu.substring(10,apdu.length()-10);
                command2 = Hex.toByteHexArray( apdu.substring(0, 8)+sw2);
                response = channel.transmit((new CommandAPDU(command2))).getBytes();
                responseApdu = new ResponseAPDU(response);
                sw1Sw2 = Hex.toByteHexArray(Integer.toHexString(responseApdu.getSW()));
                 if (Hex.printBytesHexa(sw1Sw2).equals("9000"))
                {
                 Logger.log("\n"+">> C-APDU: " + Hex.printBytesHexa(command)
                   + " [SW1/SW2 esperado: "
                   + Hex.printBytesHexa(Hex.toByteHexArray(responseExpected))
                   + "]");

                 Logger.log("<< R-Data : " + Hex.printBytesHexa(responseApdu.getData()));

                 Logger.log("<< SW1 SW2: " + Hex.printBytesHexa(sw1Sw2));

               //  CONVERTE_HEXA(Hex.printBytesHexa(responseApdu.getData()));
                }
              }
              else
              {
                 Logger.log("\n"+">> C-APDU: " + Hex.printBytesHexa(command)
                   + " [SW1/SW2 esperado: "
                   + Hex.printBytesHexa(Hex.toByteHexArray(responseExpected))
                   + "]");

                 Logger.log("<< R-Data : " + Hex.printBytesHexa(responseApdu.getData()));

                 Logger.log("<< SW1 SW2: " + Hex.printBytesHexa(sw1Sw2));

               //  CONVERTE_HEXA(Hex.printBytesHexa(responseApdu.getData()));
              }
              
              
        }
        return response;
    }

     public static void CONVERTE_HEXA(String entrada){
    String resultado = "";
    int i = 0;
    int cont = 1;
    byte [] LFCR = {0x0D,0x0A};
    String tipo = "(byte)0x";
    int tam = entrada.length()/2;

    for (i=0; i < entrada.length(); i+=2, cont++)
    { resultado = resultado + tipo + entrada.substring(i, i+2) +", ";
      if (cont == 8)
      {  resultado = resultado + "\n";
        cont =0;
      }
    }
    resultado = resultado.substring(0,resultado.length() - 2);
    resultado = resultado + "\ntam = "+ String.valueOf(tam);
    Logger.log(resultado + "\n");
   }

    public static void LOGAR(String entrada)
    {
      Logger.log("\n"+entrada);
    }

  
    /**
     * Desconectar.
     *
     * @throws CardException excecao do cartao
     * @throws FileNotFoundException excecao se o arquivo nao for encontrado
     * @throws IOException Sinais I/O quando a excecao ocorrer.
     */
    public static void disconnect() throws CardException,
            FileNotFoundException, IOException {

        card.disconnect(false);


        Logger.log("Cartao: " + card.toString());

        card = null;
        terminal = null;

    }

    /**
     * Retorna as leitoras.
     *
     * @return as leitoras
     *
     * @throws CardException excecao do cartao
     */
    public static List<CardTerminal> getTerminalsList() throws CardException {

        TerminalFactory factory = TerminalFactory.getDefault();

        List<CardTerminal> terminals = factory.terminals().list();

        return terminals;
    }

    /**
     * Retorna o cartao.
     *
     * @return o cartao
     */
    public static Card getCard() {
        return card;
    }

    /**
     * Retorna o nome do cartao.
     *
     * @param atr the atr
     *
     * @return o nome do cartao
     *
     * @throws Sinais I/O quando a excecao ocorrer.
     * @throws IOException Sinais I/O quando a excecao ocorrer.
     */
    public static String getCardName(String atr) throws IOException {

        String cardModel = "Desconhecido";

        FileReader fr = new FileReader(Constants.SC_BASE_SMARTCARDLIST_TXT);

        BufferedReader in = new BufferedReader(fr);
        String str;

        while ((str = in.readLine()) != null) {
            if (!str.startsWith("#") && str.equals(atr)) {
                cardModel = in.readLine();
            }
        }

        in.close();

        return cardModel.trim();
    }

    /**
     * Gets the terminal.
     *
     * @return the terminal
     */
    public static CardTerminal getTerminal() {
        return terminal;
    }
}
