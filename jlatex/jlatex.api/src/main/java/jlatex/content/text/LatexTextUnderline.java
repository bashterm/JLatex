package jlatex.content.text;

/**
 * Represents text that is underlined.  (\\underline{content})
 * 
 * @author Michael Oland
 *
 */
public class LatexTextUnderline extends LatexTextFormatCommand<LatexTextUnderline>
{
	/**
	 * Creates an underlined text block
	 */
	public LatexTextUnderline()
	{
		super("underline");
	}
}
