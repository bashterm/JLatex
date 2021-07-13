package jlatex.reference;

/**
 * Represents a cross reference command (\\ref{label})
 * 
 * @author Michael Oland
 *
 */
public class LatexReference extends LatexAbstractLabel<LatexReference>
{
	public LatexReference()
	{
		super("ref");
	}
}
