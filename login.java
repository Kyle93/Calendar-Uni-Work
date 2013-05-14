import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;

public class login extends javax.swing.JPanel 
{	
    /**
	 *  Login card 
	 *  Card 1
	 */
	private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txtEmail;
    private JPasswordField passwordField;

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
        
        txtEmail = new JTextField();
        txtEmail.setBounds(300, 60, 190, 40);
        add(txtEmail);
        txtEmail.setColumns(10);
        
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
        
        JButton btnLogin = new JButton("Login!");
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
    }    
    
    private void loginButton(ActionEvent ae)
    {
    	String theEmail = txtEmail.getText();
        CardLayout layout = (CardLayout)contentPane.getLayout();
        layout.show(contentPane, "calendar");
    }
    
    private void regButton(ActionEvent ae)
    {
        CardLayout layout = (CardLayout)contentPane.getLayout();
        layout.show(contentPane, "regScreen");
    }
}
