package GUI;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import Main.Client;

public class RoleGUI extends JFrame{
	public static JTextArea jtb=new JTextArea(200,400);
	public static JLabel jl = new JLabel();
	private static RoleGUI rg = null;
	//��ʾ������Ϣ������display������ε��ã�Ϊ�˱��������Ϣ��������ڹ��캯���
	public RoleGUI(){
		jtb.append("����������"+Client.brave.bName);
		jtb.append("\n  �Ա�"+Client.brave.bSex);
		jtb.append("\n  ���ţ�"+Client.brave.bCustume);
		jtb.append("\n  ��ʼ������"+Client.brave.bWeapon);
		jtb.append("\n\n�ȼ���Ϣ��\n  HP��"+Client.brave.bHP);
		jtb.append("\n  MP��"+Client.brave.bMP);
		jtb.append("\n  ��������"+Client.brave.bDefence);
		jtb.append("\n  ��������"+Client.brave.bAttack);
		jtb.append("\n  ��Ǯ��"+Client.brave.bMoney);
	}
	//����ģʽ��ֻ��newһ�δ��ڣ����������ʾ
	public static void getRoleGUI(){
		if(rg==null){
			rg = new RoleGUI();
		}
		rg.display();
	}
	private void display(){
		this.setTitle("������Ϣ");
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
