package jcube;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Cube {
	private String faceOne;

	public static Cube fromTextFile(String filepath) throws IOException {
		Cube cube = new Cube();
		return cube.loadFromFile(filepath);
	}

	private Cube loadFromFile(String filePath) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(new File(filePath)));
		this.addFace(reader.readLine().substring(2));
		reader.close();
		return this;
	}


	public Cube addFace(String string) {
		this.faceOne = string;
		return this;
	}
	
	public boolean equals(Object other) {
		Cube otherCube = (Cube)other;
		return this.faceOne.equals(otherCube.faceOne);
	}

}
