package jlatex.content;

import java.io.PrintWriter;

import jlatex.util.LatexContent;
import jlatex.util.LatexEnumeration;

/**
 * A simple content element that wraps around a LatexEnumeration enum.  Typically
 * used for command parameters.
 * 
 * @author Michael Oland
 *
 * @param <E> Enum type
 */
public class LatexEnum<E extends Enum<?> & LatexEnumeration> implements LatexContent
{
	private E value;
	
	/**
	 * Sets the value of the element
	 * 
	 * @param value Value of the element
	 * @return This
	 */
	public LatexEnum<E> value(E value)
	{
		this.setValue(value);
		return this;
	}
	
	/**
	 * Sets the value of the element
	 * 
	 * @param value Value of the element
	 */
	public void setValue(E text)
	{
		this.value = text;
	}
	
	/**
	 * Gets the value
	 * 
	 * @return Value
	 */
	public E getValue()
	{
		return value;
	}

	@Override
	public void write(PrintWriter writer)
	{
		if(value == null) {
			return;
		}
		
		writer.print(value.getLatexContent());
	}
}
