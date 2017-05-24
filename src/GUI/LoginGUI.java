package GUI;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.plaf.basic.BasicButtonUI;

import Brave.BraveBuilder;
import Brave.BraveDirctor;
import Brave.XMLUtilB;
import Main.Client;
import User.UserFactory;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class LoginGUI extends JFrame implements MouseListener{
    JTextField jTextField;
    JRadioButton jda,jdb,jdc;
    JLabel jLabel1,jLabel2;
    JPanel jp1,jp2,jp3;
    JButton jb1,jb2;
    JLabel jl ;
    
    private JButton createBtn(String text) {
		JButton btn = new JButton(text);
		btn.setUI(new BasicButtonUI());// 恢复基本视觉效果
		btn.setPreferredSize(new Dimension(100, 40));//设置按钮大小
		btn.setContentAreaFilled(false);// 设置按钮透明
		btn.setFont(new Font(Font.DIALOG, Font.BOLD, 20));//按钮文本样式
		btn.setMargin(new Insets(0, 0, 0, 0));// 按钮内容与边框距离
		btn.addMouseListener(this);
		return btn;
	}
    private JRadioButton createJRB(String text){
    	final JRadioButton jdb = new JRadioButton(text);
    	jdb.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Client.Modes=jdb.getText();
			}
		}); 
    	return jdb;
    }
	public LoginGUI(){
        jTextField = new JTextField(12);
        jLabel1 = new JLabel("主角名 ");
        jLabel2 = new JLabel("用户角色");
        
        jda = createJRB("普通");
        jdb = createJRB("VIP");
        jda.setSelected(true);
        
        ButtonGroup bg = new ButtonGroup();
        bg.add(jda);
        bg.add(jdb);
        
        jb1 = createBtn("开始游戏");
        jb2 = createBtn("退出");
        jp1 = new JPanel();
        jp2 = new JPanel();
        jp3 = new JPanel();
        
        //设置布局
        this.setLayout(null);
        
        jp1.add(jLabel1); 
        jp1.add(jTextField);
        jp1.setBounds(30, 230, 400, 40);
        
        jp2.add(jLabel2);
        jp2.add(jda);
        jp2.add(jdb);
        jp2.setBounds(40,280,400,40);
        
        jp3.setLayout(new FlowLayout(FlowLayout.CENTER,40,5));
        jp3.add(jb1);
        jp3.add(jb2);
        jp3.setBounds(0,330,500,140);
        
        jl= new JLabel(new ImageIcon(LoginGUI.class.getResource("/image/s1.jpg")));
        jl.setBounds(0,0,500,190);
        
        this.add(jp1);
        this.add(jp2);
        this.add(jp3);
        this.add(jl);
        //设置显示
        this.setSize(500, 450);
        this.setLocation(450, 170);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setTitle("登陆");
        this.setResizable(false);
    }
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		String btnName =((JButton)e.getSource()).getText();
		String Keyname = jTextField.getText().trim();
		if ("开始游戏".equals(btnName.trim())) {
			if(Keyname.equals("")) Keyname="无名";
			Client.Bnames=Keyname;
			this.dispose();
			Client.gui.display();//基础界面显示
			//用户工厂依照输入创建不同等级用户：普通，VIP
			Client.brave=UserFactory.getUser(Client.Modes,Client.Bnames);
			
			//建造模式制造勇者的个性化设置：衣着，初始武器等。
			BraveBuilder bb = (BraveBuilder)XMLUtilB.getBean();
			BraveDirctor bd = new BraveDirctor();
			bd.setBraveBuilder(bb);
			Client.brave = bd.construct();
		}
		if ("退出".equals(btnName.trim())){
			this.dispose();
		}
	}
	@Override
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