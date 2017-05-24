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
	//装饰模式：增加主菜单
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
		
		jba = createBtn("锻造装备");
		jbb = createBtn("场景B");
		jbc = createBtn("人物信息");
		
		jpl.add(jba);
		jpl.add(jbb);
		jpl.add(jbc);
		
		jpl.setVisible(true);
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
		if(btnName.equals("场景B")){
			jbb.setText("场景A");
			SceneFactory sf=SceneAFactory.getSAF();//单例模式：只生成一次工厂A
			Map map=sf.buildScene();
			map.showm();
			Weather wt = sf.buildWeather();
			wt.showw();
			MainGUI.jta.append("转换为场景A！天气是阴天！\n");
		}
		if(btnName.equals("场景A")){
			jbb.setText("场景B");
			SceneFactory sf=SceneBFactory.getSBF();//单例模式：只生成一次工厂B
			Map map=sf.buildScene();
			map.showm();
			Weather wt = sf.buildWeather();
			wt.showw();
			MainGUI.jta.append("转换为场景B！天气是晴天！\n");
		}
		if(btnName.equals("锻造装备")){
			SetEquip.getEquip();//单例模式：只生成一次窗口
		}
		if(btnName.equals("人物信息")){
			RoleGUI.getRoleGUI();//单例模式：只生成一次窗口
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
