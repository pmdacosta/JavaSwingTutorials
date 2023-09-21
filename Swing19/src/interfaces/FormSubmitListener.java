package interfaces;

import java.util.EventListener;

import events.FormEvent;

public interface FormSubmitListener extends EventListener {
	public void formSubmitted(FormEvent event);
}
