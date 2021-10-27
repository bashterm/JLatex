package jlatex.command;

import jlatex.util.LatexContent;

/**
 * A command parameter that uses parentheses: (<content>)
 * 
 * @author Michael Oland
 *
 */
public abstract class LatexParenthesisCommandParameter<T> extends LatexCommandParameter<T>
{
	/**
	 * Creates a new parentheses command parameter
	 * 
	 * @param content Content
	 */
	public LatexParenthesisCommandParameter(LatexContent content)
	{
		super('(', ')', content);
	}
}
