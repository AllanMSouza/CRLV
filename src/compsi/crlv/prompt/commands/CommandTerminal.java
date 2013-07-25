package compsi.crlv.prompt.commands;

import java.util.List;

import javax.smartcardio.CardTerminal;

import compsi.crlv.controller.Logger;
import compsi.crlv.controller.PCSCManager;
import compsi.crlv.prompt.ModelCommand;

/**
 * A Classe CommandTerminalInfo.
 */
public class CommandTerminal extends ModelCommand {

	public void run(String[] args) throws Exception {

		if (args.length == 1) {
			if (PCSCManager.getTerminal() != null) {

				Logger.log("Terminal: " + PCSCManager.getTerminal().toString()
						+ "\n");
				Logger
						.log("Cartao inteligente: "
								+ (PCSCManager.getTerminal().isCardPresent() ? "presente"
										: "nao presente") + "\n");
			} else
				Logger.log("Leitora nao conectada.\n");
		} else if (args[1].equals("-list")) {
			List<CardTerminal> terminals = PCSCManager.getTerminalsList();

			int i = 0;
			for (CardTerminal cardTerminal : terminals)
				Logger.log(i++ + " " + cardTerminal);
		}
	}

	/**
	 * Instancia o novo comando terminal info.
	 */
	public CommandTerminal() {
		setName("Terminal Info");
		setCommand("terminal");
		setDescription("Obtem informacoes da leitora PC/SC");
		setTemplate(getCommand() + "[-list]");
	}
}
