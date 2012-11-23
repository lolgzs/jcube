package jcube;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class CubeTextFile {
	private String filepath;

	public CubeTextFile(String filepath) {
		this.filepath = filepath;
	}

	public Cube newCube() throws IOException {
		Cube cube = new Cube();
		BufferedReader reader = new BufferedReader(new FileReader(new File(this.filepath)));
		cube.addFace(reader.readLine().substring(2));
		reader.close();
		return cube;
	}

}
