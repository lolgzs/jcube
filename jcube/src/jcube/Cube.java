package jcube;

import java.io.IOException;
import org.w3c.dom.Element;

public class Cube {
	private String faceOne;

	public static Cube fromTextFile(String filepath) throws IOException {
		return (new CubeTextFile(filepath)).newCube();
	}

	public Cube addFace(String string) {
		this.faceOne = string;
		return this;
	}
	
	public boolean equals(Object other) {
		Cube otherCube = (Cube)other;
		return this.faceOne.equals(otherCube.faceOne);
	}

	public XMLDocument populateSVGFile(String filepath) throws Exception {
		XMLDocument sourceSVG = (new XMLDocument()).loadXMLFile(filepath);
		Element blocOneNode = sourceSVG.getFirstNodeFromXPath("//tspan[contains(text(), '$BLOCK1')]");
		blocOneNode.setTextContent(this.faceOne);
		return sourceSVG;
	}

}
