package jcube;

import static org.junit.Assert.*;

import java.io.IOException;

import jcube.Faces;

import org.junit.Before;
import org.junit.Test;

public class FacesWithGitCheat {

	private Faces faces;

	@Before
	public void createFacesWithFileGitCheatTxt() throws IOException {
		this.faces = Faces.loadFile("templates/git-cheat.txt");
	}

	@Test
	public void facesSizeShouldBeFive() {
		assertEquals(5, (int) this.faces.size());
	}

	
	@Test
	public void firstFaceShouldEqualsAnotheFaceWithSameCheats() {
		Face face = new Face("Create & clone")
			.newCheat("git init", "create new repository")
			.newCheat("git clone /path/to/repo", "clone local repository")
			.newCheat("git clone username@host:/path/to/repo", "clone remote repo");
		
		assertEquals(face, this.faces.at(0));
	}
	
	@Test
	public void firstFaceShouldNotEqualsAnotheFaceWithOtherTitle() {
		Face face = new Face("Create")
			.newCheat("git init", "create new repository")
			.newCheat("git clone /path/to/repo", "clone local repository")
			.newCheat("git clone username@host:/path/to/repo", "clone remote repo");

		assertFalse(face.equals(this.faces.at(0)));
	}
	
	@Test
	public void firstFaceNotShouldEqualsAnotheFaceWithNotSameNumberOfCheats() {
		Face face = new Face("Create & clone")
			.newCheat("git init", "create new repository");
		assertFalse(face.equals(this.faces.at(0)));
	}
	
	@Test
	public void firstFaceShouldNotEqualsAnotheFaceWithOtherCheatsAndSameSize() {
		Face face = new Face("Create & clone")
			.newCheat("git init", "create old repository")
			.newCheat("git clone /path/to/repo", "clone local repository")
			.newCheat("git clone username@host:/path/to/repo", "clone remote repo");

		assertFalse(face.equals(this.faces.at(0)));
	}
	
	@Test
	public void secondFaceTitleShouldBeAddAndRemove() {
		assertEquals("Add & remove", this.faces.at(1).getTitle());
	}	
}
