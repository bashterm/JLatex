package jlatex.util;

import jlatex.command.LatexCommand;
import jlatex.command.LatexCurlyBraceCommandParameter;
import jlatex.content.LatexText;

/**
 * Represents a latex import command.
 * 
 * @author Michael Oland
 *
 */
public class LatexImport extends LatexCommand<LatexImport>
{
	private LatexText basePath = new LatexText();
	private LatexText fileName = new LatexText();
	
	private LatexCurlyBraceCommandParameter basePathParam = new LatexCurlyBraceCommandParameter(basePath);
	private LatexCurlyBraceCommandParameter fileNameParam = new LatexCurlyBraceCommandParameter(fileName);

	/**
	 * Creates the import tag
	 */
	public LatexImport()
	{
		super("import");
		addParameter(basePathParam);
		addParameter(fileNameParam);
	}

	/**
	 * Gets the base path
	 * 
	 * @return Base path
	 */
	public String getBasePath()
	{
		return basePath.getContent();
	}

	/**
	 * Sets the base path
	 * 
	 * @param basePath Base path
	 */
	public void setBasePath(String basePath)
	{
		this.basePath.setContent(basePath);
	}
	
	/**
	 * Sets the base path
	 * 
	 * @param basePath Base path
	 * @return This
	 */
	public LatexImport basePath(String basePath)
	{
		this.basePath.setContent(basePath);
		return this;
	}

	/**
	 * Gets the filename
	 * 
	 * @return Filename
	 */
	public String getFileName()
	{
		return fileName.getContent();
	}

	/**
	 * Sets the filename
	 * 
	 * @param fileName Filename
	 */
	public void setFileName(String fileName)
	{
		this.fileName.setContent(fileName);
	}
	
	/**
	 * Sets the filename
	 * 
	 * @param fileName Filename
	 * @return This
	 */
	public LatexImport fileName(String fileName)
	{
		this.fileName.setContent(fileName);
		return this;
	}
}
