import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

@SuppressWarnings("serial")
public class FormPanel extends JPanel {
	private final int BORDER_TOP = 5;
	private final int BORDER_BOTTOM = 5;
	private final int BORDER_LEFT = 5;
	private final int BORDER_RIGHT = 5;

	public FormPanel() {
		setPreferredSize(new Dimension(250, getHeight()));

		Border insideBorder = BorderFactory.createTitledBorder("Add Person");
		Border outsideBorder = BorderFactory.createEmptyBorder(BORDER_TOP, BORDER_LEFT, BORDER_BOTTOM, BORDER_RIGHT);
		setBorder(BorderFactory.createCompoundBorder(outsideBorder, insideBorder));
	}
}
