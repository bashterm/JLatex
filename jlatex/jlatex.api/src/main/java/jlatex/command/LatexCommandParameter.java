package jlatex.command;

import java.io.PrintWriter;

import jlatex.util.LatexContent;

/**
 * Represents a command parameter (such as a [], {} or ()} appended to the end
 * of a LaTeX command. The parameter can be marked as optional and if it is, the
 * parameter will not be rendered into the final document if the content is
 * empty.
 * 
 * @author Michael Oland
 *
 * @param <T>
 *            Implementing class for the builder paradigm
 */
public abstract class LatexCommandParameter<T> implements LatexContent
{
	private final char start, end;
	private final LatexContent content;

	private boolean optional = false;

	/**
	 * Creates a new command parameter of the form:
	 * &lt;startchar&gt;&lt;content&gt;&lt;endchar&gt;.
	 * 
	 * @param start
	 *            Staring character, such as (, { or [.
	 * @param end
	 *            Ending character, such as ), } or ].
	 * @param content
	 *            The parameter content
	 */
	public LatexCommandParameter(char start, char end, LatexContent content)
	{
		this.start = start;
		this.end = end;
		this.content = content;
	}

	@Override
	public void write(PrintWriter writer)
	{
		// Allow for not rendering if this parameter is optional
		if (optional && ((content != null && content.isEmpty()) || content == null))
		{
			return;
		}

		writer.write(start);

		if (content != null)
		{
			content.write(writer);
		}

		writer.write(end);
	}

	/**
	 * True marks the parameter as optional so that it will not be rendered if the content is empty.
	 * 
	 * @param optional True marks the parameter as optional.
	 */
	public void setOptional(boolean optional)
	{
		this.optional = optional;
	}

	/**
	 * True marks the parameter as optional so that it will not be rendered if the content is empty.
	 * 
	 * @param optional True marks the parameter as optional.
	 * @return This
	 */
	@SuppressWarnings("unchecked")
	public T optional(boolean optional)
	{
		this.optional = optional;
		return (T) this;
	}
}
