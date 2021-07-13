package jlatex.samples;

import jlatex.LatexDocument;
import jlatex.content.LatexText;
import jlatex.list.LatexEnumerate;
import jlatex.list.LatexItemize;
import jlatex.list.LatexListItem;
import jlatex.organization.LatexParagraph;
import jlatex.util.LatexPackage;
import jlatex.util.LatexPreamble;

public class DocumentWithLists
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
		
		LatexEnumerate enumerate = new LatexEnumerate()
			.addContent(new LatexListItem().addContent(new LatexText().content("First")))
			.addContent(new LatexListItem().addContent(new LatexText().content("Second")))
			.addContent(new LatexListItem().addContent(new LatexText().content("Third")));
		
		LatexItemize itemize = new LatexItemize()
			.addContent(new LatexListItem().addContent(new LatexText().content("A")))
			.addContent(new LatexListItem().addContent(new LatexText().content("B")))
			.addContent(new LatexListItem().addContent(new LatexText().content("C")));
		
		// Build the document
		LatexDocument document = new LatexDocument()
			.preamble(preamble)
			.addContent(paragraph)
			.addContent(enumerate)
			.addContent(itemize);
		
		// Print the document
		System.out.println(document.write());
	}
}
