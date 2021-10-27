package jlatex.bibtex;

import jlatex.command.LatexCommand;
import jlatex.command.LatexCurlyBraceCommandParameter;
import jlatex.content.LatexText;

public class LatexCitation extends LatexCommand<LatexCitation>
{
	private LatexText key = new LatexText();
	private LatexCurlyBraceCommandParameter keyParameter = new LatexCurlyBraceCommandParameter(key);

	public LatexCitation()
	{
		super("cite");
		addParameter(keyParameter);
	}

	public String getKey()
	{
		return key.getContent();
	}

	public void setKey(String key)
	{
		this.key.setContent(key);
	}

	public LatexCitation key(String key)
	{
		this.key.setContent(key);
		return this;
	}
}
