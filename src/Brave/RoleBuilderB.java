package Brave;

import javax.swing.ImageIcon;

import GUI.RoleGUI;

public class RoleBuilderB extends BraveBuilder {
	@Override
	public void buildBody() {
		// TODO Auto-generated method stub
		brave.bSex="ÄÐ";
		RoleGUI.jl.setIcon(new ImageIcon(RoleGUI.class.getResource("/image/boy1.jpg")));
	}
	@Override
	public void buildCustume() {
		// TODO Auto-generated method stub
		brave.bCustume="Æ¤²Ý";
	}
	@Override
	public void buildWeapon() {
		// TODO Auto-generated method stub
		brave.bWeapon="¹­";
	}


}
