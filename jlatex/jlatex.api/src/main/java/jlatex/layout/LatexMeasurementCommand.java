package jlatex.layout;

import java.util.List;

import jlatex.command.LatexCommand;
import jlatex.command.LatexCurlyBraceCommandParameter;

public class LatexMeasurementCommand<T> extends LatexCommand<T>
{
	private LatexMeasurement measurement = new LatexMeasurement();

	public LatexMeasurementCommand(String name, boolean addNewLine)
	{
		super(name, addNewLine);
		addParameter(new LatexCurlyBraceCommandParameter(measurement));
	}

	@SuppressWarnings("unchecked")
	public T addMeasurement(LatexMeasurementElement element)
	{
		measurement.addContent(element);
		return (T) this;
	}
	
	@SuppressWarnings("unchecked")
	public T addMeasurements(List<LatexMeasurementElement> elements)
	{
		measurement.addContents(elements);
		return (T) this;
	}
	
	public List<LatexMeasurementElement> getMeasurements()
	{
		return measurement.getContents();
	}
}
