package User;

import GUI.MainGUI;
import Main.Client;

//性别，姓名，HP，MP，攻击值，防御值，金钱
public class NormalBrave extends Brave{
	public NormalBrave(String name){
		MainGUI.jta.append("创建普通勇者【"+name+"】成功！\n");
		super.bName=name;
	}
	public boolean different() {
		// TODO Auto-generated method stub
		return false;
	}
}
