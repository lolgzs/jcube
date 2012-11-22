package jcube;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ExempleLectureFichier {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(new File("templates/git-cheat.txt")));

		String line;
		while ((line = reader.readLine()) != null) 
			System.out.println(line);
		reader.close();
	}
}
