package jlatex.content;

import java.io.PrintWriter;

import jlatex.LatexContent;

public class LatexInteger extends LatexContent
{
	private Integer value;

	public Integer getValue()
	{
		return value;
	}

	public void setValue(Integer value)
	{
		this.value = value;
	}
	
	public LatexInteger value(Integer value)
	{
		this.value = value;
		return this;
	}

	@Override
	public void write(PrintWriter writer)
	{
		writer.print(value);
	}
}