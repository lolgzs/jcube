package jcube;

import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.xpath.XPathExpressionException;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class SVGCubeFile {
	public String fusion(String cheatFilePath, String svgFilePath) throws IOException, XPathExpressionException, SAXException, ParserConfigurationException, TransformerException {
		Faces faces = Faces.loadFile(cheatFilePath);
		XMLDocument doc = (new XMLDocument()).loadXMLFile(svgFilePath);
		return this.fusion(faces, doc);
	}

	public String fusion(Faces faces, XMLDocument doc) throws SAXException, IOException, ParserConfigurationException, XPathExpressionException, TransformerException {
		NodeList nodes = doc.nodesFromXPath("//tspan[contains(text(), \"BLOCK\")]");
		
		for(int i=0; i < faces.size(); i++)
			nodes.item(i).setTextContent(faces.at(i).getTitle());
		
		return doc.asXMLString();
	}
}
