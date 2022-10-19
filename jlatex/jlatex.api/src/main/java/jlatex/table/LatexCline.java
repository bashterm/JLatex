package jlatex.table;

import jlatex.command.LatexCommand;
import jlatex.command.LatexCurlyBraceCommandParameter;

/**
 * Represents a cline (\cline{##-##})
 * 
 * @author Michael Oland
 *
 */
public class LatexCline extends LatexCommand<String> implements LatexRow
{
	private int startColumn;
	private int endColumn;

	private LatexCurlyBraceCommandParameter column = new LatexCurlyBraceCommandParameter(w -> w.printf("%d-%d", startColumn, endColumn));

	public LatexCline()
	{
		super("cline");
		addParameter(column);
	}

	public LatexCline startColumn(int startColumn)
	{
		this.startColumn = startColumn;
		return this;
	}

	public LatexCline endColumn(int endColumn)
	{
		this.endColumn = endColumn;
		return this;
	}

	public void setStartColumn(int startColumn)
	{
		this.startColumn = startColumn;
	}

	public void setEndColumn(int endColumn)
	{
		this.endColumn = endColumn;
	}
}