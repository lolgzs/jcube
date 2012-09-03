package jcube;

import org.w3c.dom.Element;

public class Cheat {
	private final String title;
	private final String content;

	public Cheat(String title, String content) {
		this.title = title;
		this.content = content;
	}

	
	public boolean equals(Object other) {
		Cheat cheat = (Cheat) other;
		return this.title.equals(cheat.title) && this.content.equals(cheat.content);
		
	}


	public void renderOnNodes(Element titleNode, Element contentNode) {
		titleNode.setTextContent(this.title);
		contentNode.setTextContent(this.content);
	}
}
