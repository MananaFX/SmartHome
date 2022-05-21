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
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import runPart.MainInterface;
import runPart.Properties;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;


import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class AdminInterface extends JPanel implements ActionListener{
	private JLabel label;
	private JButton back;
	private JButton serach_User;
	private JButton serach_Logs;
	private JButton change_Authority;
	private JButton serach_Facility;
	public static  JLabel lb_Admin;

	/**
	 * Create the panel.
	 */
	public AdminInterface() {
		setBackground(Color.CYAN);
		setLayout(null);
		
		label = new JLabel("\u7BA1\u7406\u5458\u754C\u9762");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("宋体", Font.BOLD, 40));
		label.setBounds(530, 20, 294, 105);
		add(label);
		
		back = new JButton("\u8FD4\u56DE");
		back.setFont(new Font("宋体", Font.PLAIN, 26));
		back.setBounds(0, 0, 115, 82);
		add(back);
		back.addActionListener(this);
		
		serach_User = new JButton("\u7528\u6237\u7BA1\u7406");
		serach_User.setFont(new Font("宋体", Font.BOLD, 40));
		serach_User.setBounds(21, 241, 280, 505);
		add(serach_User);
		serach_User.addActionListener(this);
		
		change_Authority = new JButton("\u6743\u9650\u4FEE\u6539");
		change_Authority.setFont(new Font("宋体", Font.BOLD, 40));
		change_Authority.setBounds(347, 241, 280, 505);
		add(change_Authority);
		change_Authority.addActionListener(this);
		
		serach_Facility = new JButton("\u5B89\u9632\u63A7\u5236");
		serach_Facility.setFont(new Font("宋体", Font.BOLD, 40));
		serach_Facility.setBounds(673, 241, 280, 505);
		add(serach_Facility);
		serach_Facility.addActionListener(this);
		
		serach_Logs = new JButton("\u65E5\u5FD7\u7BA1\u7406");
		serach_Logs.setFont(new Font("宋体", Font.BOLD, 40));
		serach_Logs.setBounds(995, 241, 280, 505);
		add(serach_Logs);
		serach_Logs.addActionListener(this);
		
		lb_Admin = new JLabel("管理员姓名");
		lb_Admin.setHorizontalAlignment(SwingConstants.CENTER);
		lb_Admin.setFont(new Font("宋体", Font.BOLD, 28));
		lb_Admin.setBounds(954, 0, 348, 56);
		add(lb_Admin);
		

	}

	//设置右上角当前管理员
	public static void setAdmin() {
		
		lb_Admin.setText("当前管理员："+Properties.admin);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == back) {
			MainInterface.adminrtoMain();
		}else if(e.getSource() == serach_User){
			MainInterface.admintoUserSelect();
		}else if(e.getSource() == change_Authority) {
			MainInterface.admintoAuthority();
		}else if(e.getSource() == serach_Facility) {
			MainInterface.admintoSecurityChange();
		}else if(e.getSource() == serach_Logs) {
			MainInterface.admintoLogsSelect();
			
		}
		
	}
}
