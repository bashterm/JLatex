package jlatex.samples;

import jlatex.LatexDocument;
import jlatex.content.LatexInteger;
import jlatex.content.LatexText;
import jlatex.organization.LatexParagraph;
import jlatex.table.LatexColumn;
import jlatex.table.LatexColumnAlignment;
import jlatex.table.LatexColumnLine;
import jlatex.table.LatexColumnSpecification;
import jlatex.table.LatexContentRow;
import jlatex.table.LatexHline;
import jlatex.table.LatexTable;
import jlatex.util.LatexPackage;
import jlatex.util.LatexPreamble;

public class DocumentWithTable
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

		// Build the table
		LatexTable table = new LatexTable()
				.addCaptionLongTextContent(new LatexText().content("The caption"))
				.label("tab:sample");
		
		table.getTabular()
			.addColumnSpecification(new LatexColumnSpecification().before(LatexColumnLine.SINGLE).after(LatexColumnLine.SINGLE))
			.addColumnSpecification(new LatexColumnSpecification().after(LatexColumnLine.SINGLE).alignment(LatexColumnAlignment.CENTERED))
			.addRow(new LatexHline())
			.addRow(new LatexContentRow().addColumn(new LatexColumn().addContent(new LatexText().content("One")))
					.addColumn(new LatexColumn().addContent(new LatexInteger().value(1))))
			.addRow(new LatexContentRow().addColumn(new LatexColumn().addContent(new LatexText().content("Two")))
					.addColumn(new LatexColumn().addContent(new LatexInteger().value(2))))
			.addRow(new LatexHline());
		
		// Build the document
		LatexDocument document = new LatexDocument()
				.preamble(preamble)
				.addContent(paragraph)
				.addContent(table);
		
		// Print the document
		System.out.println(document.write());
	}
}
