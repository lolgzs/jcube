package jcube;

import java.io.IOException;
import org.w3c.dom.Element;

public class Cube {
	private Face face;

	public static Cube fromTextFile(String filepath) throws IOException {
		return (new CubeTextFile(filepath)).newCube();
	}

	public Cube addFace(String string) {
		this.newFace(string);
		return this;
	}
	
	public boolean equals(Object other) {
		Cube otherCube = (Cube)other;
		return this.face.equals(otherCube.face);
	}

	public XMLDocument populateSVGFile(String filepath) throws Exception {
		XMLDocument sourceSVG = (new XMLDocument()).loadXMLFile(filepath);
		Element blocOneNode = sourceSVG.getFirstNodeFromXPath("//tspan[contains(text(), '$BLOCK1')]");
			
		IFaceWriter faceWriter = new ElementFaceWriter(blocOneNode);
		this.face.writeOn(faceWriter);
		
		IFaceWriter faceWriter = new JPegFaceWriter("mon.jpeg");
		this.face.writeOn(faceWriter);
		
		return sourceSVG;
	}

	public Face newFace(String title) {
		this.face =  new Face(title);
		return this.face;
	}

}
