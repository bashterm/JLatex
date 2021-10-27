*This is a work in progress and a fork of the original code.*

# JLaTeX
A Java Library that allows interfacing with the LaTeX document preparation system. Please note that this library __does not__ handle compilation. It only provides an interface for generating LaTeX code.

In order to create a document, at bare minimum, the following is necessary:

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
	

There are more samples in the __jlatex.samples__ module.