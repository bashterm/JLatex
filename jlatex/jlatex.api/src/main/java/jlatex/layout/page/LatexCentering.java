package jlatex.layout.page;

import jlatex.command.LatexSimpleCommand;

/**
 * Represents a centering command (\\centering)
 * 
 * @author Michael Oland
 *
 */
public class LatexCentering extends LatexSimpleCommand
{
	/**
	 * Creates the command
	 */
	public LatexCentering()
	{
		super("centering");
	}
}
