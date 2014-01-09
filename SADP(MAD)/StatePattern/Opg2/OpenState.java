package Opg2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class OpenState implements DoorStateInterface {

	private Door door;
	private Timer timeoutTimer;

	public OpenState(Door door) {
		this.door = door;
		timeoutTimer = new Timer(4000, new openingTimerListener());
	}

	@Override
	public void click() {
		DoorStateInterface doorState = door.getStayOpenState();
		door.setActiveState(doorState);
		doorState.click();
		timeoutTimer.stop();

	}

	@Override
	public void complete() {
		timeoutTimer.restart();

	}

	@Override
	public void timeout() {
		// TODO Auto-generated method stub

	}

	@Override
	public String toString() {
		return "OPEN";
	}

	public class openingTimerListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			if (door.getActiveState().equals(door.getOpeningState())) {
				DoorStateInterface doorState = door.getClosingState();
				door.setActiveState(doorState);
				doorState.timeout();
			}
			timeoutTimer.stop();
		}

	}

}
