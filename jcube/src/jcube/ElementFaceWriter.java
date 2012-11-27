package jcube;

import org.w3c.dom.Element;

public class ElementFaceWriter implements IFaceWriter {

	private Element element;

	public ElementFaceWriter(Element element) {
		this.element = element;
	}

	@Override
	public void writeTitle(String title) {
		this.element.setTextContent(title);
	}

}
