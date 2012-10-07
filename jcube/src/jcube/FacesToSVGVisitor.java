package jcube;

import javax.xml.xpath.XPathExpressionException;

import org.w3c.dom.Element;

public class FacesToSVGVisitor implements IFacesVisitor {
	public Faces faces;
	public XMLDocument doc;

	public FacesToSVGVisitor(XMLDocument doc, Faces faces) {
		this.faces = faces;
		this.doc = doc;
	}
	
	@Override
	public void visitFace(Face face, Integer faceNumber) throws XPathExpressionException {
		Element blocNode = this.doc
				.getFirstNodeFromXPath("//tspan[contains(text(), \"$BLOCK"
						+ faceNumber.toString() + "\")]");
		blocNode.setTextContent(this.faces.at(faceNumber - 1).getTitle());

		Element templateNode = this.doc
				.getFirstNodeFromXPath("//text[contains(text(), \"$text"
						+ faceNumber.toString() + "\")]");
		Element faceNode = (Element) templateNode.getParentNode();
		faceNode.removeChild(templateNode);
		Float y = Float.parseFloat(templateNode.getAttribute("y"));

		for(Cheat cheat: face) {
			this.visitCheat(cheat, this.doc, faceNumber, templateNode, faceNode, y);
			y = y+10;
		}
	}

	
	protected void visitCheat(Cheat cheat, XMLDocument doc, Integer i,
			Element templateNode, Element faceNode, Float y) {

		Element cheatNode = (Element) templateNode.cloneNode(false);
		faceNode.appendChild(cheatNode);
		cheatNode.setAttribute("y", y.toString());

		Element title = doc.createElement("tspan");
		title.setAttribute("style", "font-weight: bold");
		cheatNode.appendChild(title);

		Element content = doc.createElement("tspan");
		cheatNode.appendChild(content);
		
		cheat.acceptVisitor(new CheatToSVGVistor(title, content));
	}
}