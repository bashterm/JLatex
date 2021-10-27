package jlatex.table;

import static org.junit.jupiter.api.Assertions.*;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import jlatex.content.LatexText;

class LatexContentRowTest
{
	private static LatexContentRow row1;
	private static LatexContentRow row2;
	private static LatexContentRow row3;

	@BeforeAll
	static void setup()
	{
		row1 = new LatexContentRow();

		row2 = new LatexContentRow().addColumn(new LatexColumn()
				.addContent(new LatexText().content("TheText")));

		row3 = new LatexContentRow().addColumn(new LatexColumn()
				.addContent(new LatexText().content("TheText")))
				.addColumn(new LatexColumn().addContent(new LatexText().content("TheNextText")));
	}

	@Test
	void testWrite()
	{
		StringWriter sw = new StringWriter();
		PrintWriter writer = new PrintWriter(sw);

		row1.write(writer);

		assertEquals("\\\\", sw.toString().trim());

		sw = new StringWriter();
		writer = new PrintWriter(sw);

		row2.write(writer);

		assertEquals("TheText \\\\", sw.toString().trim());

		sw = new StringWriter();
		writer = new PrintWriter(sw);

		row3.write(writer);

		assertEquals("TheText & TheNextText \\\\", sw.toString().trim());
	}

	@Test
	void testGetColumns()
	{
		assertEquals(0, row1.getColumns().size());
		assertEquals(1, row2.getColumns().size());
		assertEquals("TheText", ((LatexText) row2.getColumns().get(0).getContents().get(0)).getContent());
		assertEquals(2, row3.getColumns().size());
		assertEquals("TheText", ((LatexText) row3.getColumns().get(0).getContents().get(0)).getContent());
		assertEquals("TheNextText", ((LatexText) row3.getColumns().get(1).getContents().get(0)).getContent());
	}
}
