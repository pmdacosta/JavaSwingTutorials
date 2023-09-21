package component;

import java.util.HashMap;
import java.util.Map;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

@SuppressWarnings("serial")
public class MenuBar extends JMenuBar {
	private Menu fileMenu;
	private Menu windowMenu;

	public MenuBar() {
		fileMenu = new Menu("File", new String[]{ "Export Data", "Import Data", "/", "Exit" });
		windowMenu = new Menu("Window", new String[]{});

		add(fileMenu);
		add(windowMenu);
	}

}

@SuppressWarnings("serial")
class Menu extends JMenu {
	private Map<String, JMenuItem> menuItems;

	public Menu(String name, String[] menuItemNames) {
		super(name);

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
