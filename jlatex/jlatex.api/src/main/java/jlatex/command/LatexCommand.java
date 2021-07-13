package jlatex.command;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import jlatex.util.LatexContent;

/**
 * Represents a LaTeX command (such as \\hline or \begin{}). It can handle
 * multiple parameter types (ie. \\begin{} or \\usepackage[]{}) and optionally
 * render a new line at the end of the command.
 * 
 * @author Michael Oland
 *
 * @param <T> Implementing type for the builder model
 */
public abstract class LatexCommand<T> implements LatexContent
{
	private final String name;
	private List<LatexCommandParameter<?>> parameters = new ArrayList<>();
	private boolean addNewLine = false;

	/**
	 * Creates a new LatexCommand
	 * 
	 * @param name Name of the command
	 * @param parameters Optional list of parameters to be added to the command.
	 */
	public LatexCommand(String name, LatexCommandParameter<?>... parameters)
	{
		this(name, false, parameters);
	}

	/**
	 * Creates a new LatexCommand
	 * 
	 * @param name Name of the command
	 * @param addNewLine If true, new line character(s) will be rendered into the end of the command
	 * @param parameters Optional list of parameters to be added to the command.
	 */
	public LatexCommand(String name, boolean addNewLine, LatexCommandParameter<?>... parameters)
	{
		this.addNewLine = addNewLine;
		this.name = name;
		this.parameters.addAll(Arrays.asList(parameters));
	}

	/**
	 * Adds an additional parameter to the command.
	 * 
	 * @param parameter Parameter to add
	 * @return This
	 */
	@SuppressWarnings("unchecked")
	public T addParameter(LatexCommandParameter<?> parameter)
	{
		this.parameters.add(parameter);
		return (T) this;
	}

	/**
	 * Adds additional parameters to the command.
	 * 
	 * @param parameters Parameters to add
	 * @return This
	 */
	@SuppressWarnings("unchecked")
	public T addParameters(List<LatexCommandParameter<?>> parameters)
	{
		this.parameters.addAll(parameters);
		return (T) this;
	}

	@Override
	public final void write(PrintWriter writer)
	{
		writer.printf("\\%s", name);

		parameters.forEach(param -> {
			param.write(writer);
		});

		if (addNewLine)
		{
			writer.println();
		}
	}
}
