package jlatex.layout;

import java.io.PrintWriter;

public class LatexSubtractMeasurementElement implements LatexMeasurementElement
{
	@Override
	public void write(PrintWriter writer)
	{
		writer.write('-');
	}
}
