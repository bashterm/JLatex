package jlatex.util;

import java.io.PrintWriter;

/**
 * A simple comment (on a single line with a % preceding it)
 * 
 * @author Michael Oland
 *
 */
public class LatexComment implements LatexContent
{
	private String comment;

	/**
	 * Gets the comment
	 * 
	 * @return Comment
	 */
	public String getComment()
	{
		return comment;
	}

	/**
	 * Sets the comment
	 * 
	 * @param comment Comment
	 */
	public void setComment(String comment)
	{
		this.comment = comment;
	}
	
	/**
	 * Sets the comment
	 * 
	 * @param comment Comment
	 * @return This
	 */
	public LatexComment comment(String comment)
	{
		this.setComment(comment);
		return this;
	}

	@Override
	public void write(PrintWriter writer)
	{
		writer.printf("%% %s%n", comment);
	}
}
