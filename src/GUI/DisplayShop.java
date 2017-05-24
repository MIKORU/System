package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.plaf.basic.BasicButtonUI;

import Main.Client;
import Scene.Map;
import Scene.SceneAFactory;
import Scene.SceneBFactory;
import Scene.SceneFactory;

public class DisplayShop extends AddChange implements MouseListener{
	JButton jbd;
	public DisplayShop(Gui gui) {
		super(gui);
	}
	public void display() {
		this.setShop();
	}
	public void hide(){
		DisplayBtn.jpl.remove(jbd);
	}
	//װ��ģʽ�����Ӷ���VIP�̳ǰ�ť
	private void setShop(){
		jbd = createBtn("VIP�̳�");
		DisplayBtn.jpl.add(jbd);
	}
	private JButton createBtn(String text) {
		JButton btn = new JButton(text);
		btn.setUI(new BasicButtonUI());
		btn.setPreferredSize(new Dimension(750/4,40));
		btn.setContentAreaFilled(false);//���ð�ť͸��
		btn.setFont(new Font(Font.DIALOG, Font.BOLD, 20));//��ť�ı���ʽ
		btn.setMargin(new Insets(0, 0, 0, 0));//��ť������߿����
        btn.setVerticalTextPosition(JButton.BOTTOM);
        btn.setHorizontalTextPosition(JButton.CENTER);
        btn.addMouseListener(this);
		btn.setIconTextGap(15);
		return btn;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		String btnName =((JButton)e.getSource()).getText();
		if(btnName.equals("VIP�̳�")){
			if(Client.brave.different()==false){
				MainGUI.jta.append("�Բ���������VIP�û����޷�������\n");
			}else{
				ShopUI.getShopUI();
			}
		}
	}
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		JButton btn = (JButton) e.getComponent();
		Border etchedBorder = new EtchedBorder(EtchedBorder.RAISED);// ���ñ߿�͹��
		btn.setBorder(etchedBorder);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		JButton btn = (JButton) e.getComponent();
		Border etchedBorder = new EtchedBorder(EtchedBorder.LOWERED);// ���ñ߿���
		btn.setBorder(etchedBorder);
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		JButton btn = (JButton) e.getComponent();
		btn.setForeground(/*new Color(0x33, 0x66, 0xcc)*/Color.BLUE);// ����������ɫ
		btn.setBorderPainted(true);// ��ʾ�߿�
		Border etchedBorder = new EtchedBorder(EtchedBorder.LOWERED);// ���ñ߿���
		btn.setBorder(etchedBorder);
		btn.setRolloverEnabled(true);
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		JButton btn = (JButton) e.getComponent();
		btn.setForeground(Color.black);// ����������ɫ
		//btn.setBorderPainted(false);// ���ر߿�
	}
}
