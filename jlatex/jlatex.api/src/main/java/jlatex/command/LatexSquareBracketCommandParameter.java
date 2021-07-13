package jlatex.command;

import jlatex.util.LatexContent;

/**
 * A command parameter that uses square brackets: [&lt;content&gt;]
 * 
 * @author Michael Oland
 *
 */
public class LatexSquareBracketCommandParameter extends LatexCommandParameter<LatexSquareBracketCommandParameter>
{
	/**
	 * Creates a new square bracket command parameter
	 * 
	 * @param content Content
	 */
	public LatexSquareBracketCommandParameter(LatexContent content)
	{
		super('[', ']', content);
	}
}
