package User;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.PublicKey;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import db.FacilityManage;
import db.facility;
import runPart.MainInterface;
import runPart.Properties;


public class AddFacility extends JPanel implements ActionListener{
	private static JTextField tf_number;
	private JLabel lb_number;
	private JLabel lb_classnumber;
	private JLabel lb_name;
	private JLabel lb_classname;
	private JTextField tf_classnumber;
	private JTextField tf_name;
	private JTextField tf_classname;
	private JButton back;
	private JButton btn_submit;

	/**
	 * Create the panel.
	 */
	public AddFacility() {
		setBackground(Color.PINK);
		setLayout(null);
		
		JLabel label = new JLabel("\u6DFB\u52A0\u8BBE\u5907");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("宋体", Font.BOLD, 40));
		label.setBounds(530, 0, 294, 105);
		add(label);
		
		lb_number = new JLabel("\u7F16\u53F7\uFF1A");
		lb_number.setFont(new Font("宋体", Font.BOLD, 35));
		lb_number.setBounds(289, 220, 194, 55);
		add(lb_number);
		
		tf_number = new JTextField();
		tf_number.setFont(new Font("宋体", Font.BOLD, 35));
		tf_number.setColumns(10);
		tf_number.setBounds(482, 210, 526, 75);
		add(tf_number);
		
		lb_classnumber = new JLabel("\u5206\u7C7B\uFF1A");
		lb_classnumber.setFont(new Font("宋体", Font.BOLD, 35));
		lb_classnumber.setBounds(289, 356, 194, 55);
		add(lb_classnumber);
		
		lb_name = new JLabel("\u4FDD\u4FEE\u671F\uFF1A");
		lb_name.setFont(new Font("宋体", Font.BOLD, 35));
		lb_name.setBounds(289, 482, 194, 55);
		add(lb_name);
		
		lb_classname = new JLabel("\u623F\u95F4\u540D\uFF1A");
		lb_classname.setFont(new Font("宋体", Font.BOLD, 35));
		lb_classname.setBounds(289, 625, 194, 55);
		add(lb_classname);
		
		tf_classnumber = new JTextField();
		tf_classnumber.setFont(new Font("宋体", Font.BOLD, 35));
		tf_classnumber.setColumns(10);
		tf_classnumber.setBounds(482, 346, 526, 75);
		add(tf_classnumber);
		
		tf_name = new JTextField();
		tf_name.setFont(new Font("宋体", Font.BOLD, 35));
		tf_name.setColumns(10);
		tf_name.setBounds(482, 472, 526, 75);
		add(tf_name);
		
		tf_classname = new JTextField();
		tf_classname.setFont(new Font("宋体", Font.BOLD, 35));
		tf_classname.setColumns(10);
		tf_classname.setBounds(482, 605, 526, 75);
		add(tf_classname);
		
		btn_submit = new JButton("\u63D0\u4EA4");
		btn_submit.setFont(new Font("宋体", Font.BOLD, 35));
		btn_submit.setBounds(564, 727, 251, 80);
		add(btn_submit);
		btn_submit.addActionListener(this);
		
		back = new JButton("\u8FD4\u56DE");
		back.setFont(new Font("宋体", Font.PLAIN, 26));
		back.setBounds(0, 0, 115, 82);
		add(back);
		back.addActionListener(this);
		
	}
	
	public static void setFacilityNo() {
		tf_number.setText(Properties.facilityNo);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == back) {
			//点击返回按钮
			MainInterface.AddFacilitytoSelectFacility();
		}else if(e.getSource() == btn_submit) {
			//点击提交按钮
			//判定录入信息是否冲突
			String number = tf_number.getText();
			System.out.println("number = " + number);
			String classnumber = tf_classnumber.getText();
			String name = tf_name.getText();
			String classname = tf_classname.getText();

			
			if(!FacilityManage.isExist_Facility(number)) {
				//插入书籍信息
				FacilityManage.add_Facility(number, classnumber, Integer.parseInt(name), classname);
				tf_number.setText("");
				tf_classnumber.setText("");
				tf_name.setText("");
				tf_classname.setText("");

				JOptionPane.showMessageDialog(null, "恭喜", "设备添加成功", JOptionPane.OK_CANCEL_OPTION);
			}else {
				JOptionPane.showMessageDialog(null, "设备信息冲突", "设备添加失败", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}
