package component;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import javax.swing.filechooser.FileFilter;

import Filters.PersonFilter;
import events.CheckBoxEvent;
import interfaces.CheckBoxMenuListener;
import interfaces.ExitListener;

@SuppressWarnings("serial")
public class MenuBar extends JMenuBar {
	private Menu fileMenu;
	private Menu windowMenu;
	private Menu showMenu;
	private CheckBoxMenuListener checkBoxMenuListener;
	private ExitListener exitListner;
	private JFileChooser fileChooser;

	public MenuBar() {
		fileChooser = new JFileChooser();
		fileChooser.addChoosableFileFilter(new PersonFilter());

		// Menus
		fileMenu = new Menu("File", new String[] { "Export Data", "Import Data", "/", "Exit" });
		fileMenu.setMnemonic(KeyEvent.VK_F);
		fileMenu.setItemMnemonic("Exit", KeyEvent.VK_X);
		fileMenu.setItemAccelerator("Exit", KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK | ActionEvent.SHIFT_MASK));
		fileMenu.addActionListener("Exit", new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(exitListner != null) {
					exitListner.ExitTriggered();
				}
			}
		});
		fileMenu.addActionListener("Import Data", new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(fileChooser.showOpenDialog(MenuBar.this) == JFileChooser.APPROVE_OPTION) {
					System.out.println(fileChooser.getSelectedFile());
				}
			}
		});
		fileMenu.addActionListener("Export Data", new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(fileChooser.showSaveDialog(MenuBar.this) == JFileChooser.APPROVE_OPTION) {
					System.out.println(fileChooser.getSelectedFile());
				}
			}
		});

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
	
	public void setExitListener(ExitListener exitListener) {
		this.exitListner = exitListener;
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
	
	public void addActionListener(String itemName, ActionListener actionListener) {
		menuItems.get(itemName).addActionListener(actionListener);
	}
	
	public void setItemMnemonic(String itemName, int Mnemonic) {
		menuItems.get(itemName).setMnemonic(Mnemonic);
	}

	public void setItemAccelerator(String itemName, KeyStroke keyStroke) {
		menuItems.get(itemName).setAccelerator(keyStroke);
	}
}
