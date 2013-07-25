package compsi.crlv.prompt.commands;

import pkcs11_lea.constants.Constants;
import pkcs11_lea.MainGui;
import compsi.crlv.controller.Logger;
import compsi.crlv.controller.PCSCManager;
import compsi.crlv.prompt.ModelCommand;
import pkcs11_lea.util.StringUtil;

/**
 * A Classe CommandConnect.
 */
public class CommandConnect extends ModelCommand {

	/**
	 * Instancia o novo comando connect.
	 */
	public CommandConnect() {
		setName("PC/SC Connect");
		setCommand("connect");
		setSampleCommand(getCommand() + " 0 t=1");
		setDescription("Estabelece uma conexao entre cartao e leitora.");
		setTemplate(getCommand() + " [indice leitora]" + " [T=0 ou T=1]");
	}

	public void run(String[] args) throws Exception {

		if (args.length == 1) {

			int selectedIndex = 1;
			String proto = null;

			try {

				PCSCManager.connect(selectedIndex, proto);

			} catch (Exception e) {

				selectedIndex = -1;
			}

			if (selectedIndex == -1 || proto == null)
				Logger.log("Uso: " + getTemplate());

		} else {
			String[] params = StringUtil.tokenize(args[1]);
			PCSCManager.connect(Integer.parseInt(params[0]), params[1]);
                
		}

	}
}
