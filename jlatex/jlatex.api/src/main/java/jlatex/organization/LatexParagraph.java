package jlatex.organization;

import java.io.PrintWriter;

import jlatex.command.LatexSimpleCommand;
import jlatex.content.LatexContentStream;
import jlatex.util.LatexContent;

/**
 * Represents a paragraph of text as a stream of LatexContent ended with a \\par command.
 * 
 * @author Michael Oland
 *
 */
public class LatexParagraph extends LatexContentStream<LatexParagraph,LatexContent>
{
	@Override
	public void write(PrintWriter writer)
	{
		super.write(writer);
		new LatexSimpleCommand("par",true).write(writer);
	}
}
