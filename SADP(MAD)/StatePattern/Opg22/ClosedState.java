package Opg22;

public class ClosedState extends DoorState {

	public ClosedState(Door door) {
		super(door);
	}

	public void click() {
		door.setCurrentState(door.getOpeningState());
		door.getCurrentState().resetTimer();
	}

	@Override
	public String toString() {
		return "Closed";
	}

}
