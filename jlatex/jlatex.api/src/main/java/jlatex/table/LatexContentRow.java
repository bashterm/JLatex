package jlatex.table;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a row of content for a LatexTable. This will not validate that the
 * column count is correct. It will simply render what is provided.
 * 
 * @author Michael Oland
 *
 */
public class LatexContentRow implements LatexRow
{
	private List<LatexColumn> columns = new ArrayList<>();

	/**
	 * Gets the defined columns
	 * 
	 * @return Columns
	 */
	public List<LatexColumn> getColumns()
	{
		return columns;
	}

	/**
	 * Replaces all existing columns with those in the list.
	 * 
	 * @param columns Columns
	 */
	public void setColumns(List<LatexColumn> columns)
	{
		this.columns.clear();
		this.columns.addAll(columns);
	}

	/**
	 * Adds a column to the row.
	 * 
	 * @param column Column to add
	 * @return
	 */
	public LatexContentRow addColumn(LatexColumn column)
	{
		this.columns.add(column);
		return this;
	}
	
	/**
	 * Adds a columns to the row.
	 * 
	 * @param columns Columns to add
	 * @return
	 */
	public LatexContentRow addColumn(List<LatexColumn> columns)
	{
		this.columns.addAll(columns);
		return this;
	}

	@Override
	public void write(PrintWriter writer)
	{
		for (int i = 0; i < columns.size(); i++)
		{
			if (i > 0)
			{
				writer.print(" & ");
			}

			columns.get(i).write(writer);
		}

		writer.println(" \\\\");
	}
}
