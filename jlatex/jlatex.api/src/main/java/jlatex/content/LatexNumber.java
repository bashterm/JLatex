package jlatex.content;

import java.io.PrintWriter;

import jlatex.util.LatexContent;

/**
 * Represents a number as LaTeX content. The number can be rendered directly
 * ({{@link N#toString()}) or if necessary, the format can be set by providing a
 * {#link {@link String#format(String, Object...)} style printf specifier.
 * 
 * @author uthanda
 *
 * @param <N> Number type
 * @param <T> Subclass type
 */
public class LatexNumber<N, T> implements LatexContent
{
	private N value;
	private String format;

	public LatexNumber()
	{
		super();
	}

	/**
	 * Gets the value of the element
	 * 
	 * @return Value
	 */
	public N getValue()
	{
		return value;
	}

	/**
	 * Sets the value of the element
	 * 
	 * @param value
	 *            Value
	 */
	public void setValue(N value)
	{
		this.value = value;
	}

	/**
	 * Sets the value of the element
	 * 
	 * @param value
	 *            Value
	 * @return This
	 */
	@SuppressWarnings("unchecked")
	public T value(N value)
	{
		this.setValue(value);
		return (T) this;
	}

	/**
	 * Gets the format specifier for rendering
	 * 
	 * @return Format specifier
	 */
	public String getFormat()
	{
		return format;
	}

	/**
	 * Sets the format specifier
	 * 
	 * @param format
	 *            Format specifier
	 * @see String#format(String, Object...)
	 */
	public void setFormat(String format)
	{
		this.format = format;
	}

	/**
	 * Sets the format specifier
	 * 
	 * @param format
	 *            Format specifier
	 * @see String#format(String, Object...)
	 * @return This
	 */
	@SuppressWarnings("unchecked")
	public T format(String format)
	{
		this.setFormat(format);
		return (T) this;
	}

	/**
	 * If value == null, nothing is written. If format is specified then
	 * writer.format(format, value) will be called, otherwise
	 * writer.print(value) is called.
	 */
	@Override
	public void write(PrintWriter writer)
	{
		if (value == null)
		{
			return;
		}
		else if (format != null)
		{
			writer.format(format, value);
		}
		else
		{
			writer.print(value);
		}
	}

}