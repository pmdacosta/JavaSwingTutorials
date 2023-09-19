import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Toolbar extends JPanel implements ActionListener {
	private JButton[] buttons;
	private LayoutManager layoutManager;
	private MessageListener messageListener;

	public Toolbar() {

		layoutManager = new FlowLayout(FlowLayout.LEFT);
		setLayout(layoutManager);
		String[] labels = { "Hello", "Goodbye" };

		buttons = new JButton[labels.length];
		for (int i = 0; i < labels.length; i++) {
			buttons[i] = new JButton();
			buttons[i].setText(labels[i]);
			buttons[i].addActionListener(this);
			add(buttons[i]);
		}
	}

	public void setMessageListener(MessageListener messageListener) {
		this.messageListener = messageListener;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (messageListener == null) {
			return;
		}
		JButton button = (JButton) e.getSource();
		String label = button.getText();
		messageListener.messageEmmited(label + "\n");
	}

}
