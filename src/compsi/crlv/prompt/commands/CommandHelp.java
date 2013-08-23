package compsi.crlv.prompt.commands;

import java.awt.Color;
import java.util.Iterator;

import pkcs11_lea.constants.Constants;
import pkcs11_lea.MainGui;
import compsi.crlv.controller.logger.Logger;
import compsi.crlv.prompt.CommandProcessor;
import compsi.crlv.prompt.ModelCommand;

/**
 * The Class CommandHelp.
 */
public class CommandHelp extends ModelCommand {

	public void run(String[] args) {

		if (args.length > 1) {

			ModelCommand command = CommandProcessor.getCommand(args[1]);
			Logger.log("-- Ajuda comando '" + command.getCommand() + "' --");
			Logger.log(command.getTextHelp());

		} else if (args.length == 1) {
			Logger.log("\nComandos:");
			for (Iterator<ModelCommand> iterator = CommandProcessor
					.getCommandList().iterator(); iterator.hasNext();){
				Logger.log("  " + iterator.next().getTemplate());
				
			}
		}
	}

	/**
	 * Instantiates a new command help.
	 */
	public CommandHelp() {
		setName("Ajuda");
		setCommand("help");
		setDescription("Topicos de ajuda para a utilizacao dos comandos.");
		setSampleCommand(getCommand() + " card-info");
		setTemplate(getCommand() + "[vazio] ou [nome comando]");
	}

}
