package jlatex.table;

import jlatex.util.LatexEnumeration;

/**
 * Represents a single or double line separator between columns.
 * 
 * @author Michael Oland
 *
 */
public enum LatexColumnLine implements LatexEnumeration
{
	SINGLE("|"),
	DOUBLE("||");
	
	private String latexContent;

	private LatexColumnLine(String latexContent) {
		this.latexContent = latexContent;
	}

	public String getLatexContent()
	{
		return latexContent;
	}
}