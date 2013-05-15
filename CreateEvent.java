import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class CreateEvent extends javax.swing.JPanel 
{

    /**
	 * Create Event Screen
	 * Card 4
	 */
	private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    String[] days = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20"
    		, "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
	JComboBox comboDays = new JComboBox(days);
	String[] months = { "January", "February", "March", "April", "May", "June", "July", "August",
			"September", "October", "November", "December" };
	JComboBox comboMonths = new JComboBox(months);
    String[] years = { "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025" };
	JComboBox comboYears = new JComboBox(years);
	
	String[] someNames = { "Kyle Strudwick", "George", "John Smith" };
	JList canInvite = new JList(someNames);
	JScrollPane scrollPane_1 = new JScrollPane();
	
	private JTextField txtEventName;

    public CreateEvent(JPanel cp) 
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
		
		JButton btnCancelEvent = new JButton("Cancel event");
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
		
		comboDays.setBounds(300, 281, 49, 20);
		comboDays.setSelectedIndex(0);
		comboDays.addItemListener(new ComboHandlerDays());
		add(comboDays);
		
		comboMonths.setBounds(359, 281, 108, 20);
		comboMonths.setSelectedIndex(0);
		comboMonths.addItemListener(new ComboHandlerMonths());
		add(comboMonths);
		
		comboYears.setBounds(475, 281, 49, 20);
		comboYears.setSelectedIndex(0);
		comboYears.addItemListener(new ComboHandlerYears());
		add(comboYears);
		
		
		JLabel lblNewLabel = new JLabel("Enter event name:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(50, 60, 250, 40);
		add(lblNewLabel);
		
		txtEventName = new JTextField();
		txtEventName.setBounds(300, 60, 190, 40);
		add(txtEventName);
		txtEventName.setColumns(10);
		
		JLabel lblDesc = new JLabel("Enter event description:");
		lblDesc.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDesc.setBounds(50, 111, 250, 40);
		add(lblDesc);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(300, 119, 190, 90);
		add(textArea);
		
		JLabel lblEnterEmailTo = new JLabel("Enter email to invite:");
		lblEnterEmailTo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEnterEmailTo.setBounds(50, 225, 250, 40);
		add(lblEnterEmailTo);
		
		JLabel lblEnterDate = new JLabel("Enter date:");
		lblEnterDate.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEnterDate.setBounds(50, 276, 250, 40);
		add(lblEnterDate);
		
		scrollPane_1.setBounds(300, 220, 190, 40);
		add(scrollPane_1);
		scrollPane_1.setViewportView(canInvite);
		canInvite.setSelectedIndex(3);
		canInvite.addListSelectionListener(new friendsHandle());
    }
    
    public class ComboHandlerDays implements ItemListener {
		public void itemStateChanged(ItemEvent e) {
			// Do on change
		}
	}
    public class ComboHandlerMonths implements ItemListener {
		public void itemStateChanged(ItemEvent e) {
			// Do on change
		}
	}
    public class ComboHandlerYears implements ItemListener {
		public void itemStateChanged(ItemEvent e) {
			// Do on change
		}
	}
    
    public class friendsHandle implements ListSelectionListener {
		public void valueChanged(ListSelectionEvent e) {
		}
	}
    
    private void logoutButton(ActionEvent ae)
    {
        CardLayout layout = (CardLayout)contentPane.getLayout();
        layout.show(contentPane, "login");
    }
    
    private void createButton(ActionEvent ae)
    {
        CardLayout layout = (CardLayout)contentPane.getLayout();
        layout.show(contentPane, "calendar");
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
