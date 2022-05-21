package Admin;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import db.FacilityManage;
import runPart.MainInterface;
import javax.swing.JCheckBox;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class SelectLogs extends JPanel implements ActionListener {
	private JButton back;
	private JButton bt_Selete;
	private JButton btn_submit;
	private static JTextArea textArea;
	private static String info;
	private JCheckBox cb_UserBox;
	private JCheckBox cb_AdminBox;
	private JCheckBox cb_FacilityBox;
	private JCheckBox cb_ControlBox;
	
	/**
	 * Create the panel.
	 */
	public SelectLogs() {
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
		scrollpane.setBounds(152, 254, 1066, 546);
		add(scrollpane);
		
		bt_Selete = new JButton("\u663E\u793A\u8BE5\u7C7B\u65E5\u5FD7");
		bt_Selete.setFont(new Font("宋体", Font.BOLD, 30));
		bt_Selete.setBounds(679, 154, 238, 70);
		add(bt_Selete);
		bt_Selete.addActionListener(this);
		
		btn_submit = new JButton("\u5220\u9664\u8BE5\u7C7B\u65E5\u5FD7");
		btn_submit.setFont(new Font("宋体", Font.BOLD, 30));
		btn_submit.setBounds(943, 154, 238, 70);
		add(btn_submit);
		btn_submit.addActionListener(this);
		
		ButtonGroup bg=new ButtonGroup();
		
		cb_UserBox = new JCheckBox("\u7528\u6237\u53D8\u52A8");
		cb_UserBox.setBackground(new Color(152, 251, 152));
		cb_UserBox.setFont(new Font("宋体", Font.BOLD, 30));
		cb_UserBox.setBounds(152, 152, 170, 37);
		add(cb_UserBox);
		
		
		cb_AdminBox = new JCheckBox("\u7BA1\u7406\u5458\u53D8\u52A8");
		cb_AdminBox.setFont(new Font("宋体", Font.BOLD, 30));
		cb_AdminBox.setBackground(new Color(152, 251, 152));
		cb_AdminBox.setBounds(369, 152, 196, 37);
		add(cb_AdminBox);
		
		cb_FacilityBox = new JCheckBox("\u8BBE\u5907\u53D8\u52A8");
		cb_FacilityBox.setFont(new Font("宋体", Font.BOLD, 30));
		cb_FacilityBox.setBackground(new Color(152, 251, 152));
		cb_FacilityBox.setBounds(152, 202, 170, 37);
		add(cb_FacilityBox);
		
		cb_ControlBox = new JCheckBox("\u63A7\u5236\u53D8\u52A8");
		cb_ControlBox.setFont(new Font("宋体", Font.BOLD, 30));
		cb_ControlBox.setBackground(new Color(152, 251, 152));
		cb_ControlBox.setBounds(369, 202, 196, 37);
		add(cb_ControlBox);
		
		info="\t时间\t\t事件\t关键字\t类别\n";;
		textArea.setText(info);
	}
	
	public static void setTextLogs(String category) {
		String[][] authority = FacilityManage.select_Logs(category);
		int num=authority.length;
		info+="\n\n\t该类型日志共计：\t"+String.valueOf(num)+"条";
		for(int i=0;i<num;i++) {
			info+="\n\t"+authority[i][0]+"\t"+
					authority[i][1]+"\t"+
					authority[i][2]+"\t"+
					authority[i][3];
		}
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == back) {
			MainInterface.logsSelecttoAdmin();
		}else if(e.getSource() == bt_Selete) {
			info = "\t时间\t\t事件\t关键字\t类别\n";
			if(cb_AdminBox.isSelected())
				setTextLogs("管理员变动");
			if(cb_UserBox.isSelected())
				setTextLogs("用户变动");
			if(cb_FacilityBox.isSelected())
				setTextLogs("设备变动");
			if(cb_ControlBox.isSelected())
				setTextLogs("控制变动");
			textArea.setText(info);
			
		}else if(e.getSource() == btn_submit) {
			if(cb_AdminBox.isSelected())
				FacilityManage.delete_Logs("管理员变动");
			if(cb_UserBox.isSelected())
				FacilityManage.delete_Logs("用户变动");
			if(cb_FacilityBox.isSelected())
				FacilityManage.delete_Logs("设备变动");
			if(cb_ControlBox.isSelected())
				FacilityManage.delete_Logs("控制变动");
			textArea.setText("");
			JOptionPane.showMessageDialog(null, "成功", "更新信息成功", JOptionPane.OK_CANCEL_OPTION);
		}
	}
}