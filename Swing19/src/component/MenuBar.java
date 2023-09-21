package component;

import java.util.HashMap;
import java.util.Map;

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
	private Map<String, JMenuItem> menuItems;

	public FileMenu() {
		super("File");

		String[] menuItemNames = { "Export Data", "Import Data", "/", "Exit" };
		menuItems = new HashMap<String, JMenuItem>();
		for (int i = 0; i < menuItemNames.length; i++) {
			if (menuItemNames[i].equals("/")) {
				// Add separator
				addSeparator();
			} else {
				menuItems.put(menuItemNames[i], new JMenuItem(menuItemNames[i]));
				add(menuItems.get(menuItemNames[i]));
			}
		}
	}
}

@SuppressWarnings("serial")
class WindowMenu extends JMenu {
	public WindowMenu() {
		super("Window");
	}
}

class MenuItem {
	String name;
	JMenuItem item;
	
	public MenuItem(String name) {
		this.name = name;
		item = new JMenuItem(name);
	}
}
