import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import component.FormPanel;
import component.MenuBar;
import events.CheckBoxEvent;
import events.FormEvent;
import interfaces.FormSubmitListener;
import interfaces.CheckBoxMenuListener;
import interfaces.ExitListener;
import interfaces.MessageListener;

@SuppressWarnings("serial")
public class MainFrame extends JFrame {

	private TextPanel textPanel;
	private Toolbar toolbar;
	private FormPanel formPanel;
	private MenuBar menuBar;

	public MainFrame() {
		super("Hello World");

		setLayout(new BorderLayout());

		textPanel = new TextPanel();
		toolbar = new Toolbar();
		formPanel = new FormPanel();
		menuBar = new MenuBar();

		setupToolbar();
		setupFormPanel();
		setupMenu();

		add(textPanel, BorderLayout.CENTER);
		add(toolbar, BorderLayout.NORTH);
		add(formPanel, BorderLayout.WEST);
		setJMenuBar(menuBar);

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent event) {
				confirmExit();
			}
		});
		getContentPane().setBackground(Color.pink);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		Dimension size = new Dimension(800, 600);
		setSize(size);
		setMinimumSize(size);
		setVisible(true);
	}

	private void setupMenu() {
		menuBar.setCheckBoxMenuListener(new CheckBoxMenuListener() {
			public void CheckBoxToggled(CheckBoxEvent event) {
				textPanel.setVisible(event.isSelected());
			}
		});

		menuBar.setExitListener(new ExitListener() {
			public void ExitTriggered() {
				confirmExit();
			}
		});
	}

	private void confirmExit() {
		int result = JOptionPane.showConfirmDialog(this, "Exit application?", "Confirm exit",
				JOptionPane.CANCEL_OPTION);
		if (result == JOptionPane.OK_OPTION) {
			System.exit(0);
		}
	}

	private void setupToolbar() {
		toolbar.setMessageListener(new MessageListener() {
			public void messageEmmited(String message) {
				textPanel.append(message);
			}
		});
	}

	private void setupFormPanel() {
		formPanel.setFormSubmitListener(new FormSubmitListener() {
			public void formSubmitted(FormEvent event) {
				textPanel.clear();
				textPanel.append(event.getAllData());
			}
		});
	}
}
