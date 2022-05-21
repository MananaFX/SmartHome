package Admin;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import db.PeopleManage;
import runPart.MainInterface;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JLabel;


public class SelectUser extends JPanel implements ActionListener {
	private JButton back;
	private JButton bt_Selete;
	private JButton btn_submit;
	private static JTextArea textArea;
	private static String info;
	private JTextField inputAccount;

	/**
	 * Create the panel.
	 */
	public SelectUser() {
		setBackground(new Color(152, 251, 152));
		setLayout(null);
		
		back = new JButton("\u8FD4\u56DE");
		back.setFont(new Font("宋体", Font.PLAIN, 26));
		back.setBounds(0, 0, 115, 82);
		add(back);
		back.addActionListener(this);
		
		textArea = new JTextArea();
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 20));
		textArea.setBounds(152, 199, 1066, 614);
		add(textArea);
		
		textArea.setEditable(false);
		
		bt_Selete = new JButton("\u663E\u793A\u6240\u6709\u7528\u6237");
		bt_Selete.setFont(new Font("宋体", Font.BOLD, 30));
		bt_Selete.setBounds(152, 107, 251, 82);
		add(bt_Selete);
		bt_Selete.addActionListener(this);
		
		inputAccount = new JTextField();
		inputAccount.setFont(new Font("宋体", Font.BOLD, 35));
		inputAccount.setColumns(10);
		inputAccount.setBounds(656, 112, 266, 75);
		add(inputAccount);
		
		btn_submit = new JButton("\u5220\u9664\u8BE5\u7528\u6237");
		btn_submit.setFont(new Font("宋体", Font.BOLD, 35));
		btn_submit.setBounds(967, 109, 251, 80);
		add(btn_submit);
		btn_submit.addActionListener(this);
		
		JLabel account = new JLabel("\u7528\u6237\u8D26\u53F7\uFF1A");
		account.setFont(new Font("宋体", Font.BOLD, 35));
		account.setBounds(475, 119, 194, 55);
		add(account);
		
		info = "\t账号\t权限：\t添加\t修改\t控制\t安放编号\t控制设备数\n";
		
	}
	
	public static void setTextArea() {
		info = "\t账号\t权限：\t添加\t修改\t控制\t安防编号\t控制设备数\n";
		String[][] authority = PeopleManage.select_UserAuthority();
		
		for(int i=0;i<authority.length;i++) {
			info+="\t"+authority[i][0]+"\t\t"+
					authority[i][1]+" \t"+
					authority[i][2]+"\t"+
					authority[i][3]+"\t  "+
					authority[i][4]+"\t  "+
					authority[i][5]+"\t\n";
            
		}
		info+="\n\n\t当前共有：\t"+String.valueOf(authority.length)+" 名用户\n\n";
		textArea.setText(info);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == back) {
			MainInterface.userSelecttoAdmin();
		}else if(e.getSource() == bt_Selete) {
			setTextArea();
		}else if(e.getSource() == btn_submit) {
			String account = inputAccount.getText();
			PeopleManage.delete_User(account);
			inputAccount.setText("");
			JOptionPane.showMessageDialog(null, "成功", "更新信息成功", JOptionPane.OK_CANCEL_OPTION);
		}
	}
}

