package Opg22;

import java.util.Observable;

public class Door extends Observable {

	// Current state bliver brugt til at holde kompositionen.
	private DoorState currentState;
	// Disse nederstående states bliver kun brugt til at holde fast i de
	// konkrete objekter, så vi ikke opretter nye objekter hele tiden.
	//
	private ClosedState closedState;
	private ClosingState closingState;
	private OpeningState openingState;
	private OpenState openState;
	private StayOpenState stayOpenState;

	public Door() {
		this.closedState = new ClosedState(this);
		this.closingState = new ClosingState(this);
		this.openingState = new OpeningState(this);
		this.openState = new OpenState(this);
		this.stayOpenState = new StayOpenState(this);
		this.currentState = closedState;

	}

	public void click() {
		currentState.click();
	}

	public void setCurrentState(DoorState currentState) {
		this.currentState = currentState;
		setChanged();
		notifyObservers();
	}

	public DoorState getCurrentState() {
		return currentState;
	}

	public ClosedState getClosedState() {
		return closedState;
	}

	public ClosingState getClosingState() {
		return closingState;
	}

	public OpeningState getOpeningState() {
		return openingState;
	}

	public OpenState getOpenState() {
		return openState;
	}

	public StayOpenState getStayOpenState() {
		return stayOpenState;
	}

}
