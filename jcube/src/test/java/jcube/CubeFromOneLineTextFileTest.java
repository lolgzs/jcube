package jcube;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

public class CubeFromOneLineTextFileTest {	
	@Test
	public void cubeShouldBeOneFaceWithCommentSortirDuCoursPlusTot() throws IOException {
		Cube expectedCube = (new Cube())
				.addFace("Comment sortir du cours plus t™t");
		
		Cube actualCube = Cube.fromTextFile("templates/one-line-cube.txt");		
		assertEquals(expectedCube, actualCube);
	}
}
