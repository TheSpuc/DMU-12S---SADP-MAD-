package Opg2;

public class StayOpenState implements DoorStateInterface {

	private Door door;

	public StayOpenState(Door door) {
		this.door = door;
	}

	@Override
	public void click() {
		DoorStateInterface doorState = door.getClosingState();
		door.setActiveState(doorState);
		doorState.click();

	}

	@Override
	public void complete() {
	}

	@Override
	public void timeout() {

	}

	@Override
	public String toString() {
		return "STAYING OPEN";
	}

}
