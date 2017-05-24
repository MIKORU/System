package Brave;

import User.Brave;

public class BraveDirctor {
	private BraveBuilder bb;
	public void setBraveBuilder(BraveBuilder bb){
		this.bb = bb;
	}
	public Brave construct(){
		bb.buildBody();
		bb.buildWeapon();
		bb.buildCustume();
		return bb.getBrave();
	}
}
