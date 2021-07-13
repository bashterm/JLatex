package jlatex.layout;

import java.io.PrintWriter;

import jlatex.content.LatexNumber;

public class LatexFixedMeasurementElement implements LatexMeasurementElement
{
	private LatexMeasurementUnit unit;
	private LatexNumber<?,?> value;

	@Override
	public void write(PrintWriter writer)
	{
		writer.printf("%s%s", value.write(), unit.getLatexContent());
	}

	public LatexMeasurementUnit getUnit()
	{
		return unit;
	}

	public void setUnit(LatexMeasurementUnit unit)
	{
		this.unit = unit;
	}
	
	public LatexFixedMeasurementElement unit(LatexMeasurementUnit unit)
	{
		this.setUnit(unit);
		return this;
	}

	public LatexNumber<?, ?> getValue()
	{
		return value;
	}

	public void setValue(LatexNumber<?, ?> value)
	{
		this.value = value;
	}
	
	public LatexFixedMeasurementElement value(LatexNumber<?, ?> value)
	{
		this.setValue(value);
		return this;
	}
}