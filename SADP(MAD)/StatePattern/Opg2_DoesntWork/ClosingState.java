package Opg2_DoesntWork;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class ClosingState implements DoorStateInterface {

	private Door door;
	private Timer closingTimer;

	public ClosingState(Door door) {
		this.door = door;
		closingTimer = new Timer(3000, new ClosingTimerListner());
	}

	@Override
	public void click() {
		closingTimer.restart();

	}

	@Override
	public void complete() {
		// TODO Auto-generated method stub

	}

	@Override
	public void timeout() {
		// TODO Auto-generated method stub

	}

	public String toString() {
		return "CLOSING";
	}

	public class ClosingTimerListner implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			

		}

	}

}
