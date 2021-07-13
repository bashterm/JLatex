package jlatex.table;

import java.io.PrintWriter;
import java.util.List;

import jlatex.content.LatexSimpleContentStream;
import jlatex.layout.LatexMeasurement;
import jlatex.util.LatexContent;

/**
 * Represents the definition of a column in a LaTeX table.
 * 
 * @author Michael Oland
 *
 */
public class LatexColumnSpecification implements LatexContent
{
	private LatexColumnAlignment alignment = LatexColumnAlignment.LEFT_JUSTIFIED;

	private LatexMeasurement width;
	private LatexSimpleContentStream title = new LatexSimpleContentStream();

	private LatexColumnLine before;
	private LatexColumnLine after;

	/**
	 * Adds content to the title
	 * 
	 * @param content
	 *            Content to add
	 * @return This
	 */
	public LatexColumnSpecification addTitleContent(LatexContent content)
	{
		title.addContent(content);
		return this;
	}

	/**
	 * Adds contents to the title
	 * 
	 * @param contents
	 *            Contents to add
	 * @return This
	 */
	public LatexColumnSpecification addTitleContents(List<LatexContent> contents)
	{
		title.addContents(contents);
		return this;
	}

	/**
	 * Gets the title
	 * 
	 * @return Title
	 */
	public LatexSimpleContentStream getTitle()
	{
		return title;
	}

	/**
	 * Gets the column alignment
	 * 
	 * @return Column alignment
	 */
	public LatexColumnAlignment getAlignment()
	{
		return alignment;
	}

	/**
	 * Sets the column alignment
	 * 
	 * @param alignment
	 *            Column alignment
	 */
	public void setAlignment(LatexColumnAlignment alignment)
	{
		this.alignment = alignment;
	}

	/**
	 * Sets the column alignment
	 * 
	 * @param alignment
	 *            Column alignment
	 * @return This
	 */
	public LatexColumnSpecification alignment(LatexColumnAlignment alignment)
	{
		this.setAlignment(alignment);
		return this;
	}

	/**
	 * Gets the width
	 * 
	 * @return Width
	 */
	public LatexMeasurement getWidth()
	{
		return width;
	}

	/**
	 * Sets the width
	 * 
	 * @param width Width
	 */
	public void setWidth(LatexMeasurement width)
	{
		this.width = width;
	}

	/**
	 * Sets the width
	 * 
	 * @param width Width
	 * @return This
	 */
	public LatexColumnSpecification width(LatexMeasurement width)
	{
		this.setWidth(width);
		return this;
	}

	/**
	 * Gets the formatting before the column
	 * 
	 * @return Formatting before
	 */
	public LatexColumnLine getBefore()
	{
		return before;
	}

	/**
	 * Sets the formatting before the column
	 * 
	 * @param before Formatting before
	 */
	public void setBefore(LatexColumnLine before)
	{
		this.before = before;
	}

	/**
	 * Sets the formatting before the column
	 * 
	 * @param before Formatting before
	 * @return This
	 */
	public LatexColumnSpecification before(LatexColumnLine before)
	{
		this.before = before;
		return this;
	}

	/**
	 * Gets the formatting after the column
	 * 
	 * @return Formatting after
	 */
	public LatexColumnLine getAfter()
	{
		return after;
	}

	/**
	 * Sets the formatting after the column
	 * 
	 * @param after Formatting after
	 */
	public void setAfter(LatexColumnLine after)
	{
		this.after = after;
	}

	/**
	 * Sets the formatting after the column
	 * 
	 * @param after Formatting after
	 * @return This
	 */
	public LatexColumnSpecification after(LatexColumnLine after)
	{
		this.after = after;
		return this;
	}

	@Override
	public void write(PrintWriter writer)
	{
		writer.write(before == null ? "" : before.getLatexContent());

		writer.write(alignment.getLatexContent());

		switch (alignment)
		{
			case PARAGRAPH_TOP:
			case PARAGRAPH_MIDDLE:
			case PARAGRAPH_BOTTOM:
				if (width != null)
				{
					writer.print('{');
					writer.print(width);
					writer.print('}');
				}
				break;
			default:
				// NOOP
				break;
		}

		writer.print(after == null ? "" : after.getLatexContent());
	}
}
