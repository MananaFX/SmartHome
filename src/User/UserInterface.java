package User;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import runPart.MainInterface;
import runPart.Properties;


public class UserInterface extends JPanel implements ActionListener{
	private JButton back;
	private JLabel label;
	private static JLabel lb_user;
	private JButton btn_return;
	private JButton btn_FacilityControl;
	private JButton btn_personal;

	/**
	 * Create the panel.
	 */
	public UserInterface() {
		setBackground(new Color(0, 191, 255));
		setLayout(null);
		
		back = new JButton("\u8FD4\u56DE");
		back.setFont(new Font("宋体", Font.PLAIN, 26));
		back.setBounds(0, 0, 115, 82);
		add(back);
		back.addActionListener(this);
		
		label = new JLabel("\u7528\u6237\u754C\u9762");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("宋体", Font.BOLD, 40));
		label.setBounds(512, 47, 294, 105);
		add(label);
		
		lb_user = new JLabel("New label");
		lb_user.setHorizontalAlignment(SwingConstants.CENTER);
		lb_user.setFont(new Font("宋体", Font.BOLD, 28));
		lb_user.setBounds(944, 0, 356, 56);
		add(lb_user);
		
		btn_FacilityControl = new JButton("\u8BBE\u5907\u63A7\u5236");
		btn_FacilityControl.setFont(new Font("宋体", Font.BOLD, 40));
		btn_FacilityControl.setBounds(105, 233, 280, 505);
		add(btn_FacilityControl);
		btn_FacilityControl.addActionListener(this);
		
		btn_return = new JButton("\u8FD0\u884C\u7BA1\u7406");
		btn_return.setFont(new Font("宋体", Font.BOLD, 40));
		btn_return.setBounds(526, 233, 280, 505);
		add(btn_return);
		btn_return.addActionListener(this);
		
		btn_personal = new JButton("\u4E2A\u4EBA\u4FE1\u606F");
		btn_personal.setFont(new Font("宋体", Font.BOLD, 40));
		btn_personal.setBounds(947, 233, 280, 505);
		add(btn_personal);
		btn_personal.addActionListener(this);

	}

	public static void setUser() {
		lb_user.setText("当前用户："+Properties.user);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == back) {
			MainInterface.UsertoMain();
		}else if(e.getSource() == btn_FacilityControl){
			MainInterface.UsertoFacilityChange();
		}else if(e.getSource() == btn_return) {
			RunControl.setUser();
			MainInterface.UsertoRunControl();

		}else if(e.getSource() == btn_personal) {
			PersonalInformation.setTextArea();
			MainInterface.UsertoPersonal();
		}
		
	}
}

