package jlatex.util;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import jlatex.command.LatexCurlyBraceCommandParameter;
import jlatex.command.LatexSimpleCommand;
import jlatex.content.LatexSimpleContentStream;
import jlatex.content.LatexText;

/**
 * Represents the preamble of a LaTeX document.
 * 
 * @author bashterm
 * @author Michael Oland
 *
 */
public class LatexPreamble implements LatexContent
{
	private LatexDocumentClassCommand documentClass = new LatexDocumentClassCommand();

	private LatexSimpleContentStream title = new LatexSimpleContentStream();

	private LatexCurlyBraceCommandParameter titleParameter = new LatexCurlyBraceCommandParameter(title);

	private LatexSimpleCommand titleCommand = new LatexSimpleCommand("title", true, titleParameter);

	private LatexSimpleContentStream authorContent = new LatexSimpleContentStream();

	private LatexCurlyBraceCommandParameter authorParameter = new LatexCurlyBraceCommandParameter(authorContent);

	private LatexSimpleCommand authorCommand = new LatexSimpleCommand("author", true, authorParameter);

	private LatexText date = new LatexText().escapeCharacters(false);

	private LatexCurlyBraceCommandParameter dateParameter = new LatexCurlyBraceCommandParameter(date);

	private LatexSimpleCommand dateCommand = new LatexSimpleCommand("date", true, dateParameter);

	private List<LatexPackage> packages = new ArrayList<>();

	/**
	 * Adds content to the preamble
	 * 
	 * @param content Content to add
	 * @return This
	 */
	public LatexPreamble addContent(LatexContent content)
	{
		this.authorContent.addContent(content);
		return this;
	}

	/**
	 * Adds contents to the preamble
	 * 
	 * @param contents Contents to add
	 * @return This
	 */
	public LatexPreamble addContents(List<LatexContent> contents)
	{
		this.authorContent.addContents(contents);
		return this;
	}

	/**
	 * Gets the title content
	 * 
	 * @return Title content
	 */
	public List<LatexContent> getTitleContent()
	{
		return title.getContents();
	}

	/**
	 * Adds title contents
	 * 
	 * @param contents Contents to add
	 * @return This
	 */
	public LatexPreamble addTitleContents(List<LatexContent> contents)
	{
		this.title.addContents(contents);
		return this;
	}

	/**
	 * Adds title content
	 * 
	 * @param content Content to add
	 * @return This
	 */
	public LatexPreamble addTitleContent(LatexContent content)
	{
		this.title.addContent(content);
		return this;
	}

	/**
	 * Gets the date
	 * 
	 * @return Date
	 */
	public String getDate()
	{
		return date.getContent();
	}

	/**
	 * Sets the date
	 * 
	 * @param date Date
	 */
	public void setDate(String date)
	{
		this.date.setContent(date);
	}

	/**
	 * Sets the date
	 * 
	 * @param date Date
	 * @return This
	 */
	public LatexPreamble date(String date)
	{
		this.setDate(date);
		return this;
	}

	/**
	 * Gets the packages
	 * 
	 * @return Packages
	 */
	public List<LatexPackage> getPackages()
	{
		return packages;
	}

	/**
	 * Add a package
	 * 
	 * @param packages Package to add
	 * @return
	 */
	public LatexPreamble addPackages(List<LatexPackage> packages)
	{
		this.packages.addAll(packages);
		return this;
	}

	/**
	 * Adds a package
	 * 
	 * @param lp Package to add
	 * @return This
	 */
	public LatexPreamble addPackage(LatexPackage lp)
	{
		this.packages.add(lp);
		return this;
	}

	/**
	 * Add document class options
	 * 
	 * @param options Options to add
	 * @return This
	 */
	public LatexPreamble addDocumentClassOptions(List<String> options)
	{
		this.documentClass.addOptions(options);
		return this;
	}

	/**
	 * Add document class option
	 * 
	 * @param option Option to add
	 * @return This
	 */
	public LatexPreamble addDocumentClassOption(String option)
	{
		this.documentClass.addOption(option);
		return this;
	}
	
	public LatexPreamble className(String name)
	{
		this.documentClass.className(name);
		return this;
	}
	
	public void setClassName(String name)
	{
		this.documentClass.className(name);
	}
	
	public LatexPreamble addAuthorContent(LatexContent author)
	{
		this.authorContent.addContent(author);
		return this;
	}

	@Override
	public void write(PrintWriter writer)
	{
		documentClass.write(writer);

		if (packages != null)
		{
			for (LatexPackage l : packages)
			{
				l.write(writer);
			}
		}

		titleCommand.write(writer);
		authorCommand.write(writer);

		if (!date.isEmpty())
		{
			dateCommand.write(writer);
		}
	}
}
