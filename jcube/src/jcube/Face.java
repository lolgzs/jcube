package jcube;

import java.util.ArrayList;
import java.util.Iterator;

public class Face implements Iterable<Cheat> {
	private String title;
	private ArrayList<Cheat> cheats = new ArrayList<Cheat>();

	public Face(String title) {
		this.title = title;
	}
	
	public Iterator<Cheat> iterator() {        
		return cheats.iterator();
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
	
	public int size() {
		return this.cheats.size();
	}

}
