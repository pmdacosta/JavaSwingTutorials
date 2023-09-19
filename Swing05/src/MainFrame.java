import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class MainFrame extends JFrame {

	private TextPanel textPanel;
	private Toolbar toolbar;

	public MainFrame() {
		super("Hello World");
		
		setLayout(new BorderLayout());
		
		textPanel = new TextPanel();
		add(textPanel, BorderLayout.CENTER);
		
		toolbar = new Toolbar();
		add(toolbar, BorderLayout.NORTH);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(new Dimension(800, 600));
		setVisible(true);
	}
}
