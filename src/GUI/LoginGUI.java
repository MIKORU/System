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
		btn.setUI(new BasicButtonUI());// �ָ������Ӿ�Ч��
		btn.setPreferredSize(new Dimension(100, 40));//���ð�ť��С
		btn.setContentAreaFilled(false);// ���ð�ť͸��
		btn.setFont(new Font(Font.DIALOG, Font.BOLD, 20));//��ť�ı���ʽ
		btn.setMargin(new Insets(0, 0, 0, 0));// ��ť������߿����
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
        jLabel1 = new JLabel("������ ");
        jLabel2 = new JLabel("�û���ɫ");
        
        jda = createJRB("��ͨ");
        jdb = createJRB("VIP");
        jda.setSelected(true);
        
        ButtonGroup bg = new ButtonGroup();
        bg.add(jda);
        bg.add(jdb);
        
        jb1 = createBtn("��ʼ��Ϸ");
        jb2 = createBtn("�˳�");
        jp1 = new JPanel();
        jp2 = new JPanel();
        jp3 = new JPanel();
        
        //���ò���
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
        //������ʾ
        this.setSize(500, 450);
        this.setLocation(450, 170);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setTitle("��½");
        this.setResizable(false);
    }
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		String btnName =((JButton)e.getSource()).getText();
		String Keyname = jTextField.getText().trim();
		if ("��ʼ��Ϸ".equals(btnName.trim())) {
			if(Keyname.equals("")) Keyname="����";
			Client.Bnames=Keyname;
			this.dispose();
			Client.gui.display();//����������ʾ
			//�û������������봴����ͬ�ȼ��û�����ͨ��VIP
			Client.brave=UserFactory.getUser(Client.Modes,Client.Bnames);
			
			//����ģʽ�������ߵĸ��Ի����ã����ţ���ʼ�����ȡ�
			BraveBuilder bb = (BraveBuilder)XMLUtilB.getBean();
			BraveDirctor bd = new BraveDirctor();
			bd.setBraveBuilder(bb);
			Client.brave = bd.construct();
		}
		if ("�˳�".equals(btnName.trim())){
			this.dispose();
		}
	}
	@Override
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