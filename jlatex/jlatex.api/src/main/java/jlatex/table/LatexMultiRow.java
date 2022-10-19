package jlatex.table;

import java.util.List;

import jlatex.command.LatexCurlyBraceCommandParameter;
import jlatex.command.LatexSimpleCommand;
import jlatex.content.LatexInteger;
import jlatex.content.LatexSimpleContentStream;
import jlatex.content.LatexText;
import jlatex.util.LatexContent;

public class LatexMultiRow extends LatexColumn
{
	private LatexInteger rows = new LatexInteger();

	private LatexCurlyBraceCommandParameter rowParameter = new LatexCurlyBraceCommandParameter(rows);

	private LatexText widthSpecification = new LatexText();

	private LatexCurlyBraceCommandParameter widthParameter = new LatexCurlyBraceCommandParameter(widthSpecification);

	private LatexSimpleContentStream content = new LatexSimpleContentStream();

	private LatexCurlyBraceCommandParameter contentParameter = new LatexCurlyBraceCommandParameter(content);

	public LatexMultiRow()
	{
		super.addContent(new LatexSimpleCommand("multirow", false, rowParameter, widthParameter, contentParameter));
	}

	public Integer getRows()
	{
		return rows.getValue();
	}

	public void setRows(Integer rows)
	{
		this.rows.setValue(rows);
	}

	public LatexMultiRow rows(Integer rows)
	{
		this.setRows(rows);
		return this;
	}

	@Override
	public LatexMultiRow addContent(LatexContent content)
	{
		this.content.addContent(content);
		return this;
	}

	@Override
	public LatexMultiRow addContents(List<LatexContent> contents)
	{
		this.content.addContents(contents);
		return this;
	}

	public String getWidth()
	{
		return this.widthSpecification.getContent();
	}

	public void setWidth(String width)
	{
		this.widthSpecification.setContent(width);
	}

	public LatexMultiRow width(String width)
	{
		this.widthSpecification.setContent(width);
		return this;
	}
}
