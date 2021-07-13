package jlatex.layout.page;

import jlatex.command.LatexSimpleCommand;
import jlatex.layout.LatexMeasurementElement;

public class LatexHsizeMeasurement extends LatexSimpleCommand implements LatexMeasurementElement
{
	public LatexHsizeMeasurement()
	{
		super("hsize", false);
	}
}
