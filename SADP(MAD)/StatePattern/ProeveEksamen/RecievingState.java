package ProeveEksamen;

public class RecievingState implements ColaAutomatStateI {

	private ColaAutomat automat;

	public RecievingState(ColaAutomat colaAutomat) {
		this.automat = colaAutomat;
	}

	@Override
	public void insertCoin() {
		System.out.println("You inserted more money. Current funds: " + automat.getCurrentMoney() + " kr");
	}

	@Override
	public void pushMoneyBackButton() {
		System.out.println("Giving you your money back");
		automat.setCurrentState(automat.getBuyCanceledState());

	}

	@Override
	public void pushGiveColaButton() {
		if (automat.getCurrentMoney() >= 12) {
			automat.setCurrentState(automat.getColaSoldState());
		} else {
			System.out.print("You need to input more money in order to get a cola.");
			System.out.println(" Current funds: " + automat.getCurrentMoney() + " kr");
		}

	}

	@Override
	public void returnMoney() {
		System.out.println("Cannot give money back in RecievingState");

	}

	@Override
	public void giveCola() {
		System.out.println("Cannot give cola in RecievingState");

	}

}
