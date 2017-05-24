package GUI;
import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import Main.Client;
import Scene.Map;
import Scene.SceneBFactory;
import Scene.SceneFactory;
import Scene.Weather;


public class MainGUI extends Gui implements ItemListener{
	public static JLabel la = new JLabel();
	public static JButton lb = new JButton();
	public static JTextArea jta=new JTextArea(500,50);
	JCheckBox jcba,jcbb;
	
	public MainGUI(){
	}
	@Override
	public void display() {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame("勇者大闯关游戏");
		frame.setSize(800, 700);
		frame.setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel jpa=new JPanel();
		jpa.setBounds(0, 0, 800, 350+100);
		jpa.add(la);
		
		lb.setContentAreaFilled(false);
		lb.setBounds(450, 20, 80, 80);
		
		//抽象工厂模式：创建不同的环境（天气+地图）
		SceneFactory sf=SceneBFactory.getSBF();
		Map map=sf.buildScene();//地图
		map.showm();
		Weather wt = sf.buildWeather();//天气
		wt.showw();
		
		DisplayBtn.jpl.setBounds(0, 400+100, 785, 50);
		
		JScrollPane jscrollPane = new JScrollPane(jta);
		jscrollPane.setBounds(0, 450+100, 785, 115);
		
		JPanel jps = new JPanel();
		jcba = new JCheckBox("主菜单");
		jcbb = new JCheckBox("附加商城");
		jcba.addItemListener(this);
		jcbb.addItemListener(this);
		
		jps.add(jcba);
		jps.add(jcbb);
		jps.setLayout(new FlowLayout());
		jps.setBounds(20, 375+100, 200, 30);
		
		frame.getLayeredPane().add(jps,new Integer(200)); 
		frame.getLayeredPane().add(jpa,new Integer(200));
		frame.getLayeredPane().add(lb,new Integer(300)); 
		frame.getLayeredPane().add(DisplayBtn.jpl,new Integer(200)); 
		frame.getLayeredPane().add(jscrollPane,new Integer(200));
		frame.setResizable(false);
	}
	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		if(e.getItem()==jcba){
			if(jcba.isSelected()){
				//jcba.setEnabled(false);
				Client.guis.display();//装饰模式guis的显示，增加主界面显示功能
				DisplayBtn.jpl.updateUI();
			}
			else{
				Client.guis.hide();//该装饰模式的“撤销”，主界面关闭按钮显示
				DisplayBtn.jpl.updateUI();
			}
		}
		if(e.getItem()==jcbb){
			if(jcbb.isSelected()){
				//jcbb.setEnabled(false);
				Client.guiss.display();//装饰模式guis的显示，增加主界面显示功能
				DisplayBtn.jpl.updateUI();
			}
			else{
				Client.guiss.hide();
				DisplayBtn.jpl.updateUI();
			}
		}
	}
	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}
}
