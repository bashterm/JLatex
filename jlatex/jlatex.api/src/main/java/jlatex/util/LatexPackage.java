package jlatex.util;

import java.util.List;

import jlatex.command.LatexCommand;
import jlatex.command.LatexCurlyBraceCommandParameter;
import jlatex.command.LatexSquareBracketCommandParameter;
import jlatex.content.LatexText;

/**
 * 
 * 
 * @author bashterm
 * @author Michael Oland
 *
 */
public class LatexPackage extends LatexCommand<LatexPackage>
{
	private LatexText name = new LatexText().escapeCharacters(false);
	
	private LatexTextParameters options = new LatexTextParameters();
	
	/**
	 * Creates the package
	 */
	public LatexPackage()
	{
		super("usepackage", true);
		addParameter(new LatexSquareBracketCommandParameter(options));
		addParameter(new LatexCurlyBraceCommandParameter(name));
	}
	
	/**
	 * Gets the package name
	 * 
	 * @return Package name
	 */
	public String getName()
	{
		return name.getContent();
	}

	/**
	 * Sets the package name
	 * 
	 * @param name Package name
	 */
	public void setName(String name)
	{
		this.name.setContent(name);
	}

	/**
	 * Sets the package name
	 * 
	 * @param name Package name
	 * @return This
	 */
	public LatexPackage name(String name)
	{
		this.name.setContent(name);
		return this;
	}

	/**
	 * Gets the list of options
	 * 
	 * @return Options
	 */
	public List<String> getOptions()
	{
		return options.getParameters();
	}
	
	/**
	 * Adds an option
	 * 
	 * @param option Option to add
	 * @return
	 */
	public LatexPackage addOption(String option)
	{
		options.addParameter(option);
		return this;
	}
}
