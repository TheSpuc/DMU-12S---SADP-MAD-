package ProeveEksamen;

public class ColaSoldState implements ColaAutomatStateI {

	private ColaAutomat automat;

	public ColaSoldState(ColaAutomat colaAutomat) {
		this.automat = colaAutomat;
	}

	@Override
	public void insertCoin() {
		System.out.println("Cannot insert coin while I'm giving you cola");

	}

	@Override
	public void pushMoneyBackButton() {
		System.out.println("I'm currently giving you a cola and any spare change");

	}

	@Override
	public void pushGiveColaButton() {
		System.out.println("I'm currently doing that");

	}

	@Override
	public void returnMoney() {
		// TODO Auto-generated method stub

	}

	@Override
	public void giveCola() {
		System.out.println("Here's your cola ");
		System.out.println("Giving your money back");
		automat.setCurrentMoney(automat.getCurrentMoney() - 12);
		automat.soldCola();
		System.out.println("You got: " + automat.getCurrentMoney() + " kr back");
		automat.setCurrentState(automat.getReadyState());

	}

}
