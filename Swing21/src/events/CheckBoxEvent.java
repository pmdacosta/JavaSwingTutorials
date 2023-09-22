package events;

public class CheckBoxEvent {
	private boolean selected;

	public CheckBoxEvent(boolean selected) {
		this.selected = selected;
	}
	
	public boolean isSelected() {
		return selected;
	}

}
