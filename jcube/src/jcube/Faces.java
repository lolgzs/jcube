package jcube; 

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Faces {
	private ArrayList<Face> faces = new ArrayList<Face>();

	public static Faces loadFile(String filename) throws IOException {
		return new Faces().load(filename);
	}


	
	public Faces load(String filename) throws IOException {
		BufferedReader input = new BufferedReader(new FileReader(new File(filename)));
		String line;
		while ((line = input.readLine()) != null) {
			if (line.startsWith("* ")) {
				this.newFace(line.substring(2));
			}
		}
		input.close();
		return this;
	}

	
	private void newFace(String title) {
		this.faces.add(new Face(title));
	}

	
	public Integer size() {
		return this.faces.size();
	}
	
	public Face at(int i) {
		return this.faces.get(i);
	}

}
