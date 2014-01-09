package Opg3_TemplateMethod;

import java.util.ArrayList;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		List<String> byer = new ArrayList<String>();
		byer.add("Holme");
		byer.add("Skåde");
		byer.add("Viby");
		byer.add("Beder");
		byer.add("Stautrup");
		byer.add("Engdal");
		byer.add("Forældreskolen");
		byer.add("Malling");

		SearchableList<String> search = new SearchableList<String>(byer);
		System.out.println("Found Malling?: " + search.search("Malling"));
		System.out.println("Found Riisskov?: " + search.search("Riisskov"));

		String[] byer2 = new String[8];
		byer2[0] = "Holme";
		byer2[1] = "Skåde";
		byer2[2] = "Viby";
		byer2[3] = "Beder";
		byer2[4] = "Stautrup";
		byer2[5] = "Engdal";
		byer2[6] = "Forældreskolen";
		byer2[7] = "Malling";

		SearchableArray<String> search2 = new SearchableArray<String>(byer2);
		System.out.println("Found Malling?: " + search2.search("Malling"));
		System.out.println("Found Riisskov?: " + search2.search("Riisskov"));

	}

}
