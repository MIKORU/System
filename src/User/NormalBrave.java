package User;

import GUI.MainGUI;
import Main.Client;

//�Ա�������HP��MP������ֵ������ֵ����Ǯ
public class NormalBrave extends Brave{
	public NormalBrave(String name){
		MainGUI.jta.append("������ͨ���ߡ�"+name+"���ɹ���\n");
		super.bName=name;
	}
	public boolean different() {
		// TODO Auto-generated method stub
		return false;
	}
}
