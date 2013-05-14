import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Main
{
    private JPanel contentPane;
    private login panel1;
    private regScreen panel2;
    private Calendar panel3;
    private CreateEvent panel4;
    private EventPage panel5;
    private FriendPage panel6;
    private AddFriend panel7;

    private void displayGUI()
    {
        JFrame frame = new JFrame("Kyle Strudwick");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel contentPane = new JPanel();
        contentPane.setBorder(
            BorderFactory.createEmptyBorder(10, 10, 10, 10));
        contentPane.setLayout(new CardLayout());
        contentPane.setPreferredSize(new Dimension(620, 420));

        panel1 = new login(contentPane);
        panel2 = new regScreen(contentPane);
        panel3 = new Calendar(contentPane);
        panel4 = new CreateEvent(contentPane);
        panel5 = new EventPage(contentPane);
        panel6 = new FriendPage(contentPane);
        panel7 = new AddFriend(contentPane);

        contentPane.add(panel1, "login"); 
        contentPane.add(panel2, "regScreen");  
        contentPane.add(panel3, "calendar"); 
        contentPane.add(panel4, "createEvent"); 
        contentPane.add(panel5, "eventPage"); 
        contentPane.add(panel6, "friendPage"); 
        contentPane.add(panel7, "addFriend"); 

        frame.setContentPane(contentPane);      
        frame.pack();   
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    public static void main(String... args)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                new Main().displayGUI();
            }
        });
    }
}
