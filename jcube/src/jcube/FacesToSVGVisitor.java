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

		Element templateNode = this.doc
				.getFirstNodeFromXPath("//text[contains(text(), \"$text"
						+ faceNumber.toString() + "\")]");
		Element faceNode = (Element) templateNode.getParentNode();
		
		face.acceptVisitor(new FaceToSVGVisitor(doc, blocNode, templateNode));

		faceNode.removeChild(templateNode);
	}
}