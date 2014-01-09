package Opg1;

import java.util.EventListener;

public interface AgeErrorEventListener extends EventListener {

	public void ageOutOfRange(AgeErrorEvent event);

}
