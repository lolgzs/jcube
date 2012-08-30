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
		assertEquals("Create & clone", this.faces.at(0).title());
	}
	
	@Test
	public void firstFaceFirstCheatTitleShouldBeGitInit() {
		assertEquals("git init", this.faces.at(0).cheatAt(0).getTitle());
	}
	
	@Test
	public void firstFaceFirstCheatShouldBeCreateNewRepository() {
		assertEquals("create new repository", this.faces.at(0).cheatAt(0).getContent());
	}
	
	@Test 
	public void firstFaceSecondCheatTitleShouldBeGitClonPathToRepo() {
		assertEquals("git clone /path/to/repo", this.faces.at(0).cheatAt(1).getTitle());
	}
	
	@Test
	public void firstFaceSecondCheatShouldBeCloneLocalRepository() {
		assertEquals("clone local repository", this.faces.at(0).cheatAt(1).getContent());
	}

	@Test
	public void secondFaceTitleShouldBeAddAndRemove() {
		assertEquals("Add & remove", this.faces.at(1).title());
	}
	
	@Test 
	public void firstFaceSecondCheatTitleShouldBeGitAddStar() {
		assertEquals("git add *", this.faces.at(1).cheatAt(1).getTitle());
	}
	
	@Test 
	public void firstFaceSecondCheatContentShouldBeGitAddAllChangesToIndex() {
		assertEquals("add all changes to index", this.faces.at(1).cheatAt(1).getContent());
	}
}
