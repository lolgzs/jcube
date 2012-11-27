package jcube;

public class Cheat {

	private String title;
	private String description;

	public Cheat(String title, String description) {
		this.title = title;
		this.description = description;
	}

	public boolean equals(Object other) {
		Cheat otherCheat = (Cheat) other;
		return this.title.equals(otherCheat.title) 
				&& this.description.equals(otherCheat.description);
	}
}
