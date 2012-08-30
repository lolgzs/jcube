package jcube;

import java.util.ArrayList;

public class Face {
	private String title;
	private ArrayList<Cheat> cheats = new ArrayList<Cheat>();

	public Face(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title; 
	}

	public void newCheat(String title, String content) {
		this.cheats.add(new Cheat(title, content));
	}

	public boolean contains(Cheat cheat) {
		return this.cheats.contains(cheat);
	}

	public int indexOf(Cheat cheat) {
		return this.cheats.indexOf(cheat);
	}

}
