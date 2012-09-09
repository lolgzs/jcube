package jcube;

import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.xpath.XPathExpressionException;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class SVGCubeFile {
	private String filePath;
	private Faces faces;
	private XMLDocument doc;

	public SVGCubeFile(String filePath) {
		this.filePath = filePath;
	}
	
	public String fusion(String cheatFilePath) throws IOException, XPathExpressionException, SAXException, ParserConfigurationException, TransformerException {
		Faces faces = Faces.loadFile(cheatFilePath);
		XMLDocument doc = (new XMLDocument()).loadXMLFile(this.filePath);
		return this.fusion(faces, doc);
	}
	
	
	public String fusion(Faces faces, XMLDocument doc) throws SAXException, IOException, ParserConfigurationException, XPathExpressionException, TransformerException {
		this.faces = faces;
		this.doc = doc;
		faces.acceptVisitor(this);
		
		return doc.asXMLString();
	}
	
	public void visitFace(Face face, Integer i) throws XPathExpressionException {
		Element blocNode = doc
				.getFirstNodeFromXPath("//tspan[contains(text(), \"$BLOCK"
						+ i.toString() + "\")]");
		blocNode.setTextContent(faces.at(i - 1).getTitle());

		Element templateNode = doc
				.getFirstNodeFromXPath("//text[contains(text(), \"$text"
						+ i.toString() + "\")]");
		Element faceNode = (Element) templateNode.getParentNode();
		faceNode.removeChild(templateNode);
		Float y = Float.parseFloat(templateNode.getAttribute("y"));

		for(Cheat cheat: face) {
		  this.visitCheat(cheat, doc, i, templateNode, faceNode, y);
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

		cheat.renderOnNodes(title, content);

	}
}
