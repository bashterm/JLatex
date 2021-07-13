package jlatex.reference;

import java.util.List;

import jlatex.command.LatexCommand;
import jlatex.command.LatexCurlyBraceCommandParameter;
import jlatex.command.LatexSquareBracketCommandParameter;
import jlatex.content.LatexSimpleContentStream;
import jlatex.content.LatexText;
import jlatex.util.LatexContent;

/**
 * Represents a LaTeX caption.
 * 
 * @author Michael Oland
 *
 */
public class LatexCaption extends LatexCommand<LatexCaption>
{
	private LatexSimpleContentStream longText = new LatexSimpleContentStream();
	private LatexText shortText = new LatexText();

	private LatexCurlyBraceCommandParameter longParameter = new LatexCurlyBraceCommandParameter(longText);
	private LatexSquareBracketCommandParameter shortParameter = new LatexSquareBracketCommandParameter(shortText).optional(true);

	public LatexCaption()
	{
		super("caption");
		addParameter(longParameter);
		addParameter(shortParameter);
	}

	/**
	 * Gets the short text caption
	 * 
	 * @return Short text caption
	 */
	public String getShortText()
	{
		return shortText.getContent();
	}

	/**
	 * Sets the short text caption
	 * 
	 * @param text Short text caption
	 */
	public void setShortText(String text)
	{
		shortText.setContent(text);
	}

	/**
	 * Sets the short text caption
	 * 
	 * @param text Short text caption
	 * @return This
	 */
	public LatexCaption shortText(String text)
	{
		shortText.setContent(text);
		return this;
	}

	/**
	 * Gets the long text caption as a content stream
	 * 
	 * @return Long text caption
	 */
	public LatexSimpleContentStream getLongText()
	{
		return longText;
	}

	/**
	 * Adds long text content element
	 * 
	 * @param content Long text content element
	 * @return This
	 */
	public LatexCaption addLongTextContent(LatexContent content)
	{
		this.longText.addContent(content);
		return this;
	}

	/**
	 * Adds long text content elements
	 * 
	 * @param contents Long text content elements
	 * @return This
	 */
	public LatexCaption addLongTextContent(List<LatexContent> contents)
	{
		this.longText.addContents(contents);
		return this;
	}
}
