package compsi.crlv.prompt.commands;


import compsi.crlv.controller.logger.Logger;
import compsi.crlv.controller.pcsc.PCSCManager;
import compsi.crlv.prompt.ModelCommand;
import pkcs11_lea.util.Numbers;
import pkcs11_lea.util.StringUtil;

/**
 * A Classe CommandSendApdu.
 */
public class CommandSendApdu extends ModelCommand {

    /**
     * Instancia o novo comando send apdu.
     */
    public CommandSendApdu() {
        setName("Send APDU");
        setCommand("apdu");
        setDescription("Envia comandos APDU.");
        setTemplate(getCommand() + " [-list] | [comando]");
        setSampleCommand(getCommand() + " 0084000008");

    }

    public void run(String[] args) throws Exception {

        if (args.length == 1) {
            Logger.log("Uso: " + getTemplate());

        } else {

            String[] apdu = null;

            if (args.length == 2) {
                apdu = StringUtil.tokenize(args[1]);
            } else {
                apdu = new String[1];
                apdu[0] = args[1];
            }

            String commandApdu = Numbers.clearAPDUFormat(apdu[0]);

            if (Numbers.isHex(commandApdu)) {

                if (PCSCManager.getCard() != null
                        && PCSCManager.getTerminal() != null) {

                    if (apdu.length == 2) {
                        PCSCManager.sendAPDU(apdu[0], apdu[1]);
                    } else {
                        PCSCManager.sendAPDU(commandApdu);
                    }

                } else {
                    Logger.log("Cartao inteligente nao conectado");
                }
            }
        }
    }
}
