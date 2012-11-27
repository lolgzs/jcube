package jcube;

import static org.junit.Assert.*;

import org.junit.Test;

public class CubeEqualityTest {

	@Test
	public void twoCubeWithOneDifferentFaceShouldNotBeEqual() {
		Cube cubeGit = (new Cube()).addFace("Git");
		Cube cubeSVN = (new Cube()).addFace("SVN");
		assertFalse(cubeGit.equals(cubeSVN));
	}
	
	@Test
	public void twoCubesWithOneFaceAndDifferentCheatsShouldNotBeEqual() {
		Cube cubeGit1 = (new Cube());
		cubeGit1.newFace("Git").newCheat("git clone", "clone repository");
		
		Cube cubeGit2 = (new Cube());
		cubeGit2.newFace("Git").newCheat("git pull", "get and merge latest changes");
		
		
		assertFalse(cubeGit1.equals(cubeGit2));
	}
	
	
	@Test
	public void twoCubesWithOneFaceAndSameCheatsShouldBeEqual() {
		Cube cubeGit1 = (new Cube());
		cubeGit1.newFace("Git").newCheat("git clone", "clone repository");
		
		Cube cubeGit2 = (new Cube());
		cubeGit2.newFace("Git").newCheat("git clone", "clone repository");
		
		
		assertEquals(cubeGit1, cubeGit2);
	}

}
