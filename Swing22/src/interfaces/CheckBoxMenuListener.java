package interfaces;

import java.util.EventListener;

import events.CheckBoxEvent;

public interface CheckBoxMenuListener extends EventListener {
	public void CheckBoxToggled(CheckBoxEvent event);
}
