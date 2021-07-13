package jlatex.table;

import java.util.ArrayList;
import java.util.List;

import jlatex.command.LatexSimpleCommand;
import jlatex.command.LatexSquareBracketCommandParameter;
import jlatex.content.LatexNewLine;
import jlatex.content.LatexText;
import jlatex.reference.LatexCaption;
import jlatex.reference.LatexLabel;
import jlatex.util.LatexBlock;
import jlatex.util.LatexContent;

public class LatexTable extends LatexBlock<LatexTable, LatexContent>
{
	private LatexText tableModifiers = new LatexText();

	private LatexSquareBracketCommandParameter tableModifiersParameter = new LatexSquareBracketCommandParameter(tableModifiers);

	private boolean centering = false;
	private boolean captionTop = false;

	private LatexCaption caption = new LatexCaption();
	private LatexLabel label = new LatexLabel();
	private LatexTabular tabular = new LatexTabular();

	public LatexTable()
	{
		super("table");
		addBeginParameter(tableModifiersParameter);
	}

	public LatexTable centering(boolean enable)
	{
		this.centering = enable;
		return this;
	}

	public LatexTabular getTabular()
	{
		return tabular;
	}

	public LatexCaption getCaption()
	{
		return caption;
	}

	public void setCaptionShortText(String caption)
	{
		this.caption.setShortText(caption);
	}

	public LatexTable captionShortText(String caption)
	{
		setCaptionShortText(caption);
		return this;
	}

	public LatexTable addCaptionLongTextContent(LatexContent content)
	{
		this.caption.addLongTextContent(content);
		return this;
	}
	//
	// public LatexCellPosition getPosition()
	// {
	// return positionModifiers.getEnumValue();
	// }
	//
	// public void setPosition(LatexCellPosition position)
	// {
	// this.positionModifiers.setValue(position);
	// }
	//
	// public LatexTable position(LatexCellPosition position)
	// {
	// this.positionModifiers.setValue(position);
	// return this;
	// }

	public String getTableModifiers()
	{
		return tableModifiers.getContent();
	}

	public void setTableModifiers(String tableModifiers)
	{
		this.tableModifiers.setContent(tableModifiers);
	}

	public LatexTable tableModifiers(String tableModifiers)
	{
		this.tableModifiers.setContent(tableModifiers);
		return this;
	}

	public String getLabel()
	{
		return label.getLabel();
	}

	public void setLabel(String label)
	{
		this.label.setLabel(label);
	}

	public LatexTable label(String label)
	{
		setLabel(label);
		return this;
	}

	@Override
	protected Iterable<LatexContent> getContents()
	{
		List<LatexContent> contents = new ArrayList<>();

		if (centering)
		{
			contents.add(new LatexSimpleCommand("centering"));
			contents.add(new LatexNewLine());
		}

		if (captionTop)
		{
			contents.add(caption);
			contents.add(new LatexNewLine());
		}

		contents.add(tabular);

		if (!captionTop)
		{
			contents.add(caption);
			contents.add(new LatexNewLine());
		}

		contents.add(label);
		contents.add(new LatexNewLine());

		return contents;
	}
}
