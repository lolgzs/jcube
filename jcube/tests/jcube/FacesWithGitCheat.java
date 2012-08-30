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
	public void firstFaceTitleShouldBeCreateAndClone() {
		assertEquals("Create & clone", this.faces.at(0).getTitle());
	}
	
	@Test
	public void firstFaceShouldContainsCheatGitInit() {
		assertTrue(this.faces.at(0).contains(new Cheat("git init", "create new repository")));
	}
	
	@Test
	public void firstFaceIndexOfCheatGitInitShouldBeZero() {
		assertEquals(0, this.faces.at(0).indexOf(new Cheat("git init", "create new repository")));
	}
	
	@Test
	public void firstFaceShouldNotContainsCheatSVNCheckOut() {
		assertFalse(this.faces.at(0).contains(new Cheat("svn co", "create new repository")));
	}

	@Test
	public void secondFaceTitleShouldBeAddAndRemove() {
		assertEquals("Add & remove", this.faces.at(1).getTitle());
	}
	
	@Test
	public void indexOfGitAddStarInSecondFaceShouldBeOne() {
		assertEquals(1, 
				     this.faces.at(1).indexOf(new Cheat("git add *", "add all changes to index")));	
	}
}
