package jlatex.table;

import jlatex.util.LatexEnumeration;

public enum LatexCellPosition implements LatexEnumeration
{
	BOTTOM("b"),
	CENTER("c"),
	TOP("t");
	
	private String latexContent;

	private LatexCellPosition(String latexContent) {
		this.latexContent = latexContent;
	}

	public String getLatexContent()
	{
		return latexContent;
	}
}