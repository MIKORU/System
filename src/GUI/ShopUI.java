package GUI;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ShopUI extends JFrame{
	public static ShopUI su = null;
	public ShopUI(){
	}
	//����ģʽ��ֻ����newһ�Σ�֮�����diplay����
	public static void getShopUI(){
		if(su==null){
			su = new ShopUI();
		}
		su.display();
	}
	public void display(){
		this.setTitle("VIP�̳�");
		this.setSize(500, 310);
		this.setLayout(null);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		
		JLabel la = new JLabel(new ImageIcon(ShopUI.class.getResource("/image/shop.jpg")));
		la.setBounds(0,0,500,310);
		
		this.getContentPane().add(la);
		this.setResizable(false);
	}
}
