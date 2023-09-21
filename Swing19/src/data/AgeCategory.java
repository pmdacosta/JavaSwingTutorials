package data;

public class AgeCategory {
	private int id;
	private String text;

	public AgeCategory(int id, String text) {
		this.id = id;
		this.text = text;
	}

	public String getId() {
		return String.valueOf(id);
	}

	public String getText() {
		return text;
	}

	public String toString() {
		return text;
	}
}
