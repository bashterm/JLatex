package jlatex.list;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import jlatex.command.LatexSimpleCommand;
import jlatex.command.LatexSquareBracketCommandParameter;
import jlatex.content.LatexNewLine;
import jlatex.content.LatexText;
import jlatex.util.LatexContent;

/**
 * 
 * 
 * @author Michael Oland
 *
 */
public class LatexListItem implements LatexContent
{
	private LatexText options = new LatexText().escapeCharacters(false);

	private LatexSimpleCommand item = new LatexSimpleCommand("item", false, new LatexSquareBracketCommandParameter(options).optional(true));

	private List<LatexContent> contents = new ArrayList<>();

	public LatexListItem addContent(LatexContent content)
	{
		this.contents.add(content);
		return this;
	}

	public LatexListItem addContents(List<LatexContent> contents)
	{
		this.contents.addAll(contents);
		return this;
	}

	@Override
	public void write(PrintWriter writer)
	{
		item.write(writer);
		writer.write(' ');
		contents.forEach(content -> content.write(writer));
		new LatexNewLine().write(writer);
	}
}
