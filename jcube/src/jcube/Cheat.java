package jcube;

public class Cheat {

	private String title;
	private String content;

	public Cheat(String title) {
		this.title = title;
	}

	public String title() {
		return this.title;
	}

	public String content() {
		return this.content;
	}

	public void content(String content) {
		this.content = content;		
	}

}
