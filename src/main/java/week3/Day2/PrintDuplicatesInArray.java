package week3.Day2;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class PrintDuplicatesInArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 14, 12, 13, 11, 15, 14, 18, 16, 17, 19, 18, 17, 20, 20, 15, 12,17 };
		List<Integer> list = new ArrayList<>();
		Set<Integer> dup = new TreeSet<>();

		for (int i : arr) {
			if (!list.contains(i)) {
				list.add(i);
			} else {
				dup.add(i);
			}
		}
		dup.stream().forEach(ip -> System.out.println(ip));

	}

}
