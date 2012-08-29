package jcube;

import static org.junit.Assert.*;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class CubeSVGFromFacesWithGitCheat {
	private String svg;
	
	@Before
	public void generateSVGFromGitCheat() throws IOException {
		Faces faces = Faces.loadFile("templates/git-cheat.txt");
		this.svg = SVGCubeFile.fusion(faces, "templates/emacs-cube.svg").content();
	}

	@Test
	public void svgShouldBeAnXMLFile() throws ParserConfigurationException, SAXException, IOException {
		DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = domFactory.newDocumentBuilder();
		builder.parse(this.svg);
	}
	
	@Test
	public void aTagTSpanShouldContainsBLOCK1() throws SAXException, IOException, ParserConfigurationException, XPathExpressionException {
		Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(this.svg);
		XPath xpath = XPathFactory.newInstance().newXPath();
		XPathExpression expr = xpath.compile("//tspan[contains(text(), \"BLOCK1\")]");
		NodeList nodes = (NodeList)expr.evaluate(doc, XPathConstants.NODESET);
		assertEquals(1, nodes.getLength());
	}
}
