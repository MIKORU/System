package Equipment;

import GUI.MainGUI;

public class addPoison implements SpeciallyAdd {
	@Override
	public void Wear(String equiptype) {
		// TODO Auto-generated method stub
		MainGUI.jta.append("获得了"+"淬毒的"+equiptype+"!\n");
	}

}
