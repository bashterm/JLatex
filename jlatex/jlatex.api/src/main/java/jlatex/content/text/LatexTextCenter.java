package jlatex.content.text;

import jlatex.util.LatexContentBlock;

/**
 * Represents text that is centered.  (\\center{content})
 * 
 * @author Michael Oland
 *
 */
public class LatexTextCenter extends LatexContentBlock<LatexTextCenter>
{
	/**
	 * Creates a new centered text block
	 */
	public LatexTextCenter()
	{
		super("center");
	}
}
