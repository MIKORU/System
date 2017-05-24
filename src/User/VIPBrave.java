package User;

import GUI.MainGUI;

public class VIPBrave extends Brave{
	public VIPBrave(String name){
		super.bHP=200;
		super.bMP=200;
		super.bMoney=1000;
		MainGUI.jta.append("创建VIP勇者【"+name+"】成功！HP，MP翻倍，增加金钱1000元。\n");
		super.bName=name;
	}
	@Override
	public boolean different() {
		return true;
	}
}
