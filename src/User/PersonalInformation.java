package User;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import db.PeopleManage;
import runPart.MainInterface;

import javax.swing.JTextArea;

public class PersonalInformation extends JPanel implements ActionListener{
	private JButton back;
	private static JTextArea textArea;
	private JLabel label;
	private static String info;

	/**
	 * Create the panel.
	 */
	public PersonalInformation() {
		setBackground(new Color(127, 255, 212));
		setLayout(null);
		
		back = new JButton("\u8FD4\u56DE");
		back.setFont(new Font("宋体", Font.PLAIN, 26));
		back.setBounds(0, 0, 115, 82);
		add(back);
		back.addActionListener(this);
		
		label = new JLabel("\u4E2A\u4EBA\u4FE1\u606F");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("宋体", Font.BOLD, 40));
		label.setBounds(530, 20, 294, 105);
		add(label);
		
		textArea = new JTextArea();
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 20));
		textArea.setEditable(false);
		textArea.setBounds(111, 125, 1050, 782);
		add(textArea);
		
		info = "账号\t权限：\t添加\t修改\t控制\t安放编号\t控制设备数\n";
		
	}
	
	public static void setTextArea() {
		info = "账号\t权限：\t添加\t修改\t控制\t安防编号\t控制设备数\n";
		String[] authority = PeopleManage.select_SingleUserAuthority(runPart.Properties.user);
			info+=authority[0]+"\t\t"+
					authority[1]+" \t"+
					authority[2]+"\t"+
					authority[3]+"\t  "+
					authority[4]+"\t  "+
					authority[5]+"\t\n";
		textArea.setText(info);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == back) {
			MainInterface.PersonaltoUser();
		}
	}
}
