package jlatex.util;

import java.util.ArrayList;
import java.util.List;

import jlatex.command.LatexCommandParameter;

/**
 * This represents a block of LaTeX content.
 * 
 * @author Michael Oland
 *
 * @param <T> Implementing class (for the builder mechanism)
 */
public class LatexContentBlock<T> extends LatexBlock<T, LatexContent>
{
	private List<LatexContent> contents = new ArrayList<>();

	protected LatexContentBlock(String name, LatexCommandParameter<?>... parameters)
	{
		super(name, parameters);
	}

	/**
	 * Gets the contents of the block
	 */
	@Override
	protected Iterable<LatexContent> getContents()
	{
		return contents;
	}

	/**
	 * Add content to the block
	 * 
	 * @param content Content to add
	 * @return This
	 */
	@SuppressWarnings("unchecked")
	public T addContent(LatexContent content)
	{
		this.contents.add(content);
		return (T) this;
	}

	/**
	 * Add contents to the block
	 * 
	 * @param contents Contents to add
	 * @return This
	 */
	@SuppressWarnings("unchecked")
	public T addContents(List<LatexContent> contents)
	{
		this.contents.addAll(contents);
		return (T) this;
	}
}
