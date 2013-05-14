import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FriendPage extends javax.swing.JPanel 
{

	/**
	 * Friend screen
	 * Card 6
	 */
	private static final long serialVersionUID = 1L;
	private javax.swing.JButton nextButton;
	private javax.swing.JLabel textLabel;
	private JPanel contentPane;

	public FriendPage(JPanel cp) 
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
				addButton(ae);
			}
		});
		add(btnAddFriend);

		JButton btnGoBack = new JButton("Go back");
		btnGoBack.setBounds(240, 366, 120, 23);
		btnGoBack.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent ae)
			{
				cancelButton(ae);
			}
		});
		add(btnGoBack);

		JButton btnEventsPage = new JButton("Events Page");
		btnEventsPage.setBounds(60, 366, 120, 23);
		btnEventsPage.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent ae)
			{
				friendsButton(ae);
			}
		});
		add(btnEventsPage);
	}

	private void logoutButton(ActionEvent ae)
	{
		CardLayout layout = (CardLayout)contentPane.getLayout();
		layout.show(contentPane, "login");
	}

	private void addButton(ActionEvent ae)
	{
		CardLayout layout = (CardLayout)contentPane.getLayout();
		layout.show(contentPane, "addFriend");
	}

	private void cancelButton(ActionEvent ae)
	{
		CardLayout layout = (CardLayout)contentPane.getLayout();
		layout.show(contentPane, "eventPage");
	}

	private void friendsButton(ActionEvent ae)
	{
		CardLayout layout = (CardLayout)contentPane.getLayout();
		layout.show(contentPane, "friendPage");
	}
}
