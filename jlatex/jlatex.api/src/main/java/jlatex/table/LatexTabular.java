package jlatex.table;

import java.util.ArrayList;
import java.util.List;

import jlatex.command.LatexCurlyBraceCommandParameter;
import jlatex.util.LatexBlock;

/**
 * Represents a tabular section.
 * 
 * <pre>
 * \begin{tabular}{|c|c|}
 *   \hline
 *   A &amp; B \\
 *   \hline
 *   C &amp; D \\
 *   \hline
 * \end{tabular}
 * </pre>
 * 
 * @author Michael Oland
 *
 */
public class LatexTabular extends LatexBlock<LatexTabular, LatexRow>
{
	private LatexColumnSpecifications columnSpecifications = new LatexColumnSpecifications();

	private LatexCurlyBraceCommandParameter columnSpecificationsParameter = new LatexCurlyBraceCommandParameter(columnSpecifications);

	private List<LatexRow> rows = new ArrayList<>();

	/**
	 * Creates the tabular section
	 */
	public LatexTabular()
	{
		super("tabular");
		addBeginParameter(columnSpecificationsParameter);
	}

	/**
	 * Gets the column specifications.
	 * 
	 * @return Column specifications
	 */
	public List<LatexColumnSpecification> getColumnSpecifications()
	{
		return columnSpecifications.getColumnSpecifications();
	}

	public void setColumnSpecifications(List<LatexColumnSpecification> columnSpecifications)
	{
		this.columnSpecifications.setColumnSpecifications(columnSpecifications);
	}

	public LatexTabular addColumnSpecification(LatexColumnSpecification specification)
	{
		this.columnSpecifications.addColumnSpecification(specification);
		return this;
	}

	public LatexTabular addColumnSpecifications(List<LatexColumnSpecification> specifications)
	{
		this.columnSpecifications.addColumnSpecifications(specifications);
		return this;
	}

	public LatexTabular addRow(LatexRow row)
	{
		this.rows.add(row);
		return this;
	}

	public LatexTabular addRows(List<LatexRow> rows)
	{
		this.rows.addAll(rows);
		return this;
	}

	@Override
	protected Iterable<LatexRow> getContents()
	{
		return rows;
	}
}
