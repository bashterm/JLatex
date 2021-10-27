package jlatex.layout;

import jlatex.command.LatexCommand;

/**
 * Represents a LaTeX horizontal space command (\\hspace).
 * 
 * @author Michael Oland
 *
 */
public class LatexHSpaceCommand extends LatexCommand<LatexHSpaceCommand>
{
	/**
	 * Creates the command
	 */
	public LatexHSpaceCommand()
	{
		super("hspace", false);
	}
}
