import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class MainFrame extends JFrame {
	private JTextArea textArea;
	private JButton button;

	public MainFrame() {
		super("Hello World");
		setLayout(new BorderLayout());
		
		textArea = new JTextArea();
		button = new JButton("Yes");
		
		add(textArea, BorderLayout.CENTER);
		add(button, BorderLayout.SOUTH);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(new Dimension(800, 600));
		setVisible(true);
	}
}
