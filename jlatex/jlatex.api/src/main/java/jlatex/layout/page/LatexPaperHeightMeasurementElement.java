package jlatex.layout.page;

import jlatex.command.LatexSimpleCommand;
import jlatex.layout.LatexMeasurementElement;

public class LatexPaperHeightMeasurementElement extends LatexSimpleCommand implements LatexMeasurementElement
{
	public LatexPaperHeightMeasurementElement()
	{
		super("paperheight", false);
	}
}
