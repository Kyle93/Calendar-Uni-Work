import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class EventPage extends javax.swing.JPanel 
{

    /**
	 * Event screen
	 * Card 5
	 */
	private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    public EventPage(JPanel cp) 
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
		
		JButton btnCreateEvent = new JButton("Create event");
		btnCreateEvent.setBounds(420, 366, 120, 23);
		btnCreateEvent.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent ae)
            {
                createButton(ae);
            }
        });
		add(btnCreateEvent);
		
		JButton btnCancelEvent = new JButton("Go back");
		btnCancelEvent.setBounds(240, 366, 120, 23);
		btnCancelEvent.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent ae)
            {
                cancelButton(ae);
            }
        });
		add(btnCancelEvent);
		
		JButton btnFriendsPage = new JButton("Friends Page");
		btnFriendsPage.setBounds(60, 366, 120, 23);
		btnFriendsPage.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent ae)
            {
                friendsButton(ae);
            }
        });
		add(btnFriendsPage);
    }
    
    private void logoutButton(ActionEvent ae)
    {
        CardLayout layout = (CardLayout)contentPane.getLayout();
        layout.show(contentPane, "login");
    }
    
    private void createButton(ActionEvent ae)
    {
        CardLayout layout = (CardLayout)contentPane.getLayout();
        layout.show(contentPane, "createEvent");
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
