package component;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

import data.AgeCategory;
import data.EmploymentCategory;
import data.FormData;
import events.FormEvent;
import interfaces.FormSubmitListener;

@SuppressWarnings("serial")
public class FormPanel extends JPanel {
	private final GridBagConstraints gbc = new GridBagConstraints();

	private final int BORDER_TOP = 5;
	private final int BORDER_BOTTOM = 5;
	private final int BORDER_LEFT = 5;
	private final int BORDER_RIGHT = 5;
	private final int COLUMNS = 10;

	private JTextField nameField;
	private JTextField occupationField;
	private JButton submitButton;
	private JList<AgeCategory> ageList;
	private JComboBox<EmploymentCategory> employmentComboBox;
	private JCheckBox usCitizenCheckBox;
	private JTextField taxField;
	private JLabel taxLabel;

	private FormSubmitListener formSubmitListener;

	public FormPanel() {
		setPreferredSize(new Dimension(300, getHeight()));
		setBackground(new Color(255, 255, 179));

		nameField = new JTextField(COLUMNS);
		occupationField = new JTextField(COLUMNS);
		submitButton = new JButton("SUBMIT");
		ageList = new JList<AgeCategory>();
		employmentComboBox = new JComboBox<EmploymentCategory>();
		usCitizenCheckBox = new JCheckBox();
		taxField = new JTextField(COLUMNS);
		taxLabel = new JLabel("Tax ID:");

		setupList();
		setupComboBox();
		setupCheckBox();
		setupActionListeners();
		drawBorder();
		layoutComponents();
	}

	private void setupCheckBox() {
		taxLabel.setEnabled(false);
		taxField.setEnabled(false);
		usCitizenCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean ticked = usCitizenCheckBox.isSelected();
				taxLabel.setEnabled(ticked);
				taxField.setEnabled(ticked);
			}
		});
	}

	private void setupComboBox() {
		String[] employmentCategory = { "Employed", "Self-employed", "Unemployed" };
		DefaultComboBoxModel<EmploymentCategory> employeeModel = new DefaultComboBoxModel<EmploymentCategory>();
		for (int i = 0; i < employmentCategory.length; i++) {
			employeeModel.addElement(new EmploymentCategory(employmentCategory[i]));
		}

		employmentComboBox.setModel(employeeModel);
	}

	private void setupList() {
		String elements[] = { "under 18", "18 to 65", "over 65" };
		DefaultListModel<AgeCategory> ageModel = new DefaultListModel<AgeCategory>();
		for (int i = 0; i < elements.length; i++) {
			ageModel.addElement(new AgeCategory(i, elements[i]));
		}

		// Set list values
		ageList.setModel(ageModel);

		// Set the list size
		ageList.setPreferredSize(new Dimension(110, 66));

		// Set the list's looks
		ageList.setBorder(BorderFactory.createEtchedBorder());
		Color backgroundColor = new Color(179, 179, 255);
		ageList.setBackground(backgroundColor);
		ageList.setSelectionBackground(backgroundColor.darker());

		// Set the default value for the list
		ageList.setSelectedIndex(0);

	}

	private void dispatchData() {
		FormData data = new FormData();
		data.setName(nameField.getText());
		data.setOccupation(occupationField.getText());
		data.setAgeCategory(ageList.getSelectedValue());
		data.setEmploymentCategory((EmploymentCategory) employmentComboBox.getSelectedItem());
		data.isUsCitizen(usCitizenCheckBox.isSelected());
		data.setTaxID(usCitizenCheckBox.isSelected() ? taxField.getText() : "");

		// Validate data
		if (!validateData(new String[] { data.getName(), data.getOccupation() })) {
			return;
		}

		FormEvent event = new FormEvent(data);
		if (formSubmitListener != null) {
			formSubmitListener.formSubmitted(event);
		}

	}

	private boolean validateData(String data[]) {
		for (int i = 0; i < data.length; i++) {
			if (data[i].isEmpty()) {
				return false;
			}
		}
		return true;
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

		// Setup a listener for the Enter Key to submit
		KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new KeyEventDispatcher() {
			public boolean dispatchKeyEvent(KeyEvent e) {
				// TODO Auto-generated method stub
				if (e.getKeyChar() == KeyEvent.VK_ENTER) {
					dispatchData();
					return true;
				}
				return false;
			}
		});
	}

	private void drawBorder() {
		// Setup border for form panel
		Border insideBorder = BorderFactory.createTitledBorder("Add Person");
		Border outsideBorder = BorderFactory.createEmptyBorder(BORDER_TOP, BORDER_LEFT, BORDER_BOTTOM, BORDER_RIGHT);
		setBorder(BorderFactory.createCompoundBorder(outsideBorder, insideBorder));
	}
	
	private void addLabel(JLabel label) {
		gbc.gridx = 0;
		gbc.anchor = GridBagConstraints.LINE_END;
		gbc.insets = new Insets(0, 0, 0, 10);
		add((JLabel) label, gbc);
	}

	private void addComponent(JComponent component) {
		gbc.gridx = 1;
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.insets = new Insets(0, 0, 0, 0);
		add(component, gbc);
	}

	private void layoutComponents() {
		class FormRow {
			public JLabel label;
			public JComponent component;

			public FormRow(JLabel label, JComponent component) {
				this.label = label;
				this.component = component;
			}

			public FormRow(String label, JComponent component) {
				this.label = new JLabel(label);
				this.component = component;
			}
		}

		FormRow[] components = { new FormRow("Name", nameField), new FormRow("Occupation", occupationField),
				new FormRow("Age", ageList), new FormRow("Age", ageList), new FormRow("Employment", employmentComboBox),
				new FormRow("US Citizen", usCitizenCheckBox), new FormRow(taxLabel, taxField) };

		setLayout(new GridBagLayout());
		gbc.fill = GridBagConstraints.NONE;
		gbc.weighty = 1;
		gbc.gridy = 0;

		for (int i = 0; i < components.length; i++) {
			gbc.gridy++;
			addLabel(components[i].label);
			addComponent(components[i].component);
		}

		gbc.gridy++;

		gbc.weighty = 80;
		gbc.gridx = 1;
		gbc.anchor = GridBagConstraints.FIRST_LINE_START;
		add(submitButton, gbc);
	}

	public void setFormSubmitListener(FormSubmitListener formSubmitListener) {
		this.formSubmitListener = formSubmitListener;
	}
}
