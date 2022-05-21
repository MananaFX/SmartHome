package Admin;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import db.PeopleManage;
import runPart.MainInterface;

import javax.swing.JCheckBox;



public class AuthorityChange extends JPanel implements ActionListener {
	private JTextField tf_Account_Input;
	private JTextField tf_Account_Output;
	private JLabel update;
	private JTextField tf_SecurityNo;
	private JLabel account;
	private JLabel label;
	private JLabel lb_new_Account;
	private JLabel lb_new_securityNo;
	private JLabel lb_new_name;
	private JLabel lb_new_classname;
	private JLabel lb_new_price;
	private JButton btn_submit;
	private JButton back;
	private JButton btn_search;
	private JCheckBox CanAddCheckBox;
	private JCheckBox CanDeleteCheckBox;
	private JCheckBox CanControlCheckBox;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Create the panel.
	 */
	public AuthorityChange() {
		setBackground(new Color(230, 230, 250));
		setLayout(null);
		
		label = new JLabel("\u66F4\u65B0\u6743\u9650\u4FE1\u606F");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("宋体", Font.BOLD, 40));
		label.setBounds(530, 20, 294, 105);
		add(label);
		
		account = new JLabel("\u4EBA\u5458\u8D26\u53F7\uFF1A");
		account.setFont(new Font("宋体", Font.BOLD, 35));
		account.setBounds(285, 127, 194, 55);
		add(account);
		
		tf_Account_Input = new JTextField();
		tf_Account_Input.setFont(new Font("宋体", Font.BOLD, 35));
		tf_Account_Input.setColumns(10);
		tf_Account_Input.setBounds(507, 117, 252, 75);
		add(tf_Account_Input);
		
		tf_Account_Output = new JTextField();
		tf_Account_Output.setFont(new Font("宋体", Font.BOLD, 35));
		tf_Account_Output.setColumns(10);
		tf_Account_Output.setBounds(507, 278, 526, 75);
		add(tf_Account_Output);
		
		update = new JLabel("\u66F4\u65B0\u4FE1\u606F");
		update.setFont(new Font("宋体", Font.BOLD, 35));
		update.setBounds(607, 213, 157, 55);
		add(update);
		
		tf_SecurityNo = new JTextField();
		tf_SecurityNo.setFont(new Font("宋体", Font.BOLD, 35));
		tf_SecurityNo.setColumns(10);
		tf_SecurityNo.setBounds(507, 370, 526, 75);
		add(tf_SecurityNo);
		
		lb_new_Account = new JLabel("\u4EBA\u5458\u8D26\u53F7\uFF1A");
		lb_new_Account.setFont(new Font("宋体", Font.BOLD, 35));
		lb_new_Account.setBounds(285, 284, 194, 55);
		add(lb_new_Account);
		
		lb_new_securityNo = new JLabel("\u5B89\u9632\u7F16\u53F7\uFF1A");
		lb_new_securityNo.setFont(new Font("宋体", Font.BOLD, 35));
		lb_new_securityNo.setBounds(285, 380, 227, 55);
		add(lb_new_securityNo);
		
		lb_new_name = new JLabel("\u6743\u9650\uFF1A");
		lb_new_name.setFont(new Font("宋体", Font.BOLD, 35));
		lb_new_name.setBounds(285, 476, 194, 55);
		add(lb_new_name);
		
		lb_new_classname = new JLabel("\u6743\u9650\uFF1A");
		lb_new_classname.setFont(new Font("宋体", Font.BOLD, 35));
		lb_new_classname.setBounds(285, 572, 227, 55);
		add(lb_new_classname);
		
		lb_new_price = new JLabel("\u6743\u9650\uFF1A");
		lb_new_price.setFont(new Font("宋体", Font.BOLD, 35));
		lb_new_price.setBounds(285, 668, 227, 55);
		add(lb_new_price);
		
