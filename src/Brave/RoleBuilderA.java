package Brave;

import javax.swing.ImageIcon;

import GUI.RoleGUI;

public class RoleBuilderA extends BraveBuilder {
	@Override
	public void buildBody() {
		// TODO Auto-generated method stub
		brave.bSex="Å®";
		RoleGUI.jl.setIcon(new ImageIcon(RoleGUI.class.getResource("/image/girl.jpg")));
	}
	@Override
	public void buildCustume() {
		// TODO Auto-generated method stub
		brave.bCustume="²¼ÒÂ";
	}
	@Override
	public void buildWeapon() {
		// TODO Auto-generated method stub
		brave.bWeapon="Ë«½£";
	}

	
}
