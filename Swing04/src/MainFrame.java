import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class MainFrame extends JFrame {

	private TextPanel textPanel;
	private JButton button;

	public MainFrame() {
		super("Hello World");
		
		setLayout(new BorderLayout());
		
		textPanel = new TextPanel();
		add(textPanel, BorderLayout.CENTER);
		
		button = new JButton("Say hello");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textPanel.append("Hello\n");
			}
		});
		add(button, BorderLayout.SOUTH);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(new Dimension(800, 600));
		setVisible(true);
	}
}
