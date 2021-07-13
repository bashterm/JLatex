package jlatex.content;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import jlatex.util.LatexContent;

/**
 * Represents a stream of LaTeX content elements.  The contents are
 * rendered in order provided.
 * 
 * @author Michael Oland
 *
 * @param <C> Expected content type
 * @param <T> Subclass for builder pattern.
 */
public class LatexContentStream<T,C extends LatexContent> implements LatexContent
{
	private List<C> contents = new ArrayList<>();

	/**
	 * Gets the contents of the stream
	 * 
	 * @return Contents
	 */
	public List<C> getContents()
	{
		return contents;
	}

	/**
	 * Adds a list of content to the stream
	 * 
	 * @param contents Contents to add
	 * @return This
	 */
	@SuppressWarnings("unchecked")
	public T addContents(List<C> contents)
	{
		this.contents.addAll(contents);
		return (T) this;
	}
	
	/**
	 * Adds a content to the stream
	 * 
	 * @param content Content to add
	 * @return This
	 */
	@SuppressWarnings("unchecked")
	public T addContent(C content)
	{
		this.contents.add(content);
		return (T) this;
	}

	@Override
	public void write(PrintWriter writer)
	{
		contents.forEach(content -> content.write(writer));
	}
}
