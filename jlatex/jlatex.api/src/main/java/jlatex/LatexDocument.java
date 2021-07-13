package jlatex;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import jlatex.command.LatexSimpleCommand;
import jlatex.util.LatexBlock;
import jlatex.util.LatexContent;
import jlatex.util.LatexPreamble;

/**
 * @author bashterm
 * @author Michael Oland
 *
 */
public class LatexDocument extends LatexBlock<LatexDocument,LatexContent>
{
	public LatexDocument()
	{
		super("document");
	}

	private LatexPreamble preamble;
	private List<LatexContent> contents = new ArrayList<>();

	public void setPreamble(LatexPreamble preamble)
	{
		this.preamble = preamble;
	}

	public LatexDocument preamble(LatexPreamble preamble)
	{
		this.preamble = preamble;
		return this;
	}
	
	public LatexDocument addContent(LatexContent cont)
	{
		contents.add(cont);
		return this;
	}

	@Override
	public void write(PrintWriter writer)
	{
		preamble.write(writer);
		
		new LatexSimpleCommand("maketitle",true).write(writer);;
		
		super.write(writer);
	}

	@Override
	protected Iterable<LatexContent> getContents()
	{
		return contents;
	}
}
