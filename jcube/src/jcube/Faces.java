package jcube; 

public class Faces {

	public static Faces loadFile(String string) {
		return new Faces();
	}

	public Integer size() {
		return 5;
	}

	public Face at(int i) {
		return new Face("Create & clone");
	}

}
