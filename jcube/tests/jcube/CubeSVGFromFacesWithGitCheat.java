package jcube;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class CubeSVGFromFacesWithGitCheat {
	private String svg;
	private Document doc;
	
	@Before
	public void generateSVGFromGitCheat() throws IOException, ParserConfigurationException, SAXException, XPathExpressionException, TransformerException {
		Faces faces = Faces.loadFile("templates/git-cheat.txt");
		this.svg = SVGCubeFile.fusion(faces, "templates/emacs-cube.svg").content();
		this.doc =  DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new InputSource(new StringReader(this.svg)));
	}

	@Test
	public void aTagTSpanShouldContainsCreateAndClone() throws XPathExpressionException {
		XPath xpath = XPathFactory.newInstance().newXPath();
		XPathExpression expr = xpath.compile("//tspan[contains(text(), \"Create & clone\")]");
		NodeList nodes = (NodeList)expr.evaluate(this.doc, XPathConstants.NODESET);
		assertEquals(1, nodes.getLength());
	}
}
