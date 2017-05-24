package GUI;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import Main.Client;

public class RoleGUI extends JFrame{
	public static JTextArea jtb=new JTextArea(200,400);
	public static JLabel jl = new JLabel();
	private static RoleGUI rg = null;
	//显示人物信息，由于display方法多次调用，为了避免多余信息输出，放在构造函数里。
	public RoleGUI(){
		jtb.append("勇者姓名："+Client.brave.bName);
		jtb.append("\n  性别："+Client.brave.bSex);
		jtb.append("\n  衣着："+Client.brave.bCustume);
		jtb.append("\n  初始武器："+Client.brave.bWeapon);
		jtb.append("\n\n等级信息：\n  HP："+Client.brave.bHP);
		jtb.append("\n  MP："+Client.brave.bMP);
		jtb.append("\n  防御力："+Client.brave.bDefence);
		jtb.append("\n  攻击力："+Client.brave.bAttack);
		jtb.append("\n  金钱："+Client.brave.bMoney);
	}
	//单例模式：只能new一次窗口，否则就是显示
	public static void getRoleGUI(){
		if(rg==null){
			rg = new RoleGUI();
		}
		rg.display();
	}
	private void display(){
		this.setTitle("人物信息");
		this.setSize(450, 300);
		this.setLayout(null);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		this.setResizable(false);
				
		jtb.setBounds(220, 20, 200, 220);
		jl.setBounds(10, 20, 200, 200);
		
		jtb.setEditable(false);
		
		this.getContentPane().add(jl);
		this.getContentPane().add(jtb);
	}
	
}
