package jcube;

public class Face {
	private String title;
	private Cheats cheats = new Cheats();

	public Face(String title) {
		this.title = title;
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

	public void acceptVisitor(IFaceVisitor faceToSVGVisitor) {
		faceToSVGVisitor.visitTitle(this.title);
		this.cheats.acceptVisitor(faceToSVGVisitor);
	}
}
