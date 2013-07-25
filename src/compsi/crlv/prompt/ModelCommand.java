package compsi.crlv.prompt;


/**
 * A Classe ModelCommand.
 */
public abstract class ModelCommand {

	/** O nome. */
	private String name;

	/** O comando prompt sample. */
	private String sampleCommand;

	/** A descricao. */
	private String description;

	/** O comando. */
	private String command;

	/** O template. */
	private String template;

	/** O texto do help. */
	private String textHelp;

	/**
	 * Retorna o nome.
	 * 
	 * @return o nome
	 */
	public String getName() {
		return name;
	}

	/**
	 * Define os nomes.
	 * 
	 * @param name um novo nome
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Retorna a descricao.
	 * 
	 * @return a descricao
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Define a descricao.
	 * 
	 * @param description a nova descricao
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Retorna o comando.
	 * 
	 * @return o comando
	 */
	public String getCommand() {
		return command;
	}

	/**
	 * Define o comando.
	 * 
	 * @param command o novo comando
	 */
	public void setCommand(String command) {
		this.command = command;
	}

	/**
	 * Retorna o template.
	 * 
	 * @return o template
	 */
	public String getTemplate() {
		return template;
	}

	/**
	 * Define o template.
	 * 
	 * @param template o novo template
	 */
	public void setTemplate(String template) {
		this.template = template;
	}

	/**
	 * Retorna o texto de ajuda.
	 * 
	 * @return o texto de ajuda
	 */
	public String getTextHelp() {

		StringBuffer st = new StringBuffer();

		st.append("Comando '" + name + "' (" + command + ")\n");
		st.append("  Descricao: " + description + "\n");
		st.append("  Uso: " + (command) + "\n");
		st.append("  Exemplo: " + getSampleCommand() + "\n");

		textHelp = st.toString();

		return textHelp;
	}

	public String toString() {
		return command;
	}

	/**
	 * Executa.
	 * 
	 * @param args os argumentos
	 * 
	 * @throws Exception a excecao
	 */
	abstract public void run(String[] args) throws Exception;

	/**
	 * Retorna o comando de exemplo
	 * Gets the sample command.
	 * 
	 * @return the sample command
	 */
	public String getSampleCommand() {

		if (sampleCommand == null)
			sampleCommand = command;

		return sampleCommand;
	}

	/**
	 * Envia o comando de exemplo
	 * 
	 * @param sampleCommand the new sample command
	 */
	public void setSampleCommand(String sampleCommand) {
		this.sampleCommand = sampleCommand;
	}

}
