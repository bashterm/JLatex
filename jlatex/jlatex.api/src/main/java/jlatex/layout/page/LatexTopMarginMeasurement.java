package jlatex.layout.page;

import jlatex.command.LatexSimpleCommand;
import jlatex.layout.LatexMeasurementElement;

public class LatexTopMarginMeasurement extends LatexSimpleCommand implements LatexMeasurementElement
{
	public LatexTopMarginMeasurement()
	{
		super("topmargin", false);
	}
}
