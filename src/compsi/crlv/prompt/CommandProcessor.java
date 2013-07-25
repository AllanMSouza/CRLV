package compsi.crlv.prompt;

import java.awt.HeadlessException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

import javax.smartcardio.CardException;

import compsi.crlv.controller.Logger;
import compsi.crlv.prompt.commands.CommandCardInfo;
import compsi.crlv.prompt.commands.CommandClear;
import compsi.crlv.prompt.commands.CommandConnect;
import compsi.crlv.prompt.commands.CommandDisconnect;
import compsi.crlv.prompt.commands.CommandHelp;
import compsi.crlv.prompt.commands.CommandSendApdu;
import compsi.crlv.prompt.commands.CommandTerminal;

import pkcs11_lea.util.StringUtil;

/**
 * A Classe CommandProcessor.
 */
public class CommandProcessor {

    /**
     * Inicia o Array ModelCommand.
     */
    public static void init() {

        commands = new ArrayList<ModelCommand>();

        commands.add(new CommandCardInfo());
        commands.add(new CommandConnect());
        commands.add(new CommandDisconnect());
        commands.add(new CommandClear());
        commands.add(new CommandHelp());       
        commands.add(new CommandSendApdu());
        commands.add(new CommandTerminal());

    }
    /** Os ultimos comandos. */
    private static Stack<String> lastCommands = new Stack<String>();
    /** Os comandos. */
    private static ArrayList<ModelCommand> commands;

    /**
     * Adiciona o historico dos comandos
     *
     * @param cmd the cmd
     */
    public static void addCommandHistory(String cmd) {

        lastCommands.push(cmd);
    }

    /**
     * Apresenta o historico dos comandos
     *
     * @param direction the direction
     *
     * @return the string
     */
    public static String showCommandHistory(boolean direction) {

        String cmd = "";

        if (!lastCommands.isEmpty()) {
            cmd = lastCommands.pop().toString();
        }

        return cmd.trim();
    }

    /**
     * Process.
     *
     * @param text the text
     *
     * @throws Exception the exception
     * @throws IOException *
     * @throws CardException *
     * @throws FileNotFoundException *
     * @throws HeadlessException *
     * @throws TokenException the token exception
     */
    public static void process(String text) throws Exception {

        System.out.println(text);

        String[] args = StringUtil.tokenize(text);

        ModelCommand command = getCommand(args[0]);

        if (command == null) {
            Logger.log("\n" + "Comando '");
            Logger.log(args[0]);
            Logger.log(
                    "' nao encontrado. Digite 'help' para obter a lista de comandos validos."
                    + "\n");

        } else {

          //  Logger.log("\n>> ");
            //Logger.log(args[0] + " ");

            for (int i = 1; i < args.length; i++) {
              //  Logger.log(args[i] + " ");
            }

            //Logger.log("\n");

            String[] params = null;

            if (args.length > 1) {
                params = new String[2];
            } else {
                params = new String[1];
            }

            params[0] = args[0];

            if (args.length > 1) {
                params[1] = StringUtil.untokenize(args, 1, args.length);
            }


            command.run(params);
        }

    }

    
    /**
     * Retorna a lista de comandos
     *
     * @return the command list
     */
    public static ArrayList<ModelCommand> getCommandList() {
        return commands;
    }

    /**
     * Retorna o comando
     *
     * @param commandName the command name
     *
     * @return the command
     */
    public static ModelCommand getCommand(String commandName) {

        for (Iterator<ModelCommand> iterator = commands.iterator(); iterator.hasNext();) {

            ModelCommand command = iterator.next();

            if (commandName.equals(command.getCommand())) {
                return command;
            }

        }

        return null;
    }
}
