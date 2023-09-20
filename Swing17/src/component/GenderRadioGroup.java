package component;

import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;

import theme.Colors;

@SuppressWarnings("serial")
public class GenderRadioGroup extends ButtonGroup {
	private JRadioButton[] buttons;
	
	public GenderRadioGroup() {
		String[] handles = {"Male", "Female"};
		buttons = new JRadioButton[handles.length];
		for (int i = 0; i < handles.length; i++) {
			buttons[i] = new JRadioButton(handles[i]);
			buttons[i].setBackground(Colors.backgroundPrimary);
			buttons[i].setActionCommand(handles[i]);
			add(buttons[i]);
		}
		buttons[0].setSelected(true);
	}
	
	public JRadioButton[] getButtons() {
		return buttons;
	}

}
