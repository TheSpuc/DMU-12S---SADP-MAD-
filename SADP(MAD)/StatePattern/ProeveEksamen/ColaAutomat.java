package ProeveEksamen;

public class ColaAutomat {

	private ColaAutomatStateI readyState;
	private ColaAutomatStateI recievingState;
	private ColaAutomatStateI buyCanceledState;
	private ColaAutomatStateI colaSoldState;

	private ColaAutomatStateI currentState;
	private int currentMoney;
	private int colasSold;

	public ColaAutomat() {
		this.readyState = new ReadyState(this);
		this.recievingState = new RecievingState(this);
		this.buyCanceledState = new BuyCancelledState(this);
		this.colaSoldState = new ColaSoldState(this);
		currentState = this.readyState;
		currentMoney = 0;
		colasSold = 0;
	}

	public void insertCoin(int i) {
		currentMoney += i;
		currentState.insertCoin();
		System.out.print("\n");
	}

	public void pushMoneyBackButton() {
		currentState.pushMoneyBackButton();
		currentState.returnMoney();
		System.out.print("\n");
	}

	public void pushGiveColaButton() {
		currentState.pushGiveColaButton();
		currentState.giveCola();
		System.out.print("\n");
	}

	public ColaAutomatStateI getCurrentState() {
		return currentState;
	}

	public void setCurrentState(ColaAutomatStateI currentState) {
		this.currentState = currentState;
	}

	public int getCurrentMoney() {
		return currentMoney;
	}

	public void setCurrentMoney(int currentMoney) {
		this.currentMoney = currentMoney;
	}

	public ColaAutomatStateI getReadyState() {
		return readyState;
	}

	public ColaAutomatStateI getRecievingState() {
		return recievingState;
	}

	public ColaAutomatStateI getBuyCanceledState() {
		return buyCanceledState;
	}

	public ColaAutomatStateI getColaSoldState() {
		return colaSoldState;
	}

	public void soldCola() {
		colasSold++;
	}

	public void totalSoldColas() {
		System.out.println(colasSold + " colas sold giving you: " + (colasSold * 12) + " kr");
	}

}
