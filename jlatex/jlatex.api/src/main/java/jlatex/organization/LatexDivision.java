package jlatex.organization;

import java.io.PrintWriter;

import jlatex.command.LatexCurlyBraceCommandParameter;
import jlatex.command.LatexSimpleCommand;
import jlatex.content.LatexContentStream;
import jlatex.content.LatexText;
import jlatex.util.LatexContent;

/**
 * Represents a section of a document (section, subsection, chapter, etc).  It is rendered
 * as \\type{name}
 * 
 * @author Michael Oland
 *
 * @param <T> Type for builder paradigm
 */
public abstract class LatexDivision<T> extends LatexContentStream<T,LatexContent>
{
	private final LatexText name = new LatexText();
	private final LatexSimpleCommand section;

	/**
	 * Creates the new division
	 * 
	 * @param type Division type
	 */
	protected LatexDivision(String type)
	{
		section = new LatexSimpleCommand(type,true,new LatexCurlyBraceCommandParameter(this.name));
	}

	/**
	 * Gets the name
	 * 
	 * @return Name
	 */
	public String getName()
	{
		return name.getContent();
	}

	/**
	 * Sets the name
	 * 
	 * @param name Name
	 */
	public void setName(String name)
	{
		this.name.setContent(name);
	}

	/**
	 * Sets the name
	 * 
	 * @param name Name
	 * @return This
	 */
	@SuppressWarnings("unchecked")
	public T name(String name)
	{
		this.name.setContent(name);
		return (T) this;
	}

	@Override
	public void write(PrintWriter writer)
	{
		section.write(writer);
		super.write(writer);
	}

}