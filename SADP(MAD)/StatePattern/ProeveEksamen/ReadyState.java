package ProeveEksamen;

public class ReadyState implements ColaAutomatStateI {

	private ColaAutomat automat;

	public ReadyState(ColaAutomat colaAutomat) {
		this.automat = colaAutomat;
	}

	@Override
	public void insertCoin() {
		System.out.println("You inserted some money. Current funds: " + automat.getCurrentMoney() + " kr");
		automat.setCurrentState(automat.getRecievingState());

	}

	@Override
	public void pushMoneyBackButton() {
		System.out.println("There is no money to be returned.");
	}

	@Override
	public void pushGiveColaButton() {
		System.out.println("A cola costs 12 kr. You have to insert money.");

	}

	@Override
	public void returnMoney() {
		System.out.println("I have no money in ReadyState");

	}

	@Override
	public void giveCola() {
		System.out.println("I have no money and thus cannot give cola in ReadyState");

	}

}
