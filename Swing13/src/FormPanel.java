import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
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
	private JList<String> ageList;

	private FormSubmitListener formSubmitListener;

	public FormPanel() {
		setPreferredSize(new Dimension(250, getHeight()));
		setBackground(new Color(255,255,179));

		nameLabel = new JLabel("Name: ");
		occupationLabel = new JLabel("Occupation: ");
		nameField = new JTextField(COLUMNS);
		occupationField = new JTextField(COLUMNS);
		submitButton = new JButton("SUBMIT");
		ageList = new JList<String>();

		setupList();
		setupActionListeners();
		drawBorder();
		setupGrid();
	}
	
	private void setupList() {
		String elements[] = {"under 18", "18 to 65", "over 65"};
		DefaultListModel<String> ageModel = new DefaultListModel<String>();
		for (int i = 0; i < elements.length; i++) {
			ageModel.addElement(elements[i]);
		}

		// Set list values
		ageList.setModel(ageModel);
		
		// Set the list size
		ageList.setPreferredSize(new Dimension(110, 66));
		
		// Set the list's looks
		ageList.setBorder(BorderFactory.createEtchedBorder());
		Color backgroundColor = new Color(179,179,255);
		ageList.setBackground(backgroundColor);
		ageList.setSelectionBackground(backgroundColor.darker());
		
		// Set the default value for the list
		ageList.setSelectedIndex(0);
		
	}

	private void dispatchData() {
		String name = nameField.getText();
		String occupation = occupationField.getText();
		String ageCategory = (String)ageList.getSelectedValue();

		FormEvent event = new FormEvent(name, occupation, ageCategory);
		if (formSubmitListener != null) {
			formSubmitListener.formSubmitted(event);
		}

	}

	private void setupActionListeners() {
		// Setup action listeners
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispatchData();
			}
		});

		submitButton.addKeyListener(new KeyListener() {
			public void keyTyped(KeyEvent e) {
				// do nothing
			}

			public void keyReleased(KeyEvent e) {
				// do nothing
			}

			public void keyPressed(KeyEvent e) {
				if (e.getKeyChar() == KeyEvent.VK_ENTER) {
					dispatchData();
				}
			}
		});
	}

	private void drawBorder() {
		// Setup border for form panel
		Border insideBorder = BorderFactory.createTitledBorder("Add Person");
		Border outsideBorder = BorderFactory.createEmptyBorder(BORDER_TOP, BORDER_LEFT, BORDER_BOTTOM, BORDER_RIGHT);
		setBorder(BorderFactory.createCompoundBorder(outsideBorder, insideBorder));
	}

	private void setupGrid() {
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
		gbc.weighty = 10;

		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.anchor = GridBagConstraints.LINE_END;
		gbc.insets = new Insets(0, 0, 0, 10);
		add(new JLabel("Age group: "), gbc);

		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.insets = new Insets(0, 0, 0, 10);
		add(ageList, gbc);

		// FOURTH ROW
		gbc.weighty = 80;

		gbc.gridx = 1;
		gbc.gridy = 4;
		gbc.anchor = GridBagConstraints.FIRST_LINE_START;
		add(submitButton, gbc);
	}

	public void setFormSubmitListener(FormSubmitListener formSubmitListener) {
		this.formSubmitListener = formSubmitListener;
	}
}
