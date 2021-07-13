package jlatex.layout.page;

import jlatex.command.LatexSimpleCommand;
import jlatex.layout.LatexMeasurementElement;

public class LatexOddSideMarginMeasurement extends LatexSimpleCommand implements LatexMeasurementElement
{
	public LatexOddSideMarginMeasurement()
	{
		super("evensidemargin", false);
	}
}
