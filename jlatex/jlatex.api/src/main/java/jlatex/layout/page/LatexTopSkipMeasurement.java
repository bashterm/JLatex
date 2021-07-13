package jlatex.layout.page;

import jlatex.command.LatexSimpleCommand;
import jlatex.layout.LatexMeasurementElement;

public class LatexTopSkipMeasurement extends LatexSimpleCommand implements LatexMeasurementElement
{
	public LatexTopSkipMeasurement()
	{
		super("topskip", false);
	}
}
