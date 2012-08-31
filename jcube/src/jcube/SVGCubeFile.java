package jcube;

import java.io.IOException;
import java.io.StringWriter;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class SVGCubeFile {
	private String xmlFilePath;

	public String fusion(String cheatFilePath, String svgFilePath) throws IOException, XPathExpressionException, SAXException, ParserConfigurationException, TransformerException {
		Faces faces = Faces.loadFile(cheatFilePath);
		this.xmlFilePath = svgFilePath;
		return this.content();
	}

	public String content() throws SAXException, IOException, ParserConfigurationException, XPathExpressionException, TransformerException {
		Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(this.xmlFilePath);
		XPath xpath = XPathFactory.newInstance().newXPath();
		XPathExpression expr = xpath.compile("//tspan[contains(text(), \"BLOCK1\")]");
		NodeList nodes = (NodeList)expr.evaluate(doc, XPathConstants.NODESET);
		nodes.item(0).setTextContent("Create & clone");
		
		Transformer transformer = TransformerFactory.newInstance().newTransformer();
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");

		StreamResult result = new StreamResult(new StringWriter());
		DOMSource source = new DOMSource(doc);
		transformer.transform(source, result);
		
		String output = result.getWriter().toString();
		return output;
	}



}
