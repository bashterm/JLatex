package jlatex;

import static org.junit.jupiter.api.Assertions.*;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.junit.jupiter.api.Test;

import jlatex.content.LatexText;
import jlatex.reference.LatexCaption;

class LatexCaptionTest
{
	@Test
	void testLongTet()
	{
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		
		new LatexCaption()
			.addLongTextContent(new LatexText().content("foo"))
			.write(pw);
		
		assertEquals("\\caption{foo}", sw.toString());
	}
}
