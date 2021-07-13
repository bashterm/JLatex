package jlatex.organization;

/**
 * Represents a \\section{name}
 * 
 * @author Michael Oland
 *
 */
public class LatexSection extends LatexDivision<LatexSection>
{
	/**
	 * Creates the section
	 */
	public LatexSection()
	{
		super("section");
	}
}
