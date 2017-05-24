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
	//装饰模式：增加额外VIP商城按钮
	private void setShop(){
		jbd = createBtn("VIP商城");
		DisplayBtn.jpl.add(jbd);
	}
	private JButton createBtn(String text) {
		JButton btn = new JButton(text);
		btn.setUI(new BasicButtonUI());
		btn.setPreferredSize(new Dimension(750/4,40));
		btn.setContentAreaFilled(false);//设置按钮透明
		btn.setFont(new Font(Font.DIALOG, Font.BOLD, 20));//按钮文本样式
		btn.setMargin(new Insets(0, 0, 0, 0));//按钮内容与边框距离
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
		if(btnName.equals("VIP商城")){
			if(Client.brave.different()==false){
				MainGUI.jta.append("对不起！您不是VIP用户，无法开启！\n");
			}else{
				ShopUI.getShopUI();
			}
		}
	}
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		JButton btn = (JButton) e.getComponent();
		Border etchedBorder = new EtchedBorder(EtchedBorder.RAISED);// 设置边框凸显
		btn.setBorder(etchedBorder);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		JButton btn = (JButton) e.getComponent();
		Border etchedBorder = new EtchedBorder(EtchedBorder.LOWERED);// 设置边框凹显
		btn.setBorder(etchedBorder);
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		JButton btn = (JButton) e.getComponent();
		btn.setForeground(/*new Color(0x33, 0x66, 0xcc)*/Color.BLUE);// 设置字体颜色
		btn.setBorderPainted(true);// 显示边框
		Border etchedBorder = new EtchedBorder(EtchedBorder.LOWERED);// 设置边框凹显
		btn.setBorder(etchedBorder);
		btn.setRolloverEnabled(true);
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		JButton btn = (JButton) e.getComponent();
		btn.setForeground(Color.black);// 设置字体颜色
		//btn.setBorderPainted(false);// 隐藏边框
	}
}
