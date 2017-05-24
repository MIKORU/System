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
	String[] style={"淬毒","加防御力","加攻击力"};
	String[] type={"刀","剑","枪"};
	String Style,Type;
	JFrame frame;
	//单例模式：只允许new一次，之后一直调用display方法
	public static void getEquip(){
		if(se==null){
			se = new SetEquip();
		}
		se.display();
	}
	public SetEquip(){
		frame = new JFrame("锻造兵器");
	}
	private void display(){
		frame.setSize(230, 280);
		frame.setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(HIDE_ON_CLOSE);
		
		JLabel ls = new JLabel("附加属性");
		JList lists = new JList(style);
		lists.setBounds(20, 50, 80, 100);
		ls.setBounds(20,25, 80, 20);
		
		JLabel lt = new JLabel("类型");
		JList listt = new JList(type);
		listt.setBounds(120, 50, 80, 100);
		lt.setBounds(120,25, 80, 20);
		
		lists.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
            	Object obj=((JList)e.getSource()).getSelectedValue();
            	if(obj.equals("淬毒")){
            		Style = "淬毒";
            	}else if(obj.equals("加防御力")){
            		Style = "加防御力";
            	}else if(obj.equals("加攻击力")){
            		Style = "加攻击力";
            	}
            }
        });
		listt.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
            	Object obj=((JList)e.getSource()).getSelectedValue();
            	if(obj.equals("刀")){
            		Type = "刀";
            	}else if(obj.equals("剑")){
            		Type = "剑";
            	}else if(obj.equals("枪")){
            		Type = "枪";
            	}
            }
        });
		
		JButton jbt = createBtn("确定");
		JButton jbs = createBtn("退出");
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
		if ("确定".equals(btnName.trim())) {
			Equipment equipment = null;
			SpeciallyAdd add = null;
			if(Type.equals("刀")){
				equipment = new DEquip();
			}
			if(Type.equals("剑")){
				equipment = new JEquip();
			}
			if(Type.equals("枪")){
				equipment = new QEquip();
			}
			if(Style.equals("淬毒")){
				add = new addPoison();
			}
			if(Style.equals("加攻击力")){
				add = new addMoreAttack();
			}
			if(Style.equals("加防御力")){
				add = new addMoreDefence();
			}
			equipment.setSpeciallyAdd(add);
			equipment.wear();
		}
		if ("退出".equals(btnName.trim())){
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
		btn.setContentAreaFilled(false);//设置按钮透明
		btn.setFont(new Font(Font.DIALOG, Font.BOLD, 20));//按钮文本样式
		btn.setMargin(new Insets(0, 0, 0, 0));//按钮内容与边框距离
        btn.setVerticalTextPosition(JButton.BOTTOM);
        btn.setHorizontalTextPosition(JButton.CENTER);
		btn.setIconTextGap(15);
		return btn;
	}
}
