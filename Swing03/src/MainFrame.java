import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class MainFrame extends JFrame {
	final private int FRAME_WIDTH = 800;
	final private int FRAME_HEIGHT = 600;
	final private Dimension FRAME_DIMENSION = new Dimension(FRAME_WIDTH, FRAME_HEIGHT);
	
	private JTextArea textArea;
	private JButton button;
	private LayoutManager layoutManager;
	
	
	public MainFrame() {
		// Set title
		super("Hello World");
		
		// Create text area
		textArea = new JTextArea();
		textArea.setEditable(false);

		button = new JButton("Click");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.append("Hello\n");
			}
		});
		
		layoutManager = new BorderLayout();
		setLayout(layoutManager);
		
		add(textArea, BorderLayout.CENTER);
		add(button, BorderLayout.SOUTH);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(FRAME_DIMENSION);
		setVisible(true);
	}

}
