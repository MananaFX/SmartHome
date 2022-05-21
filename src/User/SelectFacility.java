package User;

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
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import db.FacilityManage;
import db.PeopleManage;
import runPart.MainInterface;
import runPart.Properties;

import javax.swing.JCheckBox;
import javax.swing.JRadioButton;

public class SelectFacility extends JPanel implements ActionListener {
	private JButton back;
	private JButton bt_Selete;
	private JButton btn_submit;
	private static JTextArea textArea;
	private static String info;
	private JTextField inputAccount;
	private JRadioButton rb_Work;
	private JRadioButton rb_Fault;
	private JRadioButton  rb_AddFacility;
	private JRadioButton  rb_ChangeFacility;
	private JRadioButton  rb_DeleteFacility;

	/**
	 * Create the panel.
	 */
	public SelectFacility() {
		setBackground(new Color(152, 251, 152));
		setLayout(null);
		
		back = new JButton("\u8FD4\u56DE");
		back.setFont(new Font("宋体", Font.PLAIN, 26));
		back.setBounds(0, 0, 115, 82);
		add(back);
		back.addActionListener(this);
		
		textArea = new JTextArea();
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 20));
		textArea.setBounds(152, 313, 1066, 500);
		add(textArea);
		
		textArea.setEditable(false);
		
		bt_Selete = new JButton("\u663E\u793A\u8BBE\u5907");
		bt_Selete.setFont(new Font("宋体", Font.BOLD, 30));
		bt_Selete.setBounds(157, 222, 322, 70);
		add(bt_Selete);
		bt_Selete.addActionListener(this);
		
		inputAccount = new JTextField();
		inputAccount.setFont(new Font("宋体", Font.BOLD, 35));
		inputAccount.setColumns(10);
		inputAccount.setBounds(967, 140, 228, 70);
		add(inputAccount);
		
		btn_submit = new JButton("\u63D0\u4EA4");
		btn_submit.setFont(new Font("宋体", Font.BOLD, 35));
		btn_submit.setBounds(834, 220, 361, 70);
		add(btn_submit);
		btn_submit.addActionListener(this);
		
		JLabel account = new JLabel("\u8BBE\u5907\u7F16\u53F7\uFF1A");
		account.setFont(new Font("宋体", Font.BOLD, 35));
		account.setBounds(763, 147, 194, 55);
		add(account);
		
		rb_Work = new JRadioButton("\u6B63\u5E38\u8BBE\u5907");
		rb_Work.setSelected(true);
		rb_Work.setFont(new Font("宋体", Font.BOLD, 30));
		rb_Work.setBackground(new Color(152, 251, 152));
		rb_Work.setBounds(152, 158, 170, 37);
		add(rb_Work);
		
		rb_Fault = new JRadioButton("\u6545\u969C\u8BBE\u5907");
		rb_Fault.setSelected(true);
		rb_Fault.setFont(new Font("宋体", Font.BOLD, 30));
		rb_Fault.setBackground(new Color(152, 251, 152));
		rb_Fault.setBounds(324, 158, 170, 37);
		add(rb_Fault);
		
		ButtonGroup bg=new ButtonGroup();// 初始化按钮组
		bg.add(rb_Work);// 普通用户加入按钮组
		bg.add(rb_Fault);// 管理人员加入按钮组
		
		rb_AddFacility = new JRadioButton("\u6DFB\u52A0\u8BBE\u5907");
		rb_AddFacility.setSelected(false);
		rb_AddFacility.setFont(new Font("宋体", Font.BOLD, 30));
		rb_AddFacility.setBackground(new Color(152, 251, 152));
		rb_AddFacility.setBounds(587, 140, 170, 37);
		add(rb_AddFacility);
		
		rb_ChangeFacility = new JRadioButton("\u53D8\u66F4\u8BBE\u5907");
		rb_ChangeFacility.setSelected(false);
		rb_ChangeFacility.setFont(new Font("宋体", Font.BOLD, 30));
		rb_ChangeFacility.setBackground(new Color(152, 251, 152));
		rb_ChangeFacility.setBounds(587, 197, 170, 37);
		add(rb_ChangeFacility);
		
		rb_DeleteFacility = new JRadioButton("\u5220\u9664\u8BBE\u5907");
		rb_DeleteFacility.setSelected(false);
		rb_DeleteFacility.setFont(new Font("宋体", Font.BOLD, 30));
		rb_DeleteFacility.setBackground(new Color(152, 251, 152));
		rb_DeleteFacility.setBounds(587, 255, 170, 37);
		add(rb_DeleteFacility);
		
		ButtonGroup bf=new ButtonGroup();// 初始化按钮组
		bf.add(rb_AddFacility);
		bf.add(rb_ChangeFacility);
		bf.add(rb_DeleteFacility);
		
	}
	
	public static void setTextAreaWork() {
		info = "\t编号\t类别\t剩余保修期（月）\t所属房间";
		String[][] authority = FacilityManage.select_allrunFacility();
		for(int i=0;i<authority.length;i++) {
			info+="\n\t "+authority[i][0]+"\t"+
					authority[i][1]+"\t\t"+
					authority[i][2]+"\t"+
					authority[i][3]+"\t  ";
            
		}info+="\n\n\t正常设备共有：\t"+String.valueOf(authority.length)+" 个";
		textArea.setText(info);
	}
	
	public static void setTextAreaFault() {
		info = "\t编号\t类别\t剩余保修期（月）\t所属房间\t错误类型";
		String[][] authority = FacilityManage.select_allFaultFacility();
		
		for(int i=0;i<authority.length;i++) {
			info+="\n\t "+authority[i][0]+"\t"+
					authority[i][1]+"\t\t"+
					authority[i][2]+"\t"+
					authority[i][3]+"\t"+
					authority[i][4]+"\t  ";
		}info+="\n\n\t故障设备共有：\t"+String.valueOf(authority.length)+" 个";
		textArea.setText(info);
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == back) {
			MainInterface.FacilityChangetoUser();
		}else if(e.getSource() == bt_Selete) {
			if(rb_Work.isSelected())
				setTextAreaWork();
			else if(rb_Fault.isSelected())
				setTextAreaFault();
		}else if(e.getSource() == btn_submit) {
			String []authority = PeopleManage.select_SingleUserAuthority(Properties.user);
			boolean canAdd = Boolean.parseBoolean(authority[1]);
			boolean canDelete = Boolean.parseBoolean(authority[2]);
			boolean canControl = Boolean.parseBoolean(authority[3]);
			if(rb_AddFacility.isSelected()&&canAdd) {
				runPart.Properties.facilityNo=inputAccount.getText();
				AddFacility.setFacilityNo();
				MainInterface.SelectFacilitytoAddFacility();
			}else if(rb_ChangeFacility.isSelected()&&canControl) {
				String account = inputAccount.getText();
				String category = JOptionPane.showInputDialog("请输入要更改的属性(是否错误）");
				if(category.equals("编号"))
					category="FacilityNo";
				if(category.equals("类别"))
					category="Category";
				if(category.equals("所属房间"))
					category="RoomName";
				if(category.equals("是否错误"))
					category="isFault";
				if(category.equals("错误类型"))
					category="FaultType";	
				String newVaule = JOptionPane.showInputDialog("请输入新的值");
				if(newVaule.equals("是"))
					newVaule="true";
				if(newVaule.equals("否"))
					newVaule="false";
				FacilityManage.changeFacility(account, category, newVaule);
				inputAccount.setText("");
				JOptionPane.showMessageDialog(null, "成功", "删除设备成功", JOptionPane.OK_CANCEL_OPTION);
			}else if(rb_DeleteFacility.isSelected()&&canDelete) {
				String account = inputAccount.getText();
				FacilityManage.delete_Facility(account);
				inputAccount.setText("");
				JOptionPane.showMessageDialog(null, "成功", "删除设备成功", JOptionPane.OK_CANCEL_OPTION);
			}else if(rb_AddFacility.isSelected()||rb_ChangeFacility.isSelected()||rb_DeleteFacility.isSelected()){
				JOptionPane.showMessageDialog(null, "您的权限不足", "警告", JOptionPane.OK_CANCEL_OPTION);
			}

		}
	}
}