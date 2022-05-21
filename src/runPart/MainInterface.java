package runPart;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Admin.*;
import User.AddFacility;
import User.PersonalInformation;
import User.RunControl;
import User.SelectFacility;
import User.UserInterface;
import db.PeopleManage;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainInterface extends JFrame implements ActionListener{

	//Main����
	public static JPanel contentPane ;
	//Manager����
	
	public static AdminInterface adminJpanel = new AdminInterface();
	public static AuthorityChange AuthorityJPanel = new AuthorityChange();
	public static SelectUser userSelectJpanel = new SelectUser();
	public static SelectLogs logsJPanel = new SelectLogs();
	public static SecurityChange securityJPanel = new SecurityChange();
	//User����
	public static UserInterface userJPanel = new UserInterface();
	public static SelectFacility FacilityChangeJPanel = new SelectFacility();
	public static AddFacility addFacilityJPanel = new AddFacility();
	public static RunControl RunControlJPanel = new RunControl();
	public static PersonalInformation personalJPanel = new PersonalInformation();
	
	//�����洰��
	private JTextField tf_user;
	private JTextField tf_password;
	private JLabel label_user;
	private JLabel label_password;
	private JRadioButton rb_customer;
	private JRadioButton rb_manager;
	private JButton btn_login;
	private JButton btn_register;
	private JButton btn_changePassword;
	private JCheckBox securtiyCheckBox;
	private static boolean flage_Adminr = false;
	private static boolean flage_AuthorityChange = false;
	private static boolean flage_SelectUser = false;
	private static boolean flage_SelectLogs = false;
	private static boolean flage_SecurityUpdate = false;
	private static boolean flage_user = false;
	private static boolean flage_facilityChange = false;
	private static boolean flage_facilityChangeInfo = false;
	private static boolean flage_Control = false;
	private static boolean flage_personal = false;
	private boolean flage = false;
	private static Container container;
	private JLabel label;

	
	public MainInterface() {
		init();
	}
	
	//��ʼ������
	public void init() {
		
		//��ȡ����������
		container = getContentPane();
		
		//��ʼ��������
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1300, 1000);
		setResizable(true); 
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		container.add(contentPane);
		contentPane.setLayout(null);
		
		//�˺������
		tf_user = new JTextField();
		tf_user.setFont(new Font("����", Font.BOLD, 35));
		tf_user.setBounds(409, 248, 526, 75);
		contentPane.add(tf_user);
		tf_user.setColumns(10);
		
		//���������
		tf_password = new JTextField();
		tf_password.setFont(new Font("����", Font.BOLD, 35));
		tf_password.setColumns(10);
		tf_password.setBounds(409, 357, 526, 75);
		contentPane.add(tf_password);
		
		//�û�����ǩ
		label_user = new JLabel("\u8D26\u53F7\uFF1A");
		label_user.setFont(new Font("����", Font.BOLD, 35));
		label_user.setBounds(289, 261, 116, 48);
		contentPane.add(label_user);
		
		//�����ǩ
		label_password = new JLabel("\u5BC6\u7801\uFF1A");
		label_password.setFont(new Font("����", Font.BOLD, 35));
		label_password.setBounds(289, 370, 116, 48);
		contentPane.add(label_password);
		
		//��ͨ�û���ѡ��ť
		rb_customer = new JRadioButton("\u666E\u901A\u7528\u6237");
		rb_customer.setSelected(true);
		rb_customer.setFont(new Font("����", Font.BOLD, 30));
		rb_customer.setBackground(Color.WHITE);
		rb_customer.setBounds(409, 515, 170, 37);
		contentPane.add(rb_customer);
		
		//������Ա��ѡ��ť
		rb_manager = new JRadioButton("\u7BA1\u7406\u4EBA\u5458");
		rb_manager.setFont(new Font("����", Font.BOLD, 30));
		rb_manager.setBackground(Color.WHITE);
		rb_manager.setBounds(685, 515, 170, 37);
		contentPane.add(rb_manager);
		//��ѡ�ť��ӵ�һ����ť��
		ButtonGroup bg=new ButtonGroup();// ��ʼ����ť��
		bg.add(rb_customer);// ��ͨ�û����밴ť��
		bg.add(rb_manager);// ������Ա���밴ť��
		
		//�Ƿ�ӵ�а�����Ϣ
		securtiyCheckBox = new JCheckBox("\u662F\u5426\u62E5\u6709\u5B89\u9632\u4FE1\u606F");
		securtiyCheckBox.setBackground(Color.WHITE);
		securtiyCheckBox.setFont(new Font("����", Font.BOLD, 30));
		securtiyCheckBox.setBounds(931, 515, 312, 35);
		contentPane.add(securtiyCheckBox);
			
		
		//��¼��ť
		btn_login = new JButton("\u767B\u5F55");
		btn_login.setBackground(Color.LIGHT_GRAY);
		btn_login.setFont(new Font("����", Font.BOLD, 35));
		btn_login.setBounds(409, 634, 170, 48);
		contentPane.add(btn_login);
		btn_login.addActionListener(this);
		
		//ע�ᰴť
		btn_register = new JButton("\u6CE8\u518C");
		btn_register.setFont(new Font("����", Font.BOLD, 35));
		btn_register.setBackground(Color.LIGHT_GRAY);
		btn_register.setBounds(765, 634, 170, 48);
		contentPane.add(btn_register);
		btn_register.addActionListener(this);
		
		//�޸����밴ť
		btn_changePassword = new JButton("\u4FEE\u6539\u5BC6\u7801");
		btn_changePassword.setFont(new Font("����", Font.BOLD, 30));
		btn_changePassword.setBackground(Color.LIGHT_GRAY);
		btn_changePassword.setBounds(1011, 370, 170, 48);
		contentPane.add(btn_changePassword);
		btn_changePassword.addActionListener(this);	
		
		label = new JLabel("\u667a\u6167\u5bb6\u5ead\u7ba1\u7406\u7cfb\u7edf");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("����", Font.BOLD, 40));
		label.setBounds(329, 69, 594, 105);
		contentPane.add(label);
		
		
	}
	
	//�л����ں���
	//Main->Admin
	public static void MaintoAdmin() {
		if(!flage_Adminr) {
			contentPane.setVisible(false);
			container.add(adminJpanel);
			flage_Adminr = true;
		}else {
			contentPane.setVisible(false);
			adminJpanel.setVisible(true);
		}
	}
	//Admin->Main
	public static void adminrtoMain() {
		adminJpanel.setVisible(false);
		contentPane.setVisible(true);
	}
	
	
	//Admin->AuthorityChange
	public static void admintoAuthority() {
		if(!flage_AuthorityChange) {
			adminJpanel.setVisible(false);
			container.add(AuthorityJPanel);
			flage_AuthorityChange = true;
		}else {
			adminJpanel.setVisible(false);
			AuthorityJPanel.setVisible(true);
		}
	}
	//AuthorityChange->Admin
	public static void AuthoritytoAdmin() {
		AuthorityJPanel.setVisible(false);
		adminJpanel.setVisible(true);
	}
	
	
	//admin->SelectUser
	public static void admintoUserSelect() {
		if(!flage_SelectUser) {
			adminJpanel.setVisible(false);
			container.add(userSelectJpanel);
			flage_SelectUser = true;
		}else {
			adminJpanel.setVisible(false);
			userSelectJpanel.setVisible(true);
		}
	}
	//userSelectJpanel->admin
	public static void userSelecttoAdmin() {
		userSelectJpanel.setVisible(false);
		adminJpanel.setVisible(true);
	}
	
	//admin->SelectLogs
		public static void admintoLogsSelect() {
			if(!flage_SelectLogs) {
				adminJpanel.setVisible(false);
				container.add(logsJPanel);
				flage_SelectLogs = true;
			}else {
				adminJpanel.setVisible(false);
				logsJPanel.setVisible(true);
			}
		}
		//selectLogs->admin
		public static void logsSelecttoAdmin() {
			logsJPanel.setVisible(false);
			adminJpanel.setVisible(true);
		}
	
	//Admin->SecurityCHange
	public static void admintoSecurityChange() {
		if(!flage_SecurityUpdate) {
			adminJpanel.setVisible(false);
			container.add(securityJPanel);
			flage_SecurityUpdate = true;
		}else {
			adminJpanel.setVisible(false);
			securityJPanel.setVisible(true);
		}
	}
	//UpdateBook->Manager
	public static void SecuritytoAdmin() {
		securityJPanel.setVisible(false);
		adminJpanel.setVisible(true);
	}

	//Main->User
	public static void MaintoUser() {
		if(!flage_user) {
			contentPane.setVisible(false);
			container.add(userJPanel);
			flage_user = true;
		}else {
			contentPane.setVisible(false);
			userJPanel.setVisible(true);
		}
	}
	//User->Main
	public static void UsertoMain() {
		userJPanel.setVisible(false);
		contentPane.setVisible(true);
	}
	
	//User->Borrow
	public static void UsertoFacilityChange() {
		if(!flage_facilityChange) {
			userJPanel.setVisible(false);
			container.add(FacilityChangeJPanel);
			flage_facilityChange = true;
		}else {
			userJPanel.setVisible(false);
			FacilityChangeJPanel.setVisible(true);
		}
	}
	//Borrow->User
	public static void FacilityChangetoUser() {
		FacilityChangeJPanel.setVisible(false);
		userJPanel.setVisible(true);
	}
	
	//Borrow->BorrowInfo
	public static void SelectFacilitytoAddFacility() {
		if(!flage_facilityChangeInfo) {
			FacilityChangeJPanel.setVisible(false);
			container.add(addFacilityJPanel);
			flage_facilityChangeInfo = true;
		}else {
			addFacilityJPanel.setVisible(false);
			addFacilityJPanel.setVisible(true);
		}
	}
	//BorrowInfo->Borrow
	public static void AddFacilitytoSelectFacility() {
		addFacilityJPanel.setVisible(false);
		FacilityChangeJPanel.setVisible(true);
	}

	//User->Return
	public static void UsertoRunControl() {
		if(!flage_Control) {
			userJPanel.setVisible(false);
			container.add(RunControlJPanel);
			flage_Control = true;
		}else {
			userJPanel.setVisible(false);
			RunControlJPanel.setVisible(true);
		}
	}
	//Return->User
	public static void RunControltoUser() {
		RunControlJPanel.setVisible(false);
		userJPanel.setVisible(true);
	}

	//User->Personal
	public static void UsertoPersonal() {
		if(!flage_personal) {
			userJPanel.setVisible(false);
			container.add(personalJPanel);
			flage_personal = true;
		}else {
			userJPanel.setVisible(false);
			personalJPanel.setVisible(true);
		}
	}
	
	//Personal->User
	public static void PersonaltoUser() {
		personalJPanel.setVisible(false);
		userJPanel.setVisible(true);
	}
	
		
	//��¼ע���¼�����
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == btn_login) {
			//�����¼��ť
			//�ж��û��������Ƿ�Ϊ��
			if (tf_user.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "�û�������Ϊ��", "��¼ʧ��", JOptionPane.ERROR_MESSAGE);
			} else if (tf_password.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "���벻��Ϊ��", "��¼ʧ��", JOptionPane.ERROR_MESSAGE);
			}else {
				//�ж����û����ǹ���Ա
				if(rb_customer.isSelected()) {
					//�û�
					boolean isExist = PeopleManage.isExist_User(tf_user.getText(), tf_password.getText());
					if(isExist) {
						JOptionPane.showMessageDialog(null, "��ӭʹ��", "�û���¼�ɹ�", JOptionPane.OK_CANCEL_OPTION);
						Properties.user = tf_user.getText();
						UserInterface.setUser();
						MaintoUser();
					}else {
						JOptionPane.showMessageDialog(null, "��������ȷ���û�������", "�û���¼ʧ��", JOptionPane.ERROR_MESSAGE);
					}
				}else {
					//����Ա
					boolean isExist = PeopleManage.isExist_Admin(tf_user.getText(), tf_password.getText());
					if(isExist) {
						JOptionPane.showMessageDialog(null, "��ӭʹ��", "����Ա��¼�ɹ�", JOptionPane.OK_CANCEL_OPTION);
						Properties.admin = tf_user.getText();
						AdminInterface.setAdmin();
						MaintoAdmin();
					}else {
						JOptionPane.showMessageDialog(null, "��������ȷ���û�������", "����Ա��¼ʧ��", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		}else if(e.getSource() == btn_register) {
			//���ע�ᰴť
			//�ж��û��������Ƿ�Ϊ��
			if (tf_user.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "�û�������Ϊ��", "ע��ʧ��", JOptionPane.ERROR_MESSAGE);
			} else if (tf_password.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "���벻��Ϊ��", "ע��ʧ��", JOptionPane.ERROR_MESSAGE);
			}else {
				//�ж����û����ǹ���Ա
				String securityNo ="" ;
				String fingerPrint= "";
				String IrisNo="";
				if(securtiyCheckBox.isSelected()){
					securityNo = JOptionPane.showInputDialog("�����밲�����");
					fingerPrint = JOptionPane.showInputDialog("��ɨ��ָ��");
					IrisNo = JOptionPane.showInputDialog("��ɨ���Ĥ");
				}
				
				if(rb_customer.isSelected()) {
					boolean isExist = PeopleManage.isExist_User(tf_user.getText(), tf_password.getText());
					if(isExist) {
						JOptionPane.showMessageDialog(null, "���û��Ѿ�����", "�û�ע��ʧ��", JOptionPane.ERROR_MESSAGE);
					}else {
						JOptionPane.showMessageDialog(null, "��ӭ��", "�û�ע��ɹ�", JOptionPane.OK_CANCEL_OPTION);
						if(!securtiyCheckBox.isSelected())
							PeopleManage.regist_User(tf_user.getText(), tf_password.getText());
						else
							PeopleManage.regist_User_Security(tf_user.getText(), tf_password.getText(), securityNo,Integer.parseInt(fingerPrint),Integer.parseInt(IrisNo));
						
					}
				}else {
					boolean isExist = PeopleManage.isExist_Admin(tf_user.getText(), tf_password.getText());
					if(isExist) {
						JOptionPane.showMessageDialog(null, "�ù���Ա�Ѿ�����", "����Աע��ʧ��", JOptionPane.ERROR_MESSAGE);
					}else {
						JOptionPane.showMessageDialog(null, "��ӭ��", "����Աע��ɹ�", JOptionPane.OK_CANCEL_OPTION);
						PeopleManage.regist_Admin_Security(tf_user.getText(), tf_password.getText(), securityNo,Integer.parseInt(fingerPrint),Integer.parseInt(IrisNo));
					}
				}
			}
		} else if(e.getSource() == btn_changePassword) {
			if (tf_user.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "�û�������Ϊ��", "�޸�ʧ��", JOptionPane.ERROR_MESSAGE);
			} else if (tf_password.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "���벻��Ϊ��", "�޸�ʧ��", JOptionPane.ERROR_MESSAGE);
			}else {
				//�ж����û����ǹ���Ա
				if(rb_customer.isSelected()) {
					//�û�
					boolean isExist = PeopleManage.isExist_User(tf_user.getText(), tf_password.getText());
					if(isExist) {
						String newPassword = JOptionPane.showInputDialog("������������");
						if (!newPassword.equals("")) {
							PeopleManage.changePassword_User(tf_user.getText(),tf_password.getText(), newPassword);
							JOptionPane.showMessageDialog(null, "��ӭʹ��", "�޸�����ɹ�", JOptionPane.OK_CANCEL_OPTION);
						}else {
							JOptionPane.showMessageDialog(null, "���벻��Ϊ��", "�޸�����ʧ��", JOptionPane.ERROR_MESSAGE);
						}
					}else {
						JOptionPane.showMessageDialog(null, "��������ȷ���û�������", "�޸�����ʧ��", JOptionPane.ERROR_MESSAGE);
					}
				}else {
					//����Ա
					boolean isExist = PeopleManage.isExist_Admin(tf_user.getText(), tf_password.getText());
					if(isExist) {
						String newPassword = JOptionPane.showInputDialog("������������");
						if (!newPassword.equals("")) {
							PeopleManage.changePassword_Admin(tf_user.getText(),tf_password.getText(), newPassword);
							JOptionPane.showMessageDialog(null, "��ӭʹ��", "�޸�����ɹ�", JOptionPane.OK_CANCEL_OPTION);
						}else {
							JOptionPane.showMessageDialog(null, "���벻��Ϊ��", "�޸�����ʧ��", JOptionPane.ERROR_MESSAGE);
						}
					}else {
						JOptionPane.showMessageDialog(null, "��������ȷ���û�������", "�޸�����ʧ��", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		}
	}
}

