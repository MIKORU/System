package Equipment;

import GUI.MainGUI;

public class addPoison implements SpeciallyAdd {
	@Override
	public void Wear(String equiptype) {
		// TODO Auto-generated method stub
		MainGUI.jta.append("�����"+"�㶾��"+equiptype+"!\n");
	}

}
