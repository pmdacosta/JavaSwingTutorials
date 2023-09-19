import java.awt.BorderLayout;
import java.awt.Font;

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
		textArea.setFont(new Font("DejaVu Sans Mono", Font.PLAIN, 20));
		
		scrollPane = new JScrollPane(textArea);
		
		setLayout(new BorderLayout());
		
		add(scrollPane, BorderLayout.CENTER);
	}
	
	public void append(String str) {
		textArea.append(str);
	}
	
	public void appendln(String str) {
		textArea.append(str + "\n");
	}
	
	public void appendKeyValuePair(String key, String value) {
		textArea.append(String.format("%-14s%-20s\n", key, value));
	}
	
	public void clear() {
		textArea.setText(null);
	}
}
