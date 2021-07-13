package jlatex.content.text;

import java.util.List;

import jlatex.command.LatexCommand;
import jlatex.command.LatexCommandParameter;
import jlatex.command.LatexCurlyBraceCommandParameter;
import jlatex.content.LatexSimpleContentStream;
import jlatex.util.LatexContent;

/**
 * Represents a block of formatted text (such as bold, italic, underline)  It is rendered as
 * \\tag{LatexContentStream&lt;LatexContent&gt;}
 * 
 * @author Michael Oland
 *
 * @param <T> Subclass for builder paradigm
 */
public abstract class LatexTextFormatCommand<T> extends LatexCommand<LatexTextFormatCommand<T>>
{
	private LatexSimpleContentStream stream = new LatexSimpleContentStream();

	private LatexCurlyBraceCommandParameter contentParameter = new LatexCurlyBraceCommandParameter(stream);

	/**
	 * Creates a new LatexTexFormat command
	 * 
	 * @param name Name of command
	 * @param parameters Optional additional parameters
	 */
	public LatexTextFormatCommand(String name, LatexCommandParameter<?>... parameters)
	{
		super(name, parameters);
		super.addParameter(contentParameter);
	}

	/**
	 * Adds content to the format command
	 * 
	 * @param content Content to add
	 * @return This
	 */
	@SuppressWarnings("unchecked")
	public T addContent(LatexContent content)
	{
		stream.addContent(content);
		return (T) this;
	}

	/**
	 * Adds contents to the format command
	 * 
	 * @param contents Contents to add
	 * @return This
	 */
	@SuppressWarnings("unchecked")
	public T addContents(List<LatexContent> contents)
	{
		stream.addContents(contents);
		return (T) this;
	}
}