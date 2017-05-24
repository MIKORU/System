package Equipment;

import GUI.MainGUI;
public class addMoreAttack implements SpeciallyAdd {
	@Override
	public void Wear(String equiptype) {
		// TODO Auto-generated method stub
		MainGUI.jta.append("获得了"+"加攻击力的"+equiptype+"!\n");
	}

}
