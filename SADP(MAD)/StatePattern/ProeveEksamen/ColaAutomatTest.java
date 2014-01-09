package ProeveEksamen;

public class ColaAutomatTest {

	public static void main(String[] args) {
		ColaAutomat ca = new ColaAutomat();
		ca.pushMoneyBackButton();
		ca.pushGiveColaButton();
		ca.insertCoin(5);
		ca.pushMoneyBackButton();
		ca.pushGiveColaButton();
		ca.insertCoin(7);
		ca.pushGiveColaButton();
		ca.insertCoin(12);
		ca.pushMoneyBackButton();
		ca.insertCoin(12);
		ca.pushGiveColaButton();
		ca.pushMoneyBackButton();
		ca.insertCoin(100);
		ca.pushGiveColaButton();

		ca.totalSoldColas();

//		for (int i = 0; i < 100; i++) {
//			ca.insertCoin(20);
//			ca.pushGiveColaButton();
//		}
//
//		ca.totalSoldColas();
	}

}
