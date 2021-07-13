package jlatex.list;

/**
 * Represents an itemized list of items.
 * 
 * @author Michael Oland
 *
 */
public class LatexItemize extends LatexList<LatexItemize>
{
	/**
	 * Creates the list
	 */
	public LatexItemize()
	{
		super("itemize");
	}
}
