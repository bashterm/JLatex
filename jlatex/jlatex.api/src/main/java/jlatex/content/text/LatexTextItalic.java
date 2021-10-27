package jlatex.content.text;

/**
 * Represents text that is bold faced.  (\\textitt{content})
 * 
 * @author Michael Oland
 *
 */
public class LatexTextItalic extends LatexTextFormatCommand<LatexTextItalic>
{
	/**
	 * Creates an italic text block
	 */
	public LatexTextItalic()
	{
		super("textit");
	}
}
