package Opg22;

public class StayOpenState extends DoorState {

	public StayOpenState(Door door) {
		super(door);
	}

	public void click() {
		door.setCurrentState(door.getClosingState());
		door.getCurrentState().resetTimer();
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Staying Open";
	}

}
