package Opg2;

public class TestDictionary {

	public static void main(String[] args) {
		Dictionary<Integer, String> map = new MapHashDictionary<Integer, String>();
		System.out.println(map.isEmpty());
		System.out.println(map.size());

		map.put(8, "hans");
		map.put(3, "viggo");
		System.out.println(map.isEmpty());
		System.out.println(map.size());

		System.out.println(map.get(8));

		map.put(7, "bent");
		map.put(2, "lene");
		System.out.println(map.isEmpty());
		System.out.println(map.size());
		System.out.println(map.remove(3));

		System.out.println(map.size());

		System.out.println(map.put(8, "Ida"));
		map.put(9, "jonas");
		map.put(10, "mark");
		map.put(11, "casper");
		map.put(12, "simon");
		map.put(14, "jesper");
		map.put(13, "jeppe");

	}
}
