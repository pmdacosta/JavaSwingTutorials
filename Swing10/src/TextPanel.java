import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class TextPanel extends JPanel {
	private JScrollPane scrollPane;
	private JTextArea textArea;

	public TextPanel() {
		textArea = new JTextArea();
		textArea.setEditable(false);
		
		scrollPane = new JScrollPane(textArea);
		
		setLayout(new BorderLayout());
		
		add(scrollPane, BorderLayout.CENTER);
	}
	
	public void append(String str) {
		textArea.append(str);
	}
}
