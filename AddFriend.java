import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JTextArea;

public class AddFriend extends javax.swing.JPanel 
{

    /**
	 * Create Event Screen
	 * Card 4
	 */
	private static final long serialVersionUID = 1L;
    private JPanel contentPane;
	private JTextField txtFirst;
	private JTextField txtEmail;
	private JTextField txtLast;

    public AddFriend(JPanel cp) 
    {
        contentPane = cp;
        initComponents();
    }

    private void initComponents() 
    {
    	setOpaque(true);
		setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		setBackground(Color.LIGHT_GRAY);
		setLayout(null);
		
		JButton btnLogOut = new JButton("Log out");
		btnLogOut.setBounds(500, 10, 89, 23);
		btnLogOut.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent ae)
            {
                logoutButton(ae);
            }
        });
		add(btnLogOut);
		
		JButton btnAddFriend = new JButton("Add friend");
		btnAddFriend.setBounds(420, 366, 120, 23);
		btnAddFriend.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent ae)
            {
                addFriend(ae);
            }
        });
		add(btnAddFriend);
		
		JButton btnCancelFriend = new JButton("Cancel friend");
		btnCancelFriend.setBounds(240, 366, 120, 23);
		btnCancelFriend.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent ae)
            {
                cancelButton(ae);
            }
        });
		add(btnCancelFriend);
		
		JButton btnFriends = new JButton("Events page");
		btnFriends.setBounds(60, 366, 120, 23);
		btnFriends.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent ae)
            {
                eventsButton(ae);
            }
        });
		add(btnFriends);
		
		JLabel lblNewLabel = new JLabel("Enter first name:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(50, 60, 250, 40);
		add(lblNewLabel);
		
		txtFirst = new JTextField();
		txtFirst.setBounds(300, 60, 190, 40);
		add(txtFirst);
		txtFirst.setColumns(10);
		
		JLabel lblDesc = new JLabel("Enter last name:");
		lblDesc.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDesc.setBounds(50, 111, 250, 40);
		add(lblDesc);
		
		JLabel lblEnterEmailTo = new JLabel("Enter user email:");
		lblEnterEmailTo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEnterEmailTo.setBounds(50, 162, 250, 40);
		add(lblEnterEmailTo);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(300, 162, 190, 40);
		add(txtEmail);
		
		txtLast = new JTextField();
		txtLast.setColumns(10);
		txtLast.setBounds(300, 111, 190, 40);
		add(txtLast);
    }
    
    private void logoutButton(ActionEvent ae)
    {
        CardLayout layout = (CardLayout)contentPane.getLayout();
        layout.show(contentPane, "login");
    }
    
    private void addFriend(ActionEvent ae)
    {
        CardLayout layout = (CardLayout)contentPane.getLayout();
        layout.show(contentPane, "calendar");
    }
    
    private void cancelButton(ActionEvent ae)
    {
        CardLayout layout = (CardLayout)contentPane.getLayout();
        layout.show(contentPane, "friendPage");
    }
    
    private void eventsButton(ActionEvent ae)
    {
        CardLayout layout = (CardLayout)contentPane.getLayout();
        layout.show(contentPane, "eventPage");
    }
}
