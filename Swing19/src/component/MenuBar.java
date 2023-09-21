package component;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

@SuppressWarnings("serial")
public class MenuBar extends JMenuBar {
	private FileMenu fileMenu;
	private WindowMenu windowMenu;
	
	public MenuBar() {
		fileMenu = new FileMenu();
		windowMenu = new WindowMenu();
		
		add(fileMenu);
		add(windowMenu);
	}

}

@SuppressWarnings("serial")
class FileMenu extends JMenu {
	private JMenuItem[] menuItems;

	public FileMenu() {
		super("File");
		
		String[] menuItemNames = {"Export Data", "Import Data", "Exit"};
		menuItems = new JMenuItem[menuItemNames.length];
		for (int i = 0; i < menuItemNames.length; i++) {
			menuItems[i] = new JMenuItem(menuItemNames[i]);
			add(menuItems[i]);
		}
	}
}

@SuppressWarnings("serial")
class WindowMenu extends JMenu {
	public WindowMenu() {
		super("Window");
	}
}