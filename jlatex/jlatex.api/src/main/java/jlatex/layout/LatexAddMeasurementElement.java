package jlatex.layout;

import java.io.PrintWriter;

/**
 * Represents a measurement element that is adding measurement
 * 
 * @author Michael Oland
 *
 */
public class LatexAddMeasurementElement implements LatexMeasurementElement
{
	@Override
	public void write(PrintWriter writer)
	{
		writer.write('+');
	}
}
