package jlatex.list;

/**
 * Represents an enumerated list of items.
 * 
 * @author Michael Oland
 *
 */
public class LatexEnumerate extends LatexList<LatexEnumerate>
{
	/**
	 * Creates the list
	 */
	public LatexEnumerate()
	{
		super("enumerate");
	}
}
