package jcube;


import static org.junit.Assert.*;
import jcube.Faces;

import org.junit.Before;
import org.junit.Test;


public class FacesWithGitCheat {

	private Faces faces;
	
	@Before
	public void createFacesWithFileGitCheatTxt() {
		this.faces = Faces.loadFile("templates/git-cheat.txt");
	}

	@Test
	public void facesSizeShouldBeFive() {
		assertEquals(5, (int)this.faces.size());
	}

	
	@Test
	public void firstFaceTitleShouldBeCreateAndClone() {
		assertEquals("Create & clone", this.faces.at(0).title());
	}
}
