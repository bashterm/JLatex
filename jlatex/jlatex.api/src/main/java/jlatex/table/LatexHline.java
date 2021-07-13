package jlatex.table;

import jlatex.command.LatexSimpleCommand;

/**
 * Represents a simple horizontal line (\hline)
 * 
 * @author Michael Oland
 *
 */
public class LatexHline extends LatexCommandRow
{
	/**
	 * Creates the hline
	 */
	public LatexHline()
	{
		super(new LatexSimpleCommand("hline",false));
	}
}
