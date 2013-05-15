import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.BorderFactory;
import javax.swing.InputVerifier;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class login extends javax.swing.JPanel
{	
	/**
	 *  Login card 
	 *  Card 1
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPasswordField passwordField;
	public static final Pattern VALID_EMAIL =  Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
	JCheckBox chckbxValid = new JCheckBox("Valid");
	String theEmail = new String("");
	JButton btnLogin = new JButton("Login!");

	public login(JPanel cp) 
	{
		this.contentPane = cp;
		initComponents();
	}

	private void initComponents() 
	{
		setOpaque(true);
		setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		setBackground(Color.LIGHT_GRAY);
		setLayout(null);

		JLabel lblLogo = new JLabel("Logo");
		lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogo.setBounds(10, 10, 580, 40);
		add(lblLogo);

		JLabel lblNewLabel = new JLabel("Please enter eMail address:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(50, 60, 250, 40);
		add(lblNewLabel);

		JLabel txtPassword = new JLabel("Please enter your password:");
		txtPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		txtPassword.setBounds(50, 130, 250, 40);
		add(txtPassword);

		passwordField = new JPasswordField();
		passwordField.setBounds(300, 130, 190, 40);
		add(passwordField);

		JLabel lblRemember = new JLabel("Remember me? (Do not check if on shared PC)");
		lblRemember.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRemember.setBounds(50, 200, 250, 40);
		add(lblRemember);

		JCheckBox chckbxRemember = new JCheckBox("Yes(Ticked) No(Blank)");
		chckbxRemember.setBackground(Color.LIGHT_GRAY);
		chckbxRemember.setBounds(300, 209, 190, 23);
		add(chckbxRemember);

		btnLogin.setEnabled(false);
		btnLogin.setBounds(230, 270, 140, 40);
		btnLogin.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent ae)
			{
				loginButton(ae);
			}
		});
		add(btnLogin);

		JButton btnCreate = new JButton("Create an account");
		btnCreate.setBounds(230, 340, 140, 40);
		btnCreate.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent ae)
			{
				regButton(ae);
			}
		});
		add(btnCreate);

		JFormattedTextField fmtEmail = new JFormattedTextField();
		fmtEmail.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				char newChar = e.getKeyChar();
				int exKey = e.getExtendedKeyCode();
				if( exKey == 16 ){
					
				}else if( newChar == '' ){
					int length = new StringBuffer(theEmail).length();
					if(length != 0){
						theEmail = new StringBuffer(theEmail).deleteCharAt(length-1).toString();
					}
				}else{
					theEmail = new StringBuffer(theEmail).append(newChar).toString();
				}
				boolean isValidEmail = validate(theEmail);
				if(isValidEmail == true){
					chckbxValid.setSelected(true);
				}
			}
		});
		fmtEmail.setBounds(300, 60, 190, 40);
		add(fmtEmail);
		chckbxValid.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent arg0) {
				ableToLogin();
			}
		});

		chckbxValid.setEnabled(false);
		chckbxValid.setBounds(493, 69, 97, 23);
		add(chckbxValid);
		
		ableToLogin();
	}    

	private void ableToLogin(){
		boolean okPW = checkPW();
		boolean okEmail = checkEmail();
		if( okPW == true && okEmail == true ){
			btnLogin.setEnabled(true);
		}else{
			btnLogin.setEnabled(false);
		}
	}

	private boolean checkPW(){

		return true;
	}

	private boolean checkEmail(){
		boolean isChecked = false;
		isChecked = chckbxValid.isSelected();
		return isChecked;
	}

	private void loginButton(ActionEvent ae)
	{
		CardLayout layout = (CardLayout)contentPane.getLayout();
		layout.show(contentPane, "calendar");
	}

	private void regButton(ActionEvent ae)
	{
		CardLayout layout = (CardLayout)contentPane.getLayout();
		layout.show(contentPane, "regScreen");
	}

	public static boolean validate(String emailStr) {
		Matcher matcher = VALID_EMAIL.matcher(emailStr);
		return matcher.find();
	}
}
