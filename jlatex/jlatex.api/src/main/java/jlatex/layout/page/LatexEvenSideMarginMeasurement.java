package jlatex.layout.page;

import jlatex.command.LatexSimpleCommand;
import jlatex.layout.LatexMeasurementElement;

public class LatexEvenSideMarginMeasurement extends LatexSimpleCommand implements LatexMeasurementElement
{
	public LatexEvenSideMarginMeasurement()
	{
		super("oddsidemargin", false);
	}
}
