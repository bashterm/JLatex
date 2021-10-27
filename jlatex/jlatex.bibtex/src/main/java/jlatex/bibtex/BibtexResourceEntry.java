package jlatex.bibtex;

import jlatex.command.LatexCommand;
import jlatex.command.LatexCurlyBraceCommandParameter;
import jlatex.content.LatexText;

public class BibtexResourceEntry extends LatexCommand<BibtexResourceEntry>
{
	private LatexText resource = new LatexText();
	
	public BibtexResourceEntry()
	{
		super("addbibresource", true);
		addParameter(new LatexCurlyBraceCommandParameter(resource));
	}

	public String getResource()
	{
		return resource.getContent();
	}

	public void setResource(String resource)
	{
		this.resource.setContent(resource);
	}
	
	public BibtexResourceEntry resource(String resource)
	{
		this.setResource(resource);
		return this;
	}
}
