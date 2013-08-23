package compsi.crlv.prompt.commands;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.smartcardio.Card;

import compsi.crlv.controller.logger.Logger;
import compsi.crlv.controller.pcsc.PCSCManager;
import compsi.crlv.prompt.ModelCommand;
import pkcs11_lea.util.Hex;

/**
 * A Classe CommandCardInfo.
 */
public class CommandCardInfo extends ModelCommand {

	/**
	 * Instancia o novo comando card info.
	 */
	public CommandCardInfo() {
		setName("Card Info");
		setCommand("card-info");
		setDescription("Obtem informacoes do cartao.");

		setTemplate(getCommand());
	}

	public void run(String[] args) throws FileNotFoundException, IOException {

		Card card = PCSCManager.getCard();

		if (card != null) {
			String atr = Hex.printBytesHexa(card.getATR()
					.getBytes());
			Logger.log(card.toString() + "\n");
			Logger.log(PCSCManager.getCardName(atr) + "\n");
			Logger.log("ATR: " + atr + "\n");
		} else {
			Logger.log("Cartao inteligente nao conectado");			
		}
	}
}
