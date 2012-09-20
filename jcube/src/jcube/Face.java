package jcube;

import java.util.Iterator;

public class Face implements Iterable<Cheat> {
	private String title;
	private Cheats cheats = new Cheats();

	public Face(String title) {
		this.title = title;
	}
	
	public Iterator<Cheat> iterator() {        
		return cheats.iterator();
	}

	public String getTitle() {
		return title; 
	}

	public Face newCheat(String title, String content) {
		this.cheats.add(new Cheat(title, content));
		return this;
	}

	@Override
	public boolean equals(Object other) {
		Face otherFace = (Face)other;
		return this.title.equals(otherFace.title) 
				&& this.cheats.equals(otherFace.cheats);
	}
}
