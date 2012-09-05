package jcube;

import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Node;
import javax.xml.transform.TransformerException;
import javax.xml.xpath.XPathExpressionException;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class SVGCubeFile {
	private String filePath;

	public SVGCubeFile(String filePath) {
		this.filePath = filePath;
	}
	
	public String fusion(String cheatFilePath) throws IOException, XPathExpressionException, SAXException, ParserConfigurationException, TransformerException {
		Faces faces = Faces.loadFile(cheatFilePath);
		XMLDocument doc = (new XMLDocument()).loadXMLFile(this.filePath);
		return this.fusion(faces, doc);
	}

	public String fusion(Faces faces, XMLDocument doc) throws SAXException, IOException, ParserConfigurationException, XPathExpressionException, TransformerException {
		NodeList nodes = doc.nodesFromXPath("//tspan[contains(text(), \"$BLOCK\")]");
		
		for(int i=0; i < faces.size(); i++) {
			nodes.item(i).setTextContent(faces.at(i).getTitle());
		}
			
		nodes = doc.nodesFromXPath("//text[contains(text(), \"$text\")]");
		for(Integer i=0; i < faces.size(); i++) {	
			Element templateNode = (Element)nodes.item(i);
			Element faceNode = (Element)templateNode.getParentNode();
			faceNode.removeChild(templateNode);
			Float y = Float.parseFloat(templateNode.getAttribute("y"));
			
			for(Cheat cheat: faces.at(i)) {
				Element cheatNode = (Element)templateNode.cloneNode(false);
				faceNode.appendChild(cheatNode);
				cheatNode.setAttribute("y", y.toString());
				y = y + 10;
				
				Element title = doc.createElement("tspan");
				title.setAttribute("style", "font-weight: bold");
				cheatNode.appendChild(title);
			
				Element content = doc.createElement("tspan");
				cheatNode.appendChild(content);
				
				cheat.renderOnNodes(title, content);
			}
		}
		
		return doc.asXMLString();
	}
}
