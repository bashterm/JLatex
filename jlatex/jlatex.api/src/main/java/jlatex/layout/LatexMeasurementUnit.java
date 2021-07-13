package jlatex.layout;

import jlatex.util.LatexEnumeration;

/**
 * Represents a specific LaTeX measurement unit, such as points, inches, etc.
 * 
 * @author Michael Oland
 *
 */
public enum LatexMeasurementUnit implements LatexEnumeration
{
	POINT("pt"),
	PICA("pc"),
	INCH("in"),
	BIG_POINT("bp"),
	CENTIMETER("cm"),
	MILLIMETER("mm"),
	DIDOT_POINT("dd"),
	CICERO_POINT("cc"),
	SCALED_POINT("sp"),
	X_HEIGHT("ex"),
	MATH_UNIT("mu"),
	EM("em");

	private String content;
	
	private LatexMeasurementUnit(String content) {
		this.content = content;
	}
	
	@Override
	public String getLatexContent()
	{
		return content;
	}
}
