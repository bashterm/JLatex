package jlatex.util;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Represents a list of parameters.
 * 
 * @author Michael Oland
 *
 */
public class LatexTextParameters implements LatexContent
{
	private List<String> parameters = new ArrayList<>();

	@Override
	public void write(PrintWriter writer)
	{
		writer.print(parameters.stream().collect(Collectors.joining(",")));
	}

	/**
	 * Adds a parameter
	 * 
	 * @param parameter Parameter
	 * @return This
	 */
	public LatexTextParameters addParameter(String parameter)
	{
		parameters.add(parameter);
		return this;
	}

	/**
	 * Adds parameters
	 * 
	 * @param parameters Parameters
	 * @return This
	 */
	public LatexTextParameters addParameters(List<String> parameters)
	{
		parameters.addAll(parameters);
		return this;
	}

	@Override
	public boolean isEmpty()
	{
		return parameters.isEmpty();
	}

	/**
	 * Gets the parameters
	 * 
	 * @return Parameters
	 */
	public List<String> getParameters()
	{
		return parameters;
	}
}
