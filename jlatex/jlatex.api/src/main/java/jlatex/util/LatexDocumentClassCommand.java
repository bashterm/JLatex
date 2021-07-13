package jlatex.util;

import java.util.List;

import jlatex.command.LatexCommand;
import jlatex.command.LatexCurlyBraceCommandParameter;
import jlatex.command.LatexSquareBracketCommandParameter;
import jlatex.content.LatexText;

/**
 * Represents the documentclass command for a LaTeX document.
 * 
 * @author Michael Oland
 *
 */
public class LatexDocumentClassCommand extends LatexCommand<LatexDocumentClassCommand>
{
	private LatexText className = new LatexText();
	
	private LatexCurlyBraceCommandParameter classNameParameter = new LatexCurlyBraceCommandParameter(className); 
	
	private LatexTextParameters options = new LatexTextParameters();
	
	private LatexSquareBracketCommandParameter optionsParameter = new LatexSquareBracketCommandParameter(options).optional(true); 

	/**
	 * Creates the command. 
	 */
	public LatexDocumentClassCommand()
	{
		super("documentclass", true);
		addParameter(optionsParameter);
		addParameter(classNameParameter);
	}

	/**
	 * Sets the class name
	 * 
	 * @param className Class name
	 * @return This
	 */
	public LatexDocumentClassCommand className(String className) {
		this.className.content(className);
		return this;
	}
	
	/**
	 * Adds a document class option
	 * 
	 * @param option Option to add
	 * @return This
	 */
	public LatexDocumentClassCommand addOption(String option) {
		this.options.addParameter(option);
		return this;
	}

	/**
	 * Adds document class options
	 * 
	 * @param options Options to add
	 * @return This
	 */
	public LatexDocumentClassCommand addOptions(List<String> options)
	{
		this.options.addParameters(options);
		return this;
	}
}
