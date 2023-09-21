import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;

import component.FormPanel;
import component.MenuBar;
import events.CheckBoxEvent;
import events.FormEvent;
import interfaces.FormSubmitListener;
import interfaces.CheckBoxMenuListener;
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
		
		getContentPane().setBackground(Color.pink);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(new Dimension(800, 600));
		setVisible(true);
	}
	
	private void setupMenu() {
		menuBar.setCheckBoxMenuListener(new CheckBoxMenuListener() {
			public void CheckBoxToggled(CheckBoxEvent event) {
				textPanel.setVisible(event.isSelected());
			}
		});
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
