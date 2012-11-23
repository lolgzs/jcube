package jcube;

import static org.junit.Assert.*;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.xpath.XPathExpressionException;

import org.junit.Test;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class ReplaceCubeSVGBlock1ToMesAstucesTest {

	@Test
	public void replaceNodeContentShouldBeMesAstuces() throws SAXException, IOException, ParserConfigurationException, TransformerFactoryConfigurationError, TransformerException, XPathExpressionException {
		XMLDocument cubeSVG = (new XMLDocument()).loadXMLFile("templates/cube.svg");
		Element blocNode = cubeSVG.getFirstNodeFromXPath("//tspan[contains(text(), \"$BLOCK1\")]");
		blocNode.setTextContent("Mes astuces");
		
		XMLDocument  readCubeSVG = (new XMLDocument()).loadXMLString(cubeSVG.asXMLString());
		assertTrue(readCubeSVG.match("//tspan[contains(text(), \"Mes astuces\")]"));
	}
}
