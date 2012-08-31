package jcube;

import java.io.IOException;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class XMLDocument {
	private Document doc;
	
	public XMLDocument loadXMLString(String xml) throws SAXException, IOException, ParserConfigurationException {
		 this.doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new InputSource(new StringReader(xml)));
		 return this;
	}

	public NodeList nodesFromXPath(String xpathQuery) throws XPathExpressionException{
		XPath xpath = XPathFactory.newInstance().newXPath();
		XPathExpression expr = xpath.compile(xpathQuery);
		return (NodeList)expr.evaluate(this.doc, XPathConstants.NODESET);
	}

	public boolean match(String xpathQuery) throws XPathExpressionException {
		return (this.nodesFromXPath(xpathQuery).getLength() > 0);
	}

}
