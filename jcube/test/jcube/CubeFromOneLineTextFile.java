package jcube;

import static org.junit.Assert.*;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import org.junit.Before;
import org.junit.Test;
import org.xml.sax.SAXException;

public class CubeFromOneLineTextFile {	
	private Cube actualCube;

	@Before
	public void loadCubeFromOneLineCubeDotTxt() throws IOException {
		this.actualCube = Cube.fromTextFile("templates/one-line-cube.txt");
	}
	

	@Test
	public void cubeShouldBeOneFaceWithCommentSortirDuCoursPlusTot() throws IOException {
		Cube expectedCube = (new Cube())
				.addFace("Comment sortir du cours plus tot");	
		assertEquals(expectedCube, this.actualCube);
	}
	
	
	@Test
	public void fusionSVGShouldContainsCommentSortirDuCoursPlusTot() throws Exception {
		XMLDocument docSVG = this.actualCube.populateSVGFile("templates/cube.svg");
		assertTrue(docSVG.match("//tspan[contains(text(), 'Comment sortir du cours plus tot')]"));
	}
}
