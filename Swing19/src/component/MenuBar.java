package component;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

@SuppressWarnings("serial")
public class MenuBar extends JMenuBar {
	private Menu fileMenu;
	private Menu windowMenu;
	private Menu showMenu;

	public MenuBar() {
		// Menus
		fileMenu = new Menu("File", new String[] { "Export Data", "Import Data", "/", "Exit" });
		windowMenu = new Menu("Window", new String[] {});

		// Sub Menus
		showMenu = new Menu("Show", new String[] { "Person Form" });
		windowMenu.add(showMenu);

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
	
	public void addActionListener(String menuName, ActionListener actionListener) {
		menuItems.get(menuName).addActionListener(actionListener);
	}
}
