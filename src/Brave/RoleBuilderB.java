package Brave;

import javax.swing.ImageIcon;

import GUI.RoleGUI;

public class RoleBuilderB extends BraveBuilder {
	@Override
	public void buildBody() {
		// TODO Auto-generated method stub
		brave.bSex="��";
		RoleGUI.jl.setIcon(new ImageIcon(RoleGUI.class.getResource("/image/boy1.jpg")));
	}
	@Override
	public void buildCustume() {
		// TODO Auto-generated method stub
		brave.bCustume="Ƥ��";
	}
	@Override
	public void buildWeapon() {
		// TODO Auto-generated method stub
		brave.bWeapon="��";
	}


}
