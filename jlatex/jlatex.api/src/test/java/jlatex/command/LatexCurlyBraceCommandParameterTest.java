package jlatex.command;

import static jlatex.test.LatexTestUtilities.renderLatexContent;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import jlatex.content.LatexText;

class LatexCurlyBraceCommandParameterTest
{
	@Test
	void testSimple()
	{
		LatexText text = new LatexText().content("test");
		
		LatexCurlyBraceCommandParameter param = new LatexCurlyBraceCommandParameter(text);
		
		String rendered = renderLatexContent(param);
		
		assertEquals("{test}", rendered);
	}
	
	@Test
	void testOptionalWithText()
	{
		LatexText text = new LatexText().content("test");
		
		LatexCurlyBraceCommandParameter param = new LatexCurlyBraceCommandParameter(text).optional(true);
		
		String rendered = renderLatexContent(param);
		
		assertEquals("{test}", rendered);
	}
	
	@Test
	void testOptionalWithoutText()
	{
		LatexText text = new LatexText();
		
		LatexCurlyBraceCommandParameter param = new LatexCurlyBraceCommandParameter(text).optional(true);
		
		String rendered = renderLatexContent(param);
		
		assertEquals("", rendered);
	}
}
