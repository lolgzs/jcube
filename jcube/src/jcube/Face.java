package jcube;

import java.util.ArrayList;

public class Face {

	private String title;
	private ArrayList<Cheat> cheats = new ArrayList<Cheat>();

	public Face(String title) {
		this.title = title;
	}

	public String title() {
		return title; 
	}

	public Cheat cheatAt(int i) {
		return this.cheats.get(i);
	}

	public void newCheat(String title) {
		this.cheats .add(new Cheat(title));
	}

	public Cheat lastCheat() {
		return this.cheats.get(this.cheats.size() - 1);
	}

}
