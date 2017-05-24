package Equipment;

import GUI.MainGUI;

public class addMoreDefence implements SpeciallyAdd {
	@Override
	public void Wear(String equiptype) {
		// TODO Auto-generated method stub
		MainGUI.jta.append("获得了"+"加防御力的"+equiptype+"!\n");
	}

}
