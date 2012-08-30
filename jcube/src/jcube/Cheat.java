package jcube;

public class Cheat {
	private final String title;
	private final String content;

	public Cheat(String title, String content) {
		this.title = title;
		this.content = content;
	}

	
	public boolean equals(Object other) {
		Cheat cheat = (Cheat) other;
		return this.title.equals(cheat.title) && this.content.equals(cheat.content);
		
	}
}
