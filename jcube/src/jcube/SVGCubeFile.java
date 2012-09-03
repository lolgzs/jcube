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
		NodeList nodes = doc.nodesFromXPath("//tspan[contains(text(), \"BLOCK\")]");
		
		for(int i=0; i < faces.size(); i++) {
			nodes.item(i).setTextContent(faces.at(i).getTitle());
		}
			
		nodes = doc.nodesFromXPath("//flowRoot[contains(text(), \"text\")]");
		for(int i=0; i < faces.size(); i++) {	
			nodes.item(i).removeChild(nodes.item(i).getLastChild());
			for(Cheat cheat: faces.at(i)) {			
				Element cheatNode = doc.createElement("flowPara");
				nodes.item(i).appendChild(cheatNode);
				
				Element title = doc.createElement("flowSpan");
				title.setAttribute("style", "font-weight: bold");
				cheatNode.appendChild(title);
			
				Element content = doc.createElement("flowSpan");
				cheatNode.appendChild(content);
				
				cheat.renderOnNodes(title, content);
			}
		}
		
		return doc.asXMLString();
	}
}
