package compsi.crlv.prompt.commands;

import pkcs11_lea.MainGui;
import compsi.crlv.prompt.ModelCommand;

/**
 * A Classe CommandClearConsole.
 */
public class CommandClear extends ModelCommand {

	/**
	 * Instancia o novo comando limpa console.
	 */
	public CommandClear() {
		setName("Limpa Console");
		setCommand("clear");
		setDescription("Limpa o console da GUI.");
		setTemplate(getCommand());

	}

	public void run(String[] args) {

		MainGui.getConsole().setText("");

	}

}
