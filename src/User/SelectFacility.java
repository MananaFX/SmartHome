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
		back.setFont(new Font("����", Font.PLAIN, 26));
		back.setBounds(0, 0, 115, 82);
		add(back);
		back.addActionListener(this);
		
		textArea = new JTextArea();
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 20));
		textArea.setBounds(152, 313, 1066, 500);
		add(textArea);
		
		textArea.setEditable(false);
		
		bt_Selete = new JButton("\u663E\u793A\u8BBE\u5907");
		bt_Selete.setFont(new Font("����", Font.BOLD, 30));
		bt_Selete.setBounds(157, 222, 322, 70);
		add(bt_Selete);
		bt_Selete.addActionListener(this);
		
		inputAccount = new JTextField();
		inputAccount.setFont(new Font("����", Font.BOLD, 35));
		inputAccount.setColumns(10);
		inputAccount.setBounds(967, 140, 228, 70);
		add(inputAccount);
		
		btn_submit = new JButton("\u63D0\u4EA4");
		btn_submit.setFont(new Font("����", Font.BOLD, 35));
		btn_submit.setBounds(834, 220, 361, 70);
		add(btn_submit);
		btn_submit.addActionListener(this);
		
		JLabel account = new JLabel("\u8BBE\u5907\u7F16\u53F7\uFF1A");
		account.setFont(new Font("����", Font.BOLD, 35));
		account.setBounds(763, 147, 194, 55);
		add(account);
		
		rb_Work = new JRadioButton("\u6B63\u5E38\u8BBE\u5907");
		rb_Work.setSelected(true);
		rb_Work.setFont(new Font("����", Font.BOLD, 30));
		rb_Work.setBackground(new Color(152, 251, 152));
		rb_Work.setBounds(152, 158, 170, 37);
		add(rb_Work);
		
		rb_Fault = new JRadioButton("\u6545\u969C\u8BBE\u5907");
		rb_Fault.setSelected(true);
		rb_Fault.setFont(new Font("����", Font.BOLD, 30));
		rb_Fault.setBackground(new Color(152, 251, 152));
		rb_Fault.setBounds(324, 158, 170, 37);
		add(rb_Fault);
		
		ButtonGroup bg=new ButtonGroup();// ��ʼ����ť��
		bg.add(rb_Work);// ��ͨ�û����밴ť��
		bg.add(rb_Fault);// ������Ա���밴ť��
		
		rb_AddFacility = new JRadioButton("\u6DFB\u52A0\u8BBE\u5907");
		rb_AddFacility.setSelected(false);
		rb_AddFacility.setFont(new Font("����", Font.BOLD, 30));
		rb_AddFacility.setBackground(new Color(152, 251, 152));
		rb_AddFacility.setBounds(587, 140, 170, 37);
		add(rb_AddFacility);
		
		rb_ChangeFacility = new JRadioButton("\u53D8\u66F4\u8BBE\u5907");
		rb_ChangeFacility.setSelected(false);
		rb_ChangeFacility.setFont(new Font("����", Font.BOLD, 30));
		rb_ChangeFacility.setBackground(new Color(152, 251, 152));
		rb_ChangeFacility.setBounds(587, 197, 170, 37);
		add(rb_ChangeFacility);
		
		rb_DeleteFacility = new JRadioButton("\u5220\u9664\u8BBE\u5907");
		rb_DeleteFacility.setSelected(false);
		rb_DeleteFacility.setFont(new Font("����", Font.BOLD, 30));
		rb_DeleteFacility.setBackground(new Color(152, 251, 152));
		rb_DeleteFacility.setBounds(587, 255, 170, 37);
		add(rb_DeleteFacility);
		
		ButtonGroup bf=new ButtonGroup();// ��ʼ����ť��
		bf.add(rb_AddFacility);
		bf.add(rb_ChangeFacility);
		bf.add(rb_DeleteFacility);
		
	}
	
	public static void setTextAreaWork() {
		info = "\t���\t���\tʣ�ౣ���ڣ��£�\t��������";
		String[][] authority = FacilityManage.select_allrunFacility();
		for(int i=0;i<authority.length;i++) {
			info+="\n\t "+authority[i][0]+"\t"+
					authority[i][1]+"\t\t"+
					authority[i][2]+"\t"+
					authority[i][3]+"\t  ";
            
		}info+="\n\n\t�����豸���У�\t"+String.valueOf(authority.length)+" ��";
		textArea.setText(info);
	}
	
	public static void setTextAreaFault() {
		info = "\t���\t���\tʣ�ౣ���ڣ��£�\t��������\t��������";
		String[][] authority = FacilityManage.select_allFaultFacility();
		
		for(int i=0;i<authority.length;i++) {
			info+="\n\t "+authority[i][0]+"\t"+
					authority[i][1]+"\t\t"+
					authority[i][2]+"\t"+
					authority[i][3]+"\t"+
					authority[i][4]+"\t  ";
		}info+="\n\n\t�����豸���У�\t"+String.valueOf(authority.length)+" ��";
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
				String category = JOptionPane.showInputDialog("������Ҫ���ĵ�����(�Ƿ����");
				if(category.equals("���"))
					category="FacilityNo";
				if(category.equals("���"))
					category="Category";
				if(category.equals("��������"))
					category="RoomName";
				if(category.equals("�Ƿ����"))
					category="isFault";
				if(category.equals("��������"))
					category="FaultType";	
				String newVaule = JOptionPane.showInputDialog("�������µ�ֵ");
				if(newVaule.equals("��"))
					newVaule="true";
				if(newVaule.equals("��"))
					newVaule="false";
				FacilityManage.changeFacility(account, category, newVaule);
				inputAccount.setText("");
				JOptionPane.showMessageDialog(null, "�ɹ�", "ɾ���豸�ɹ�", JOptionPane.OK_CANCEL_OPTION);
			}else if(rb_DeleteFacility.isSelected()&&canDelete) {
				String account = inputAccount.getText();
				FacilityManage.delete_Facility(account);
				inputAccount.setText("");
				JOptionPane.showMessageDialog(null, "�ɹ�", "ɾ���豸�ɹ�", JOptionPane.OK_CANCEL_OPTION);
			}else if(rb_AddFacility.isSelected()||rb_ChangeFacility.isSelected()||rb_DeleteFacility.isSelected()){
				JOptionPane.showMessageDialog(null, "����Ȩ�޲���", "����", JOptionPane.OK_CANCEL_OPTION);
			}

		}
	}
}