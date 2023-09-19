import java.awt.FlowLayout;
import java.awt.LayoutManager;

import javax.swing.JButton;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Toolbar extends JPanel {
	private JButton[] buttons;
	private LayoutManager layoutManager;

	public Toolbar() {
		layoutManager = new FlowLayout(FlowLayout.LEFT);
		setLayout(layoutManager);
		String[] labels = {"Hello","Goodbye"};

		buttons = new JButton[labels.length];
		for (int i = 0; i < labels.length; i++) {
			buttons[i] = new JButton();
			buttons[i].setText(labels[i]);
			add(buttons[i]);
		}

	}
}
