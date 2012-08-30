package jcube;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FacesTxtFile {
	private String filename;
	private String currentCheatTitle;

	public FacesTxtFile(String filename) {
		this.filename = filename;
	}

	public Faces populate(Faces faces) throws IOException {
		BufferedReader input = new BufferedReader(new FileReader(new File(
				this.filename)));

		try {
			this.populate(faces, input);
		} finally {
			input.close();
		}
		return faces;
	}

	private void populate(Faces faces, BufferedReader input) throws IOException {
		String line;
		while ((line = input.readLine()) != null) {
			this.parseLine(line, faces);
		}
	}

	private void parseLine(String line, Faces faces) {
		if (line.startsWith("* ")) {
			faces.newFace(line.substring(2));
		}

		if (line.startsWith("** ")) {
			this.currentCheatTitle = line.substring(3);
		}

		if (line.startsWith("*** ")) {
			faces.newCheat(this.currentCheatTitle, line.substring(4));
		}
	}

}
