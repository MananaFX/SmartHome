package User;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import db.FacilityManage;
import runPart.MainInterface;
import runPart.Properties;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class RunControl extends JPanel implements ActionListener {
	private JButton back;
	private JButton bt_Selete;
	private JButton bt_delete;
	private JButton bt_Add;
	private static String info;
	private JTextField FacilityNo;
	private static JLabel lb_user;
	private JTextArea textArea;
	/**
	 * Create the panel.
	 */
	public RunControl() {
		setBackground(new Color(152, 251, 152));
		setLayout(null);
		
		back = new JButton("\u8FD4\u56DE");
		back.setFont(new Font("宋体", Font.PLAIN, 26));
		back.setBounds(0, 0, 115, 82);
		add(back);
		back.addActionListener(this);
		
		textArea = new JTextArea();
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 20));
		textArea.setBounds(152, 231, 1066, 582);
		add(textArea);
		textArea.setEditable(false);
		JScrollPane scrollpane=new JScrollPane(textArea);
		scrollpane.setBounds(152, 332, 1066, 468);
		add(scrollpane);
		
		bt_Selete = new JButton("\u67E5\u627E\u63A7\u5236\u4FE1\u606F");
		bt_Selete.setFont(new Font("宋体", Font.BOLD, 30));
		bt_Selete.setBounds(511, 243, 222, 70);
		add(bt_Selete);
		bt_Selete.addActionListener(this);
		
		bt_delete = new JButton("\u5220\u9664\u63A7\u5236\u4FE1\u606F");
		bt_delete.setFont(new Font("宋体", Font.BOLD, 30));
		bt_delete.setBounds(754, 243, 222, 70);
		add(bt_delete);
		bt_delete.addActionListener(this);

		JLabel account_1 = new JLabel("\u8BBE\u5907\u7F16\u53F7\uFF1A");
		account_1.setFont(new Font("宋体", Font.BOLD, 35));
		account_1.setBounds(159, 175, 194, 55);
		add(account_1);
		
		FacilityNo = new JTextField();
		FacilityNo.setFont(new Font("宋体", Font.BOLD, 35));
		FacilityNo.setColumns(10);
		FacilityNo.setBounds(159, 243, 327, 75);
		add(FacilityNo);
		
		bt_Add = new JButton("\u6DFB\u52A0\u63A7\u5236\u4FE1\u606F");
		bt_Add.setFont(new Font("宋体", Font.BOLD, 30));
		bt_Add.setBounds(995, 243, 221, 70);
		add(bt_Add);
		bt_Add.addActionListener(this);
		
		lb_user = new JLabel("New label");
		lb_user.setHorizontalAlignment(SwingConstants.CENTER);
		lb_user.setFont(new Font("宋体", Font.BOLD, 28));
		lb_user.setBounds(860, 0, 356, 56);
		add(lb_user);
		
		ButtonGroup bg=new ButtonGroup();
		info="\t账号\t设备号\t锁在房间\t\t是否故障\n";
		textArea.setText(info);
	}
	
	public static void setUser() {
		lb_user.setText("当前用户："+Properties.user);
	}
	
	
	public static void setTextLogs(String accountString) {
		info="\t账号\t设备号\t所在房间\t\t是否故障\n";
		String[][] authority = FacilityManage.Select_Control(accountString);
		
		for(int i=0;i<authority.length;i++) {
			info+="\n\t"+authority[i][0]+"\t  "+
					authority[i][1]+"\t"+
					authority[i][2]+"\t\t "+
					authority[i][3];
		}info+="\n\n\t该用户共控制：\t"+String.valueOf(authority.length)+" 个设备";
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == back) {
			MainInterface.RunControltoUser();
		}else if(e.getSource() == bt_Selete) {
			setTextLogs(Properties.user);
			textArea.setText(info);
		}else if(e.getSource() == bt_delete) {
			String facilityNoString =  FacilityNo.getText();
			FacilityManage.delete_Control(Properties.user, facilityNoString);
			textArea.setText("");
			JOptionPane.showMessageDialog(null, "成功", "删除信息成功", JOptionPane.OK_CANCEL_OPTION);
		}else if(e.getSource() == bt_Add) {
			String facilityNoString =  FacilityNo.getText();
			FacilityManage.add_Control(Properties.user, facilityNoString);
			textArea.setText("");
			JOptionPane.showMessageDialog(null, "成功", "删除信息成功", JOptionPane.OK_CANCEL_OPTION);
		}
	}
}