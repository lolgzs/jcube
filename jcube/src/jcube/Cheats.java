package jcube;

import java.util.ArrayList;
import java.util.Iterator;

public class Cheats {
	

	private ArrayList<Cheat> cheats = new ArrayList<Cheat>();

	public Iterator<Cheat> iterator() {
		return this.cheats .iterator();
	}

	public void add(Cheat cheat) {
		this.cheats.add(cheat);		
	}
	
	@Override
	public boolean equals(Object other) {
		Cheats otherCheats = (Cheats)other;
		if (otherCheats.cheats.size() != this.cheats.size())
			return false;
		
		for(int i=0; i<this.cheats.size(); i++) {
			if (! this.cheats.get(i).equals(otherCheats.cheats.get(i)))
				return false;
		}
			
		return true;
	}

}
