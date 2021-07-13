package jlatex.layout.page;

import jlatex.command.LatexSimpleCommand;
import jlatex.layout.LatexMeasurementElement;

public class LatexTextWidthMeasurement extends LatexSimpleCommand implements LatexMeasurementElement
{
	public LatexTextWidthMeasurement()
	{
		super("textwidth", false);
	}
}
