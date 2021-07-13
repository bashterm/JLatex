package jlatex.layout.page;

import jlatex.command.LatexSimpleCommand;
import jlatex.layout.LatexMeasurementElement;

public class LatexLineWidthMeasurementElement extends LatexSimpleCommand implements LatexMeasurementElement
{
	public LatexLineWidthMeasurementElement()
	{
		super("linewidth", false);
	}
}
