package jlatex.content;

import java.io.PrintWriter;

import jlatex.util.LatexContent;

/**
 * Represents a simple newline (characters 0xA, 0xB or 0xA0xB).
 * 
 * @author Michael Oland
 *
 */
public class LatexNewLine implements LatexContent
{
	@Override
	public void write(PrintWriter writer)
	{
		writer.printf("%n");
	}
}
