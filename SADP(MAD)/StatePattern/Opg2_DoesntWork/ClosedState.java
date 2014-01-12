package Opg2_DoesntWork;

public class ClosedState implements DoorStateInterface {

	private Door door;

	public ClosedState(Door door) {
		this.door = door;
	}

	@Override
	public void click() {
		door.setActiveState(door.getOpeningState());
		door.getOpeningTimer().restart();

	}

	@Override
	public void complete() {
		// TODO Auto-generated method stub

	}

	@Override
	public void timeout() {
		// TODO Auto-generated method stub

	}

	@Override
	public String toString() {
		return "CLOSED";
	}

}
