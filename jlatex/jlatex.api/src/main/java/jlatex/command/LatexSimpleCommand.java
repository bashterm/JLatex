package jlatex.command;

/**
 * Represents a simple command. This is typically for a one-off command
 * necessary to support a larger scale block or other element. If the tag is
 * often reused, then it is suggested that a subclass of LatexCommand is
 * created.
 * 
 * @author Michael Oland
 *
 */
public class LatexSimpleCommand extends LatexCommand<LatexSimpleCommand>
{
	/**
	 * Creates the command.
	 * 
	 * @param name Command name
	 * @param addNewLine True to add a new line at the end of the command
	 * @param parameters Optional list of parameters
	 */
	public LatexSimpleCommand(String name, boolean addNewLine, LatexCommandParameter<?>... parameters)
	{
		super(name, addNewLine, parameters);
	}

	/**
	 * Creates the command with no parameters and addNewLine=true
	 * 
	 * @param name Command name
	 */
	public LatexSimpleCommand(String name)
	{
		super(name, true);
	}
}
