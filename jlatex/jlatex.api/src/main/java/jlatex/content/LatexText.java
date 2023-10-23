package jlatex.content;

import java.io.PrintWriter;

import jlatex.util.LatexContent;

/**
 * Represents a single text string. The characters will be appropriately LaTeX
 * excaped (if escapeCharacters=true).
 * 
 * @author Michael Oland
 *
 */
public class LatexText implements LatexContent
{
	private String text = "";
	private boolean escapeCharacters = true;

	@Override
	public boolean isEmpty()
	{
		return text.isEmpty();
	}

	/**
	 * Gets the text content (non-escaped)
	 * 
	 * @return Content
	 */
	public String getContent()
	{
		return text;
	}

	/**
	 * Sets the content
	 * 
	 * @param text Content
	 */
	public void setContent(String text)
	{
		this.text = text;
	}

	/**
	 * Sets the content
	 * 
	 * @param text Content
	 * @return This
	 */
	public LatexText content(String text)
	{
		this.setContent(text);
		return this;
	}

	@Override
	public void write(PrintWriter writer)
	{
		writer.print(this.applyLatexEscapes(text));
	}

	private String applyLatexEscapes(String text)
	{
		if (text == null)
		{
			return "";
		}

		if (!escapeCharacters)
		{
			return text;
		}

		StringBuilder buffer = text.chars().collect(StringBuilder::new, this::mapLatexCharacter, StringBuilder::append);

		return buffer.toString();
	}

	private void mapLatexCharacter(StringBuilder target, int character)
	{
		// TODO: this escape section needs to be more completely fleshed out.
		// Likely there is a static map that can be used instead of a hard-coded switch statement
		switch (character)
		{
			case '\u02dc':
			{
				target.append("\\c{S}");
				break;
			}

			case '\u2122':
			{
				target.append("\\c{S}");
				break;
			}

			case '&':
			case '%':
			case '$':
			case '#':
			case '_':
			case '{':
			case '}':
			{
				target.append("\\");
				target.append((char) character);
				break;
			}

			default:
			{
				target.append((char) character);
				break;
			}
		}
	}

	/**
	 * Sets whether the characters should be escaped or not.
	 * 
	 * @param escape True will enable LaTeX escaping.
	 * @return This
	 */
	public LatexText escapeCharacters(boolean escape)
	{
		this.setEscapeCharacters(escape);
		return this;
	}

	/**
	 * Gets whether the characters should be escaped or not.
	 * 
	 * @return True indicates LaTeX escaping is enabled
	 */
	public boolean isEscapeCharacters()
	{
		return escapeCharacters;
	}

	/**
	 * Sets whether the characters should be escaped or not.
	 * 
	 * @param escape True will enable LaTeX escaping.
	 */
	public void setEscapeCharacters(boolean escape)
	{
		this.escapeCharacters = escape;
	}
}
