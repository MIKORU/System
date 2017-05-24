package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.plaf.basic.BasicButtonUI;

import Scene.Map;
import Scene.SceneAFactory;
import Scene.SceneBFactory;
import Scene.SceneFactory;
import Scene.Weather;

public class DisplayBtn extends AddChange implements MouseListener{
	JButton jba,jbb,jbc;
	public static JPanel jpl = new JPanel();
	public DisplayBtn(Gui gui){
		super(gui);
	}
	@Override
	//װ��ģʽ���������˵�
	public void display() {
		// TODO Auto-generated method stub
		this.setBtn();
	}
	public void hide(){
		jpl.remove(jba);
		jpl.remove(jbb);
		jpl.remove(jbc);
	}
	private void setBtn(){
		
		jba = createBtn("����װ��");
		jbb = createBtn("����B");
		jbc = createBtn("������Ϣ");
		
		jpl.add(jba);
		jpl.add(jbb);
		jpl.add(jbc);
		
		jpl.setVisible(true);
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
		if(btnName.equals("����B")){
			jbb.setText("����A");
			SceneFactory sf=SceneAFactory.getSAF();//����ģʽ��ֻ����һ�ι���A
			Map map=sf.buildScene();
			map.showm();
			Weather wt = sf.buildWeather();
			wt.showw();
			MainGUI.jta.append("ת��Ϊ����A�����������죡\n");
		}
		if(btnName.equals("����A")){
			jbb.setText("����B");
			SceneFactory sf=SceneBFactory.getSBF();//����ģʽ��ֻ����һ�ι���B
			Map map=sf.buildScene();
			map.showm();
			Weather wt = sf.buildWeather();
			wt.showw();
			MainGUI.jta.append("ת��Ϊ����B�����������죡\n");
		}
		if(btnName.equals("����װ��")){
			SetEquip.getEquip();//����ģʽ��ֻ����һ�δ���
		}
		if(btnName.equals("������Ϣ")){
			RoleGUI.getRoleGUI();//����ģʽ��ֻ����һ�δ���
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
