package data;

public class EmploymentCategory {
	private String type;
	private int id;
	private static int availableId = 0;

	public EmploymentCategory(String name) {
		this.type = name;
		id = availableId++;
	}

	public String getName() {
		return type;
	}

	public String getId() {
		return String.valueOf(id);
	}

	public String toString() {
		return type;
	}
}