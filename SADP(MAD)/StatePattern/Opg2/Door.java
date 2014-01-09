package Opg2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class Door {

	private DoorStateInterface closedState;
	private DoorStateInterface closingState;
	private DoorStateInterface openingState;
	private DoorStateInterface openState;
	private DoorStateInterface stayOpenState;

	private DoorStateInterface activeState;

	// private Timer openingTimer, closingTimer, timeoutTimer;

	public Door() {
		closedState = new ClosedState(this);
		closingState = new ClosingState(this);
		openingState = new OpeningState(this);
		openState = new OpenState(this);
		stayOpenState = new StayOpenState(this);
		activeState = closedState;
		// openingTimer = new Timer(2000, new openingTimerListener());
		// closingTimer = new Timer(3000, new ClosingTimerListner());
		// timeoutTimer = new Timer(4000, new TimeoutTimerListner());

	}

	public class openingTimerListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			activeState.complete();
		}
	}

	public class ClosingTimerListner implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			activeState.complete();
		}
	}

	public class TimeoutTimerListner implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			activeState.timeout();
		}
	}

	public void Click() {
		activeState.click();
	}

	public void setActiveState(DoorStateInterface activeState) {
		this.activeState = activeState;
	}

	public DoorStateInterface getClosedState() {
		return closedState;
	}

	public DoorStateInterface getClosingState() {
		return closingState;
	}

	public DoorStateInterface getOpeningState() {
		return openingState;
	}

	public DoorStateInterface getOpenState() {
		return openState;
	}

	public DoorStateInterface getStayOpenState() {
		return stayOpenState;
	}

	public DoorStateInterface getActiveState() {
		return activeState;
	}

	// public Timer getOpeningTimer() {
	// return openingTimer;
	// }
	//
	// public Timer getClosingTimer() {
	// return closingTimer;
	// }
	//
	// public Timer getTimeoutTimer() {
	// return timeoutTimer;
	// }

}
