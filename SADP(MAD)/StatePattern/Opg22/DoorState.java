package Opg22;

public abstract class DoorState {

	protected Door door;

	public DoorState(Door door) {
		this.door = door;
	}

	public void click() {
		throw new UnsupportedOperationException();
	}

	public void timeout() {
		throw new UnsupportedOperationException();
	}

	public void complete() {
		throw new UnsupportedOperationException();
	}
	
	public void resetTimer(){
		throw new UnsupportedOperationException();
	}
	
	public abstract String toString();

	protected Door getDoor() {
		return door;
	}
	
}
