package Main;

import GUI.DisplayBtn;
import GUI.DisplayShop;
import GUI.Gui;
import GUI.LoginGUI;
import GUI.MainGUI;
import User.Brave;


public class Client {
	public static String Bnames;
	public static String Modes="��ͨ";
	public static Brave brave;
	public static Gui gui,guis,guiss;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub	
		//װ��ģʽ��ʼ��
		gui = new MainGUI();//guiΪ����
		guis = new DisplayBtn(gui);//guisΪ��������ť����
		guiss = new DisplayShop(guis);//guissΪ���Ӹ����̳ǹ���
		
		new LoginGUI();//��½����
	}

}
