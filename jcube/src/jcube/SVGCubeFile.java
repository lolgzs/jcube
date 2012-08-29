package jcube;

public class SVGCubeFile {
	private String xml;
	
	public static SVGCubeFile fusion(Faces faces, String xml) {
		return new SVGCubeFile(faces, xml);
	}
	
	public SVGCubeFile(Faces faces, String xml) {
		this.xml = xml;
	}


	public String content() {
		return this.xml;
	}

}
