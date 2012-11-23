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

}
