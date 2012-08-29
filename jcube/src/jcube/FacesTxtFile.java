package jcube;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FacesTxtFile {
	private String filename;

	public FacesTxtFile(String filename) {
		this.filename = filename;
	}

	public Faces populate(Faces faces) throws IOException {
		BufferedReader input = new BufferedReader(new FileReader(new File(
				this.filename)));
		String line;
		while ((line = input.readLine()) != null) {
			this.parseLine(line, faces);
		}
		input.close();
		return faces;
	}

	private void parseLine(String line, Faces faces) {
		if (line.startsWith("* ")) {
			faces.newFace(line.substring(2));
		}
		
		if (line.startsWith("** ")) {
			faces.last().newCheat(line.substring(3));
		}
		
		if (line.startsWith("*** ")) {
			faces.last().lastCheat().content(line.substring(4));
		}
	}

}
