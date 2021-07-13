package jlatex.content.text;

/**
 * Represents text that is bold faced.  (\\textbf{content})
 * 
 * @author Michael Oland
 *
 */
public class LatexTextBold extends LatexTextFormatCommand<LatexTextBold>
{
	/**
	 * Creates a bold face text block
	 */
	public LatexTextBold()
	{
		super("textbf");
	}
}
