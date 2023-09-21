package component;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import events.CheckBoxEvent;
import interfaces.CheckBoxMenuListener;

@SuppressWarnings("serial")
public class MenuBar extends JMenuBar {
	private Menu fileMenu;
	private Menu windowMenu;
	private Menu showMenu;
	private CheckBoxMenuListener checkBoxMenuListener;

	public MenuBar() {
		// Menus
		fileMenu = new Menu("File", new String[] { "Export Data", "Import Data", "/", "Exit" });
		windowMenu = new Menu("Window", new String[] {});

		// Sub Menus
		showMenu = new Menu("Show", new String[] {});
		JCheckBoxMenuItem personFormCheckBox = new JCheckBoxMenuItem("Person Form");
		personFormCheckBox.setSelected(true);
		personFormCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(checkBoxMenuListener != null) {
					checkBoxMenuListener.CheckBoxToggled(new CheckBoxEvent(personFormCheckBox.isSelected()));
				}
			}
		});
		showMenu.addItem(personFormCheckBox.getName(), personFormCheckBox);
		windowMenu.add(showMenu);

		add(fileMenu);
		add(windowMenu);
	}
	
	public void setCheckBoxMenuListener(CheckBoxMenuListener checkBoxMenuListener) {
		this.checkBoxMenuListener = checkBoxMenuListener;
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
	
	public void addItem(String name, JMenuItem menuItem) {
		menuItems.put(name, menuItem);
		add(menuItems.get(name));
	}
	
	public void addActionListener(String menuName, ActionListener actionListener) {
		menuItems.get(menuName).addActionListener(actionListener);
	}
}
