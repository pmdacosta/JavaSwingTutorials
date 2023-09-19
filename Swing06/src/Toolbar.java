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
	private TextPanel textPanel;

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

	public void setTextPanel(TextPanel textPanel) {
		this.textPanel = textPanel;
	}

	public void actionPerformed(ActionEvent e) {
		// Nothing to do if the TextPanel is not set
		if (textPanel == null) {
			return;
		}

		JButton button = (JButton) e.getSource();
		String label = button.getText();
		textPanel.append(label + "\n");
	}
}
