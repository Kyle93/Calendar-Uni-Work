import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class regScreen extends javax.swing.JPanel 
{

  /**
	 * Registration screen
	 * Card 2
	 */
	// Original ones from the Card
	private static final long serialVersionUID = 1L;
	private javax.swing.JButton nextButton;
	private javax.swing.JLabel textLabel;
	private JPanel contentPane;
	private JPasswordField passwordField;
	private JTextField txtFirstName;
	private JTextField txtEmail;
	private JTextField txtLastName;

	public regScreen(JPanel cp) 
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
        
        JButton btnBack = new JButton("Go Back");
        btnBack.setBounds(300, 328, 89, 23);
        btnBack.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent ae)
            {
                backButton(ae);
            }
        });
        add(btnBack);
        
        JButton btnSubmit = new JButton("Submit");
        btnSubmit.setBounds(401, 328, 89, 23);
        btnSubmit.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent ae)
            {
                submitButton(ae);
            }
        });
        add(btnSubmit);
        
        JLabel lblFirstName = new JLabel("Please enter first name:");
        lblFirstName.setHorizontalAlignment(SwingConstants.RIGHT);
        lblFirstName.setBounds(50, 60, 250, 40);
        add(lblFirstName);
        
        JLabel lblLastName = new JLabel("Please enter last name:");
        lblLastName.setHorizontalAlignment(SwingConstants.RIGHT);
        lblLastName.setBounds(50, 120, 250, 40);
        add(lblLastName);
        
        JLabel lblEmail = new JLabel("Please enter your email address:");
        lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
        lblEmail.setBounds(50, 180, 250, 40);
        add(lblEmail);
        
        JLabel lblPassword = new JLabel("Please enter your password:");
        lblPassword.setHorizontalAlignment(SwingConstants.RIGHT);
        lblPassword.setBounds(50, 240, 250, 40);
        add(lblPassword);
        
        passwordField = new JPasswordField();
        passwordField.setBounds(300, 240, 190, 40);
        add(passwordField);
        
        txtFirstName = new JTextField();
        txtFirstName.setColumns(10);
        txtFirstName.setBounds(300, 61, 190, 40);
        add(txtFirstName);
        
        txtEmail = new JTextField();
        txtEmail.setColumns(10);
        txtEmail.setBounds(300, 180, 190, 40);
        add(txtEmail);
        
        txtLastName = new JTextField();
        txtLastName.setColumns(10);
        txtLastName.setBounds(300, 120, 190, 40);
        add(txtLastName);
	}

	private void backButton(ActionEvent ae)
    {
        CardLayout layout = (CardLayout)contentPane.getLayout();
        layout.show(contentPane, "login");
    }
    
    private void submitButton(ActionEvent ae)
    {
        CardLayout layout = (CardLayout)contentPane.getLayout();
        layout.show(contentPane, "calendar");
    }
}
