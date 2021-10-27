package jlatex.table;

import jlatex.command.LatexSimpleCommand;

/**
 * Represents a toprule table command.
 * 
 * @author Michael Oland
 *
 */
public class LatexTopRule extends LatexCommandRow
{
	/**
	 * Creates the command.
	 */
	public LatexTopRule()
	{
		super(new LatexSimpleCommand("toprule",true));
	}
}
