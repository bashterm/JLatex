package jlatex.content.text;

import java.io.PrintWriter;

import jlatex.content.LatexContentStream;
import jlatex.util.LatexContent;

/**
 * Represents a stream of text that is wrapped in double quotes.
 * 
 * @author Michael Oland
 *
 */
public class LatexDoubleQuoteText extends LatexContentStream<LatexDoubleQuoteText,LatexContent>
{
	public void write(PrintWriter writer)
	{
		writer.append("``");
		super.write(writer);
		writer.append("''");
	}
}
