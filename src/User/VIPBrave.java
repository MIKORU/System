package User;

import GUI.MainGUI;

public class VIPBrave extends Brave{
	public VIPBrave(String name){
		super.bHP=200;
		super.bMP=200;
		super.bMoney=1000;
		MainGUI.jta.append("����VIP���ߡ�"+name+"���ɹ���HP��MP���������ӽ�Ǯ1000Ԫ��\n");
		super.bName=name;
	}
	@Override
	public boolean different() {
		return true;
	}
}
