package compsi.crlv.prompt.commands;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.smartcardio.CardException;

import pkcs11_lea.MainGui;
import compsi.crlv.controller.Logger;
import compsi.crlv.controller.PCSCManager;
import compsi.crlv.prompt.ModelCommand;

/**
 * A Classe CommandDisconnect.
 */
public class CommandDisconnect extends ModelCommand {

    /**
     * Instancia o novo comando disconnect.
     */
    public CommandDisconnect() {
        setName("PC/SC Disconnect");
        setCommand("disconnect");
        setDescription("Encerra a conexao entre cartao e leitora.");
        setTemplate(getCommand());
    }

    public void run(String[] args) throws FileNotFoundException, IOException {
        try {
            if (PCSCManager.getCard() != null) {
                PCSCManager.disconnect();
            } else {
                Logger.log("Desconectado com sucesso.");
            }

        } catch (CardException e) {
        }
    }
}
