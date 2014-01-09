package Opg4;

public class PostFixEvaluator_opg4 {

	public static void main(String[] args) {

		// Integer[] tal = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		// reverse(tal);
		// for (int i = 0; i < tal.length; i++) {
		// System.out.print(tal[i] + " ");
		// }

		System.out.println(evaluate("12 2 5 + - 4 * 2 /"));
		System.out.println(evaluate("1 2 + 3 * 6 + 2 3 + /"));
		System.out.println(evaluate("4 5 +"));
		System.out.println(evaluate("9 3 /"));
		System.out.println(evaluate("1 2 3 4 5 6 7 8 9 + + + + + + + +"));

	}

	public static int evaluate(String input) {
		String[] numbers = input.split(" ");
		StackI<Integer> stak = new ArrayStack<Integer>((numbers.length / 2) + 1);
		for (int i = 0; i < numbers.length; i++) {
			String s = numbers[i];
			if (isOperator(s)) {

				Integer i1 = stak.pop();
				Integer i2 = stak.pop();
				if (s.equals("+")) {
					stak.push(i2 + i1);
				} else if (s.equals("-")) {
					stak.push(i2 - i1);
				} else if (s.equals("*")) {
					stak.push(i2 * i1);
				} else {
					stak.push(i2 / i1);
				}

			} else {
				stak.push(Integer.parseInt(s));
			}
		}

		return stak.pop();

	}

	private static boolean isOperator(String s) {
		boolean result = false;
		if (s.equals("*") || s.equals("/") || s.equals("-") || s.equals("+")) {
			result = true;
		}
		return result;
	}

}
