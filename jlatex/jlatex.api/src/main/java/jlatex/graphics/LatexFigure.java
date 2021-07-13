package jlatex.graphics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import jlatex.command.LatexCurlyBraceCommandParameter;
import jlatex.command.LatexSimpleCommand;
import jlatex.command.LatexSquareBracketCommandParameter;
import jlatex.content.LatexText;
import jlatex.layout.page.LatexCentering;
import jlatex.reference.LatexCaption;
import jlatex.reference.LatexLabel;
import jlatex.util.LatexBlock;
import jlatex.util.LatexContent;
import jlatex.util.LatexKeyValueList;
import jlatex.util.LatexKeyValueList.LatexKeyValuePair;
import jlatex.util.LatexPackage;

public class LatexFigure extends LatexBlock<LatexFigure, LatexContent>
{
	private LatexKeyValueList options = new LatexKeyValueList();

	private LatexText size = new LatexText();

	private LatexText imageName = new LatexText();

	private LatexCaption caption;

	private LatexLabel label;

	private boolean center = false;

	private boolean clipImage = false;

	public LatexCaption getCaption()
	{
		return caption;
	}

	public void setCaption(LatexCaption caption)
	{
		this.caption = caption;
	}

	public LatexFigure caption(LatexCaption caption)
	{
		this.setCaption(caption);
		return this;
	}

	public LatexLabel getLabel()
	{
		return label;
	}

	public void setLabel(LatexLabel label)
	{
		this.label = label;
	}

	public LatexFigure label(LatexLabel label)
	{
		this.setLabel(label);
		return this;
	}

	public LatexFigure()
	{
		super("figure");
		addBeginParameter(new LatexSquareBracketCommandParameter(options));
	}

	public boolean isCenter()
	{
		return center;
	}

	public void setCenter(boolean center)
	{
		this.center = center;
	}

	public LatexFigure center(boolean center)
	{
		this.setCenter(center);
		return this;
	}

	public String getImageName()
	{
		return imageName.getContent();
	}

	public void setImageName(String name)
	{
		imageName.setContent(name);
	}

	public LatexFigure imageName(String name)
	{
		imageName.setContent(name);
		return this;
	}

	public String getSize()
	{
		return this.size.getContent();
	}

	public void setSize(String size)
	{
		this.size.setContent(size);
	}

	public LatexFigure size(String size)
	{
		this.size.setContent(size);
		return this;
	}

	public LatexKeyValuePair<?, ?> getOption(String key)
	{
		return this.options.getValue(key);
	}

	public void setOption(LatexKeyValuePair<?, ?> option)
	{
		this.options.setValue(option);
	}

	public LatexFigure option(LatexKeyValuePair<?, ?> option)
	{
		this.setOption(option);
		return this;
	}

	public boolean isClipImage()
	{
		return clipImage;
	}

	public void setClipImage(boolean clipImage)
	{
		this.clipImage = clipImage;
	}

	public LatexFigure clipImage(boolean clipImage)
	{
		this.setClipImage(clipImage);
		return this;
	}

	@Override
	protected Iterable<LatexContent> getContents()
	{
		List<LatexContent> content = new ArrayList<>();

		if (center)
		{
			content.add(new LatexCentering());
		}

		LatexSimpleCommand includeGraphcisCommand = new LatexSimpleCommand("includegraphics")
				.addParameter(new LatexSquareBracketCommandParameter(size))
				.addParameter(new LatexCurlyBraceCommandParameter(imageName));

		content.add(includeGraphcisCommand);

		if (caption != null)
		{
			content.add(caption);
		}

		if (label != null)
		{
			content.add(label);
		}

		return content;
	}

	@Override
	public List<LatexPackage> getRequiredPackages()
	{
		return Arrays.asList(new LatexPackage().name("graphicsx"));
	}
}
