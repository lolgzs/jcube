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

	public SVGCubeFile(String filePath) {
		this.filePath = filePath;
	}
	
	public String fusion(String cheatFilePath) throws IOException, XPathExpressionException, SAXException, ParserConfigurationException, TransformerException {
		Faces faces = Faces.loadFile(cheatFilePath);
		XMLDocument doc = (new XMLDocument()).loadXMLFile(this.filePath);
		return this.fusion(faces, doc);
	}

	public String fusion(Faces faces, XMLDocument doc) throws SAXException, IOException, ParserConfigurationException, XPathExpressionException, TransformerException {
		for(Integer i=1; i <= faces.size(); i++) {
			Element blocNode =  (Element)doc.nodesFromXPath("//tspan[contains(text(), \"$BLOCK"+i.toString()+"\")]").item(0);
			blocNode.setTextContent(faces.at(i-1).getTitle());
		
			
			Element templateNode = (Element) doc.nodesFromXPath("//text[contains(text(), \"$text"+i.toString()+"\")]").item(0);
			Element faceNode = (Element)templateNode.getParentNode();
			faceNode.removeChild(templateNode);
			Float y = Float.parseFloat(templateNode.getAttribute("y"));
			
			for(Cheat cheat: faces.at(i-1)) {
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
