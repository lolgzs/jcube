package jcube;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CheatCloseWindowsTest {
	private Cheat cheat;
	
	@Before
	public void createCloseWindowsCheat() {
		this.cheat = new Cheat("Close Windows", "Open Start Menu");
	}

	@Test
	public void shouldNotEqualsOpenWindows() {
		assertFalse(this.cheat.equals(new Cheat("Open Windows", "Never do that")));
	}

}
