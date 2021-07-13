package jlatex.layout.page;

import jlatex.command.LatexSimpleCommand;
import jlatex.layout.LatexMeasurementElement;

public class LatexTextHeightMeasurementElement extends LatexSimpleCommand implements LatexMeasurementElement
{
	public LatexTextHeightMeasurementElement()
	{
		super("textheight", false);
	}
}
