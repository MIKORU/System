package Brave;

import Main.Client;
import User.Brave;

//����ģʽ�������߶���ĸ��Ի����ã���װ����ʼ������ͷ���
public abstract class BraveBuilder {
	protected Brave brave = Client.brave;//brave�����ɹ�������
	
	public abstract void buildBody();
	public abstract void buildCustume();
	public abstract void buildWeapon();
	
	public Brave getBrave(){
		return brave;
	}
}
