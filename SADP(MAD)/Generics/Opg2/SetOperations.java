package Opg2;

import java.util.HashSet;
import java.util.Set;

public class SetOperations {

	public static void main(String[] args){
	Set<String> set1 = new HashSet<>();
	Set<String> set2 = new HashSet<>();
	set1.add("1");
	set1.add("2");
	set1.add("3");
	set2.add("3");
	set2.add("4");
	set2.add("5");
	System.out.println(union(set1, set2));
	System.out.println(difference(set1, set2));
	System.out.println(intersection(set1, set2));
	}

	public static <E> Set<E> union(Set<E> set1, Set<E> set2) {
		Set<E> union = new HashSet<>(set1);
		union.addAll(set2);
		return union;
	}

	public static <E> Set<E> difference(Set<E> set1, Set<E> set2) {
		Set<E> diff = new HashSet<>(set1);
		diff.removeAll(set2);
		return diff;
	}

	public static <E> Set<E> intersection(Set<E> set1, Set<E> set2) {
		Set<E> inter = new HashSet<>(set1);
		inter.retainAll(set2);
		return inter;
	}

}
