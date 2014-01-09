package ProeveEksamen;

public class BuyCancelledState implements ColaAutomatStateI {

	private ColaAutomat automat;

	public BuyCancelledState(ColaAutomat colaAutomat) {
		this.automat = colaAutomat;
	}

	@Override
	public void insertCoin() {
		System.out.println("Cannot insert coin in BuyCancelledState");

	}

	@Override
	public void pushMoneyBackButton() {
		System.out.println("Cannot push money button in BuyCancelledState");

	}

	@Override
	public void pushGiveColaButton() {
		System.out.println("Cannot push cola button in BuyCancelledState");

	}

	@Override
	public void returnMoney() {
		System.out.println("Gave you " + automat.getCurrentMoney() + " kr back");
		automat.setCurrentMoney(0);
		automat.setCurrentState(automat.getReadyState());
	}

	@Override
	public void giveCola() {
		System.out.println("Cannot give cola in BuyCancelledState");

	}

}
