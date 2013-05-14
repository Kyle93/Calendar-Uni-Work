import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class EventPage extends javax.swing.JPanel 
{

    /**
   * Event screen
	 * Card 5
	 */
	private static final long serialVersionUID = 1L;
	private javax.swing.JButton nextButton;
    private javax.swing.JLabel textLabel;
    private JPanel contentPane;

    public EventPage(JPanel cp) 
    {
        contentPane = cp;
        initComponents();
    }

    private void initComponents() 
    {

        setOpaque(true);
        setBackground(Color.RED.darker().darker());
        setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        textLabel = new JLabel("this is the fith card", JLabel.CENTER);
        textLabel.setForeground(Color.WHITE);
        nextButton = new javax.swing.JButton();

        nextButton.setText("To start");
        nextButton.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent evt) 
            {
                jButton1ActionPerformed(evt);
            }
        });

        add(textLabel);
        add(nextButton);
    }

    private void jButton1ActionPerformed(ActionEvent evt) 
    {
        CardLayout layout = (CardLayout) contentPane.getLayout();
        layout.show(contentPane, "friendPage");
    }
}
