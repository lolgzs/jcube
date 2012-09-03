package jcube;

import static org.junit.Assert.*;

import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.xpath.XPathExpressionException;
import org.junit.Before;
import org.junit.Test;
import org.xml.sax.SAXException;

public class CubeSVGFromFacesWithGitCheat {
	private XMLDocument doc;
	
	@Before
	public void generateSVGFromGitCheat() throws IOException, ParserConfigurationException, SAXException, XPathExpressionException, TransformerException {
		String svg = (new SVGCubeFile("templates/emacs-cube.svg")).fusion("templates/git-cheat.txt");
		this.doc =  (new XMLDocument()).loadXMLString(svg);
	}

	@Test
	public void aTagTSpanShouldContainsCreateAndClone() throws XPathExpressionException {
		assertTrue(this.doc.match("//tspan[contains(text(), \"Create & clone\")]"));
	}
	
	@Test
	public void aTagTSpanShouldContainsAddAndRemove() throws XPathExpressionException {
		assertTrue(this.doc.match("//tspan[contains(text(), \"Add & remove\")]"));
	}
	
	@Test
	public void aFlowRootShouldContainsGitInitCheat() throws XPathExpressionException {
		assertTrue(this.doc.match("//flowRoot//flowPara//flowSpan[contains(text(), \"git init\")][following-sibling::flowSpan[contains(text(), \"create new repository\")]]"));
	}
	
	@Test
	public void aFlowRootShouldContainsGitPushOriginMaster() throws XPathExpressionException {
		assertTrue(this.doc.match("//flowRoot//flowPara//flowSpan[contains(text(), \"git push origin master\")][following-sibling::flowSpan[contains(text(), \"push changes\")]]"));
	}
	
	@Test
	public void flowRootShouldNotContainsText() throws XPathExpressionException {
		assertFalse(this.doc.match("//flowRoot[contains(text(), \"text\")]"));
	}
}
