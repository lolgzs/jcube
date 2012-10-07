package jcube;

import org.w3c.dom.Element;

public class CheatToSVGVistor implements ICheatVisitor {
	private Element title;
	private Element content;

	public CheatToSVGVistor(Element title, Element content) {
		this.title = title;
		this.content = content;
	}

	@Override
	public void visitTitle(String title) {
		this.title.setTextContent(title);
	}

	@Override
	public void visitContent(String content) {
		this.content.setTextContent(content);		
	}

}
