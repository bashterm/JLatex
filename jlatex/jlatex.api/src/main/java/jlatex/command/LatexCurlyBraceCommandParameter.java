package jlatex.command;

import jlatex.util.LatexContent;

/**
 * A command parameter that uses curly braces: {&lt;content&gt;}
 * 
 * @author Michael Oland
 *
 */
public class LatexCurlyBraceCommandParameter extends LatexCommandParameter<LatexCurlyBraceCommandParameter>
{
	/**
	 * Creates a new curly brace command parameter
	 * 
	 * @param content Content
	 */
	public LatexCurlyBraceCommandParameter(LatexContent content)
	{
		super('{', '}', content);
	}
}
