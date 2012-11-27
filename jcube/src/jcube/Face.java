package jcube;

import java.util.ArrayList;

public class Face {
	private String title;
	private ArrayList<Cheat> cheats = new ArrayList<Cheat>();

	public Face(String title) {
		this.title = title;
	}

	public void newCheat(String title, String description) {
		this.cheats.add(new Cheat(title, description));
	}
	
	
	public boolean equals(Object other) {
		Face otherFace = (Face)other;
		return this.title.equals(otherFace.title) && 
				this.cheats.equals(otherFace.cheats);
	}

	public void writeOn(IFaceWriter faceWriter) {
		faceWriter.writeTitle(this.title);
	}

}
