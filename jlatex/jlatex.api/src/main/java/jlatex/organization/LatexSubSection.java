package jlatex.organization;

/**
 * Represents a \\subsection{name}
 * 
 * @author Michael Oland
 *
 */
public class LatexSubSection extends LatexDivision<LatexSubSection>
{
	/**
	 * Creates the subsection
	 */
	public LatexSubSection()
	{
		super("subsection");
	}
}
