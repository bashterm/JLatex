package jlatex.util;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Arrays;
import java.util.List;

/**
 * The base content interface for any LaTeX element. It defines the basic
 * operations for a LaTeX element and methods for interrogating specific
 * information about the tag including if it requires any specific packages and
 * if the tag has content.
 * 
 * @author bashterm, Michael Oland
 * @since 1.0
 */
public interface LatexContent
{
	/**
	 * Writes the tag or LaTeX content out the provided print writer.
	 * 
	 * @param writer
	 *            Target print writer
	 */
	public abstract void write(PrintWriter writer);

	/**
	 * Gets whether the element is empty or not
	 * 
	 * @return true if the element is empty, false if not
	 */
	public default boolean isEmpty()
	{
		return false;
	}

	/**
	 * Gets the list of required packages for this tag (if any)
	 * 
	 * @return List of required LaTeX packages and their configurations or an
	 *         empty List if there are no requriements
	 */
	public default List<LatexPackage> getRequiredPackages()
	{
		return Arrays.asList();
	}

	/**
	 * Writes the tag out as a String.  This can be overridden if necessary.
	 * 
	 * @return The tag as a string
	 */
	public default String write()
	{
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		write(pw);
		return sw.toString();
	}
}
