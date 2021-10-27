package jlatex.table;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import jlatex.util.LatexContent;

/**
 * Represents the specifications list for a table.
 * 
 * @author Michael Oland
 */
public class LatexColumnSpecifications implements LatexContent
{
	private List<LatexColumnSpecification> columnSpecifications = new ArrayList<>();

	@Override
	public void write(PrintWriter writer)
	{
		columnSpecifications.forEach(def -> def.write(writer));
	}

	/**
	 * Gets the list of column specifications.
	 * 
	 * @return Column specifications list
	 */
	public List<LatexColumnSpecification> getColumnSpecifications()
	{
		return columnSpecifications;
	}

	/**
	 * Sets the column specification list
	 * 
	 * @param columnSpecifications Column specifications
	 */
	public void setColumnSpecifications(List<LatexColumnSpecification> columnSpecifications)
	{
		this.columnSpecifications = columnSpecifications;
	}

	/**
	 * Sets the column specification list
	 * 
	 * @param columnSpecifications Column specifications
	 * @return This
	 */
	public LatexColumnSpecifications columnSpecifications(List<LatexColumnSpecification> columnSpecifications)
	{
		this.columnSpecifications = columnSpecifications;
		return this;
	}

	/**
	 * Adds a list of column specifications
	 * 
	 * @param columnSpecifications Column specifications
	 * @return This
	 */
	public LatexColumnSpecifications addColumnSpecifications(List<LatexColumnSpecification> columnSpecifications)
	{
		this.columnSpecifications.addAll(columnSpecifications);
		return this;
	}

	/**
	 * Adds a column specification
	 * 
	 * @param columnSpecification Column specification
	 * @return This
	 */
	public LatexColumnSpecifications addColumnSpecification(LatexColumnSpecification columnSpecification)
	{
		this.columnSpecifications.add(columnSpecification);
		return this;
	}
}
