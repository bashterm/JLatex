package jlatex.list;

import jlatex.util.LatexContentBlock;

/**
 * Represents a list of items (enumerate, itemize, etc).
 * 
 * @author Michael Oland
 *
 * @param <T> List type
 */
public abstract class LatexList<T> extends LatexContentBlock<T>
{
	/**
	 * Creates a new list.
	 * 
	 * @param type List type
	 */
	protected LatexList(String type)
	{
		super(type);
	}
}
