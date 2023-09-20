import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

import component.FormPanel;
import events.FormEvent;
import interfaces.FormSubmitListener;
import interfaces.MessageListener;

@SuppressWarnings("serial")
public class MainFrame extends JFrame {

	private TextPanel textPanel;
	private Toolbar toolbar;
	private FormPanel formPanel;

	public MainFrame() {
		super("Hello World");
		
		setLayout(new BorderLayout());

		textPanel = new TextPanel();
		toolbar = new Toolbar();
		formPanel = new FormPanel();
		
		setupToolbar();
		setupFormPanel();
		
		add(textPanel, BorderLayout.CENTER);
		add(toolbar, BorderLayout.NORTH);
		add(formPanel, BorderLayout.WEST);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(new Dimension(800, 600));
		setVisible(true);
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
