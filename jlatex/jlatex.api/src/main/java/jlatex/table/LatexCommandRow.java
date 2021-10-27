package jlatex.table;

import java.io.PrintWriter;

import jlatex.command.LatexCommand;

/**
 * Represents a table row/entry that is a command and not content.  Examples include
 * \hline and \toprule.
 * 
 * @author Michael Oland
 *
 */
public abstract class LatexCommandRow implements LatexRow
{
	private LatexCommand<?> command;

	/**
	 * Creates the row.
	 * 
	 * @param command LatexCommand to render
	 */
	protected LatexCommandRow(LatexCommand<?> command)
	{
		this.command = command;
	}

	@Override
	public void write(PrintWriter writer)
	{
		command.write(writer);
		writer.println();
	}
}
