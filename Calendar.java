import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;

public class Calendar extends javax.swing.JPanel 
{

	/**
	 * Calendar screen
	 * Card 3
	 */
	private static final long serialVersionUID = 1L;
	private javax.swing.JButton nextButton;
	private javax.swing.JLabel textLabel;
	private JPanel contentPane;

	String[] years = { "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025" };
	JComboBox comboBox = new JComboBox(years);
	String[] months = { "January", "February", "March", "April", "May", "June", "July", "August",
			"September", "October", "November", "December" };
	JList list = new JList(months);
	JScrollPane scrollPane_1 = new JScrollPane(list);
	CalendarModel model = new CalendarModel();
	JTable table = new JTable(model);

	public Calendar(JPanel cp) 
	{
		super();
		contentPane = cp;
		initComponents();
	}

	private void initComponents() 
	{
		setOpaque(true);
		setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		setBackground(Color.LIGHT_GRAY);
		setLayout(null);

		JButton btnEvents = new JButton("View events");
		btnEvents.setBounds(26, 70, 120, 23);
		btnEvents.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent ae)
            {
                eventsButton(ae);
            }
        });
		add(btnEvents);

		JButton btnFriends = new JButton("View friends");
		btnFriends.setBounds(26, 140, 120, 23);
		btnFriends.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent ae)
            {
                friendsButton(ae);
            }
        });
		add(btnFriends);

		JLabel lblEventsNotify = new JLabel("x event notifications");
		lblEventsNotify.setHorizontalAlignment(SwingConstants.CENTER);
		lblEventsNotify.setBounds(26, 100, 120, 23);
		add(lblEventsNotify);

		JLabel lblFriendsNotify = new JLabel("x friends notifications");
		lblFriendsNotify.setHorizontalAlignment(SwingConstants.CENTER);
		lblFriendsNotify.setBounds(26, 170, 120, 23);
		add(lblFriendsNotify);

		comboBox.setBounds(26, 204, 120, 20);
		comboBox.setSelectedIndex(0);
		comboBox.addItemListener(new ComboHandler());
		add(comboBox);

		scrollPane_1.setBounds(26, 239, 120, 122);
		list.setSelectedIndex(3);
		list.addListSelectionListener(new ListHandler());
		add(scrollPane_1);

		model.setMonth(comboBox.getSelectedIndex() + 1998, list.getSelectedIndex());

		table.setBounds(174, 239, 390, 122);
		table.setGridColor(Color.black);
		table.setShowGrid(true);
		add(table);
		
		JButton btnLogOut = new JButton("Log out!");
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

		setVisible(true);
	}

	public class ComboHandler implements ItemListener {
		public void itemStateChanged(ItemEvent e) {
			
		}
	}

	public class ListHandler implements ListSelectionListener {
		public void valueChanged(ListSelectionEvent e) {
			model.setMonth(comboBox.getSelectedIndex() + 1998, list.getSelectedIndex());
			table.repaint();
		}
	}
	
	private void eventsButton(ActionEvent ae)
    {
        CardLayout layout = (CardLayout)contentPane.getLayout();
        layout.show(contentPane, "eventPage");
    }
	
	private void friendsButton(ActionEvent ae)
    {
        CardLayout layout = (CardLayout)contentPane.getLayout();
        layout.show(contentPane, "friendPage");
    }
	
	private void logoutButton(ActionEvent ae)
    {
        CardLayout layout = (CardLayout)contentPane.getLayout();
        layout.show(contentPane, "login");
    }
}

class CalendarModel extends AbstractTableModel {
	String[] days = { "Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat" };

	int[] numDays = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	String[][] calendar = new String[7][7];

	public CalendarModel() {
		for (int i = 0; i < days.length; ++i)
			calendar[0][i] = days[i];
		for (int i = 1; i < 7; ++i)
			for (int j = 0; j < 7; ++j)
				calendar[i][j] = " ";
	}

	public int getRowCount() {
		return 7;
	}

	public int getColumnCount() {
		return 7;
	}

	public Object getValueAt(int row, int column) {
		return calendar[row][column];
	}

	public void setValueAt(Object value, int row, int column) {
		calendar[row][column] = (String) value;
	}

	public void setMonth(int year, int month) {
		for (int i = 1; i < 7; ++i)
			for (int j = 0; j < 7; ++j)
				calendar[i][j] = " ";
		java.util.GregorianCalendar cal = new java.util.GregorianCalendar();
		cal.set(year, month, 1);
		int offset = cal.get(java.util.GregorianCalendar.DAY_OF_WEEK) - 1;
		offset += 7;
		int num = daysInMonth(year, month);
		for (int i = 0; i < num; ++i) {
			calendar[offset / 7][offset % 7] = Integer.toString(i + 1);
			++offset;
		}
	}

	public boolean isLeapYear(int year) {
		if (year % 4 == 0)
			return true;
		return false;
	}

	public int daysInMonth(int year, int month) {
		int days = numDays[month];
		if (month == 1 && isLeapYear(year))
			++days;
		return days;
	}
}
