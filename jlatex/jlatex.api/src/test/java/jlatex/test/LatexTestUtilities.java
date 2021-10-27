package jlatex.test;

import java.io.PrintWriter;
import java.io.StringWriter;

import jlatex.util.LatexContent;

public class LatexTestUtilities
{
	public static String renderLatexContent(LatexContent content) {
		
		StringWriter sw = new StringWriter();
		
		PrintWriter pw = new PrintWriter(sw);
		
		content.write(pw);
		
		return sw.toString();
	}
}
