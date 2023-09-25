package Filters;

import java.io.File;

import javax.swing.filechooser.FileFilter;

public class PersonFilter extends FileFilter {

	@Override
	public boolean accept(File file) {
		if(file.isDirectory()) return true;
		String name = file.getName();
		String extension = getFileExtension(name);
		System.out.println(extension);
		if(extension == null) return false;
		return extension.equals("per");
	}

	@Override
	public String getDescription() {
		return "Person database files (*.per)";
}
	
	private String getFileExtension(String name) {
		int dotIndex = name.lastIndexOf('.');
		
		if(dotIndex == -1 || dotIndex == name.length() - 1)
			return null;
		
		return name.substring(dotIndex+1, name.length());
		
	}

}
