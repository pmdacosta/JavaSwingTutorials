import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

import events.FormEvent;
import interfaces.FormSubmitListener;

@SuppressWarnings("serial")
public class FormPanel extends JPanel {
	private final int BORDER_TOP = 5;
	private final int BORDER_BOTTOM = 5;
	private final int BORDER_LEFT = 5;
	private final int BORDER_RIGHT = 5;
	private final int COLUMNS = 10;
	
	private JLabel nameLabel;
	private JLabel occupationLabel;
	private JTextField nameField;
	private JTextField occupationField;
	private JButton submitButton;
	private FormSubmitListener formSubmitListener;

	public FormPanel() {
		setPreferredSize(new Dimension(250, getHeight()));
		
		nameLabel = new JLabel("Name: ");
		occupationLabel = new JLabel("Occupation: ");
		
		nameField = new JTextField(COLUMNS);
		occupationField = new JTextField(COLUMNS);
		
		submitButton = new JButton("SUBMIT");
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = nameField.getText();
				String occupation = occupationField.getText();
				
				FormEvent event = new FormEvent(name, occupation);
				if(formSubmitListener != null) {
					formSubmitListener.formSubmitted(event);
				}
			}
		});

		Border insideBorder = BorderFactory.createTitledBorder("Add Person");
		Border outsideBorder = BorderFactory.createEmptyBorder(BORDER_TOP, BORDER_LEFT, BORDER_BOTTOM, BORDER_RIGHT);
		setBorder(BorderFactory.createCompoundBorder(outsideBorder, insideBorder));
		
		setLayout(new GridBagLayout());
		
		GridBagConstraints gbc = new GridBagConstraints();

		gbc.fill = GridBagConstraints.NONE;

		// FIRST ROW
		gbc.weighty = 1;

		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.LINE_END;
		gbc.insets = new Insets(0, 0, 0, 10);
		add(nameLabel, gbc);

		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.insets = new Insets(0, 0, 0, 0);
		add(nameField, gbc);

		// SECOND ROW
		gbc.weighty = 1;

		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.anchor = GridBagConstraints.LINE_END;
		gbc.insets = new Insets(0, 0, 0, 10);
		add(occupationLabel, gbc);

		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.insets = new Insets(0, 0, 0, 0);
		add(occupationField, gbc);

		// THIRD ROW
		gbc.weighty = 80;

		gbc.gridx = 1;
		gbc.gridy = 3;
		gbc.anchor = GridBagConstraints.FIRST_LINE_START;
		add(submitButton, gbc);
		
	}
	
	public void setFormSubmitListener(FormSubmitListener formSubmitListener) {
		this.formSubmitListener = formSubmitListener;
	}
}
