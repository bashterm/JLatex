package jlatex.samples;

import jlatex.LatexDocument;
import jlatex.content.LatexText;
import jlatex.organization.LatexParagraph;
import jlatex.util.LatexPackage;
import jlatex.util.LatexPreamble;

public class SimpleDocument
{
	public static void main(String[] args)
	{
		// Build a usepackage
		LatexPackage inputenc = new LatexPackage()
				.addOption("utf8")
				.name("inputenc");
		
		// Built the title content
		LatexText title = new LatexText()
				.content("The title");
		
		// Build the author content
		LatexText author = new LatexText()
				.content("Author");
		
		// Build the preamble
		LatexPreamble preamble = new LatexPreamble()
				.className("report")
				.addTitleContent(title)
				.addAuthorContent(author)
				.addPackage(inputenc);
		
		// Build the first paragraph content
		LatexText paragraphContent = new LatexText()
				.content("This is a sample document");
		
		// Build the first paragraph
		LatexParagraph paragraph = new LatexParagraph()
				.addContent(paragraphContent);
		
		// Build the document
		LatexDocument document = new LatexDocument()
				.preamble(preamble)
				.addContent(paragraph);
		
		// Print the document
		System.out.println(document.write());
	}
}
