package Equipment;

import GUI.MainGUI;

public class addMoreDefence implements SpeciallyAdd {
	@Override
	public void Wear(String equiptype) {
		// TODO Auto-generated method stub
		MainGUI.jta.append("�����"+"�ӷ�������"+equiptype+"!\n");
	}

}
