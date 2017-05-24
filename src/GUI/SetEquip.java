package GUI;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.plaf.basic.BasicButtonUI;

import Equipment.DEquip;
import Equipment.Equipment;
import Equipment.JEquip;
import Equipment.QEquip;
import Equipment.SpeciallyAdd;
import Equipment.addMoreAttack;
import Equipment.addMoreDefence;
import Equipment.addPoison;

public class SetEquip extends JFrame implements MouseListener{
	private static SetEquip se = null;
	String[] style={"�㶾","�ӷ�����","�ӹ�����"};
	String[] type={"��","��","ǹ"};
	String Style,Type;
	JFrame frame;
	//����ģʽ��ֻ����newһ�Σ�֮��һֱ����display����
	public static void getEquip(){
		if(se==null){
			se = new SetEquip();
		}
		se.display();
	}
	public SetEquip(){
		frame = new JFrame("�������");
	}
	private void display(){
		frame.setSize(230, 280);
		frame.setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(HIDE_ON_CLOSE);
		
		JLabel ls = new JLabel("��������");
		JList lists = new JList(style);
		lists.setBounds(20, 50, 80, 100);
		ls.setBounds(20,25, 80, 20);
		
		JLabel lt = new JLabel("����");
		JList listt = new JList(type);
		listt.setBounds(120, 50, 80, 100);
		lt.setBounds(120,25, 80, 20);
		
		lists.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
            	Object obj=((JList)e.getSource()).getSelectedValue();
            	if(obj.equals("�㶾")){
            		Style = "�㶾";
            	}else if(obj.equals("�ӷ�����")){
            		Style = "�ӷ�����";
            	}else if(obj.equals("�ӹ�����")){
            		Style = "�ӹ�����";
            	}
            }
        });
		listt.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
            	Object obj=((JList)e.getSource()).getSelectedValue();
            	if(obj.equals("��")){
            		Type = "��";
            	}else if(obj.equals("��")){
            		Type = "��";
            	}else if(obj.equals("ǹ")){
            		Type = "ǹ";
            	}
            }
        });
		
		JButton jbt = createBtn("ȷ��");
		JButton jbs = createBtn("�˳�");
		jbs.addMouseListener(this);
		jbt.addMouseListener(this);
		
		jbt.setBounds(30, 180, 70, 30);
		jbs.setBounds(130, 180, 70, 30);
		
		frame.getContentPane().add(jbt);
		frame.getContentPane().add(jbs);
		frame.setResizable(false);
		
		frame.getContentPane().add(ls);
		frame.getContentPane().add(lt);
		frame.getContentPane().add(lists);
		frame.getContentPane().add(listt);
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		String btnName =((JButton)e.getSource()).getText();
		if ("ȷ��".equals(btnName.trim())) {
			Equipment equipment = null;
			SpeciallyAdd add = null;
			if(Type.equals("��")){
				equipment = new DEquip();
			}
			if(Type.equals("��")){
				equipment = new JEquip();
			}
			if(Type.equals("ǹ")){
				equipment = new QEquip();
			}
			if(Style.equals("�㶾")){
				add = new addPoison();
			}
			if(Style.equals("�ӹ�����")){
				add = new addMoreAttack();
			}
			if(Style.equals("�ӷ�����")){
				add = new addMoreDefence();
			}
			equipment.setSpeciallyAdd(add);
			equipment.wear();
		}
		if ("�˳�".equals(btnName.trim())){
			frame.dispose();
		}
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
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
		btn.setIconTextGap(15);
		return btn;
	}
}
