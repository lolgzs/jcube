package jcube;

import java.io.IOException;
import java.util.ArrayList;

public class Faces {
	private ArrayList<Face> faces = new ArrayList<Face>();

	public static Faces loadFile(String filename) throws IOException {
		return new FacesTxtFile(filename).populate(new Faces());
	}

	public void newFace(String title) {
		this.faces.add(new Face(title));
	}

	public Integer size() {
		return this.faces.size();
	}

	public Face at(int i) {
		return this.faces.get(i);
	}

}
