package jlatex.layout.page;

import jlatex.command.LatexSimpleCommand;
import jlatex.layout.LatexMeasurementElement;

public class LatexPaperWidthMeasurement extends LatexSimpleCommand implements LatexMeasurementElement
{
	public LatexPaperWidthMeasurement()
	{
		super("paperwidth", false);
	}
}
