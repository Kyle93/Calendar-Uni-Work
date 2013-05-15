import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import javax.swing.JScrollPane;
import java.awt.Component;
import javax.swing.DefaultComboBoxModel;

public class EventPage extends javax.swing.JPanel 
{

	/**
	 * Event screen
	 * Card 5
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	String[] years = { "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025" };
	JComboBox comboBox = new JComboBox(years);
	JComboBox upcoming = new JComboBox();
	String[] months = { "January", "February", "March", "April", "May", "June", "July", "August",
			"September", "October", "November", "December" };
	JList list = new JList(months);
	JScrollPane scrollPane_1 = new JScrollPane(list);
	CalendarModel model = new CalendarModel();
	JTable table = new JTable(model);

	public EventPage(JPanel cp) 
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

		table.setBounds(174, 239, 390, 122);
		table.setGridColor(Color.black);
		table.setShowGrid(true);
		add(table);

		comboBox.setBounds(26, 204, 120, 20);
		comboBox.setSelectedIndex(0);
		comboBox.addItemListener(new ComboHandler());
		add(comboBox);
		
		upcoming.setModel(new DefaultComboBoxModel(new String[] {"Upcoming Events"}));
		upcoming.setBounds(26, 20, 120, 20);
		upcoming.addItemListener(new upcomingHandle());
		add(upcoming);

		scrollPane_1.setBounds(26, 239, 120, 122);
		list.setSelectedIndex(3);
		list.addListSelectionListener(new ListHandler());
		add(scrollPane_1);

		model.setMonth(comboBox.getSelectedIndex() + 1998, list.getSelectedIndex());

		JLabel label = new JLabel("Todays events");
		label.setBackground(Color.LIGHT_GRAY);
		label.setBounds(178, 68, 390, 89);
		add(label);
		
		setVisible(true);
	}

	public class ComboHandler implements ItemListener {
		public void itemStateChanged(ItemEvent e) {
			model.setMonth(comboBox.getSelectedIndex() + 1998, list.getSelectedIndex());
			table.repaint();
		}
	}
	
	public class upcomingHandle implements ItemListener {
		public void itemStateChanged(ItemEvent e) {
			
			table.repaint();
		}
	}

	public class ListHandler implements ListSelectionListener {
		public void valueChanged(ListSelectionEvent e) {
			model.setMonth(comboBox.getSelectedIndex() + 1998, list.getSelectedIndex());
			table.repaint();
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
		layout.show(contentPane, "createEvent");
	}

	private void cancelButton(ActionEvent ae)
	{
		CardLayout layout = (CardLayout)contentPane.getLayout();
		layout.show(contentPane, "calendar");
	}

	private void friendsButton(ActionEvent ae)
	{
		CardLayout layout = (CardLayout)contentPane.getLayout();
		layout.show(contentPane, "friendPage");
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
		offset += 5;
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
