package jlatex.content.text;

import java.io.PrintWriter;

import jlatex.content.LatexContentStream;
import jlatex.util.LatexContent;

/**
 * Represents a stream of text that is wrapped in single quotes.
 * 
 * @author Michael Oland
 *
 */
public class LatexSingleQuoteText extends LatexContentStream<LatexSingleQuoteText,LatexContent>
{
	public void write(PrintWriter writer)
	{
		writer.append('`');
		super.write(writer);
		writer.append('\'');
	}
}