		back = new JButton("\u8FD4\u56DE");
		back.setFont(new Font("宋体", Font.PLAIN, 26));
		back.setBounds(0, 0, 115, 82);
		add(back);
		back.addActionListener(this);
		
		btn_submit = new JButton("\u63D0\u4EA4");
		btn_submit.setFont(new Font("宋体", Font.BOLD, 35));
		btn_submit.setBounds(1134, 114, 251, 80);
		add(btn_submit);
		btn_submit.addActionListener(this);
		
		btn_search = new JButton("\u67E5\u8BE2");
		btn_search.setFont(new Font("宋体", Font.BOLD, 35));
		btn_search.setBounds(810, 114, 251, 80);
		add(btn_search);
		btn_search.addActionListener(this);
		
		CanAddCheckBox = new JCheckBox("\u80FD\u5426\u6DFB\u52A0");
		CanAddCheckBox.setFont(new Font("宋体", Font.BOLD, 35));
		CanAddCheckBox.setBackground(Color.WHITE);
		CanAddCheckBox.setBounds(781, 462, 252, 75);
		add(CanAddCheckBox);
		
		CanDeleteCheckBox = new JCheckBox("\u80FD\u5426\u4FEE\u6539");
		CanDeleteCheckBox.setFont(new Font("宋体", Font.BOLD, 35));
		CanDeleteCheckBox.setBackground(Color.WHITE);
		CanDeleteCheckBox.setBounds(781, 563, 252, 75);
		add(CanDeleteCheckBox);
		
		CanControlCheckBox = new JCheckBox("\u80FD\u5426\u63A7\u5236");
		CanControlCheckBox.setFont(new Font("宋体", Font.BOLD, 35));
		CanControlCheckBox.setBackground(Color.WHITE);
		CanControlCheckBox.setBounds(781, 657, 252, 75);
		add(CanControlCheckBox);
		
		textField = new JTextField();
		textField.setFont(new Font("宋体", Font.BOLD, 30));
		textField.setBounds(507, 462, 227, 75);
		textField.setColumns(10);
		add(textField);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("宋体", Font.BOLD, 30));
		textField_1.setColumns(10);
		textField_1.setBounds(507, 563, 227, 75);
		add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("宋体", Font.BOLD, 30));
		textField_2.setColumns(10);
		textField_2.setBounds(507, 657, 227, 75);
		add(textField_2);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == back) {
			//点击返回按钮
			MainInterface.AuthoritytoAdmin();
		}else if(e.getSource() == btn_search) {
			String old_Account = tf_Account_Input.getText();
			//输出信息
			String[] Authority = PeopleManage.select_UserAuthority(old_Account);
			tf_Account_Output.setText(old_Account);
			tf_SecurityNo.setText(PeopleManage.select_UserSecurity(old_Account));
			System.out.println(String.valueOf(Authority[0]));
			
			textField.setText(Authority[0]);
			textField_1.setText(Authority[1]);
			textField_2.setText(Authority[2]);
			
		}else if(e.getSource() == btn_submit ) {
			//点击更新信息提交按钮
			//输入信息
			String old_Account = tf_Account_Input.getText();
			//输出信息
			String Account = tf_Account_Output.getText();
			String securityNo = tf_SecurityNo.getText();
			Boolean canAdd = CanAddCheckBox.isSelected();
			Boolean canDelete = CanDeleteCheckBox.isSelected();
			Boolean canControl = CanControlCheckBox.isSelected();
			
				//插入新书籍信息
			PeopleManage.Alter_UserAuthority(Account,canAdd,canDelete,canControl);
			tf_Account_Output.setText("");
			tf_SecurityNo.setText("");
			textField.setText("");
			textField_1.setText("");
			textField_2.setText("");
			CanAddCheckBox.setSelected(false);
			CanDeleteCheckBox.setSelected(false);
			CanControlCheckBox.setSelected(false);
			JOptionPane.showMessageDialog(null, "成功", "更新信息成功", JOptionPane.OK_CANCEL_OPTION);
			
		}
	}
}