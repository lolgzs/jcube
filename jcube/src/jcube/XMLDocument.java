package jcube;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class XMLDocument {
	private Document doc;

	public XMLDocument loadXMLString(String xml) throws SAXException,
			IOException, ParserConfigurationException {
		this.doc = this.newDocumentBuilder().parse(
				new InputSource(new StringReader(xml)));
		return this;
	}

	public XMLDocument loadXMLFile(String filepath) throws SAXException,
			IOException, ParserConfigurationException {
		this.doc = this.newDocumentBuilder().parse(filepath);
		return this;
	}

	public NodeList nodesFromXPath(String xpathQuery)
			throws XPathExpressionException {
		return (NodeList) this.newXPathExpression(xpathQuery).evaluate(
				this.doc, XPathConstants.NODESET);
	}

	public boolean match(String xpathQuery) throws XPathExpressionException {
		return (this.nodesFromXPath(xpathQuery).getLength() > 0);
	}

	public String asXMLString() throws TransformerFactoryConfigurationError,
			TransformerException {
		StringWriter writer = new StringWriter();
		this.writeDocXMLOn(writer);
		return writer.toString();
	}
	
	public Element createElement(String name) {
		return this.doc.createElement(name);
	}

	public void writeDocXMLOn(StringWriter writer) throws TransformerException,
			TransformerConfigurationException,
			TransformerFactoryConfigurationError {
		StreamResult result = new StreamResult(writer);
		this.newTransformer().transform(new DOMSource(this.doc), result);
	}

	public Transformer newTransformer()
			throws TransformerConfigurationException,
			TransformerFactoryConfigurationError {
		Transformer transformer = TransformerFactory.newInstance()
				.newTransformer();
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		return transformer;
	}

	public DocumentBuilder newDocumentBuilder()
			throws ParserConfigurationException {
		return DocumentBuilderFactory.newInstance().newDocumentBuilder();
	}

	public XPathExpression newXPathExpression(String xpathQuery)
			throws XPathExpressionException {
		return newXPath().compile(xpathQuery);
	}

	public XPath newXPath() {
		return XPathFactory.newInstance().newXPath();
	}

}
