package Brave;

import javax.swing.ImageIcon;

import GUI.RoleGUI;

public class RoleBuilderC extends BraveBuilder {
	@Override
	public void buildBody() {
		// TODO Auto-generated method stub
		brave.bSex="ÄÐ";
		RoleGUI.jl.setIcon(new ImageIcon(RoleGUI.class.getResource("/image/boy2.jpg")));
	}
	@Override
	public void buildCustume() {
		// TODO Auto-generated method stub
		brave.bCustume="²¼ÒÂ";
	}
	@Override
	public void buildWeapon() {
		// TODO Auto-generated method stub
		brave.bWeapon="Ä¾½£";
	}

	
}
