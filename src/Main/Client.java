package Main;

import GUI.DisplayBtn;
import GUI.DisplayShop;
import GUI.Gui;
import GUI.LoginGUI;
import GUI.MainGUI;
import User.Brave;


public class Client {
	public static String Bnames;
	public static String Modes="普通";
	public static Brave brave;
	public static Gui gui,guis,guiss;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub	
		//装饰模式初始化
		gui = new MainGUI();//gui为基础
		guis = new DisplayBtn(gui);//guis为增加主按钮功能
		guiss = new DisplayShop(guis);//guiss为增加附加商城功能
		
		new LoginGUI();//登陆界面
	}

}
