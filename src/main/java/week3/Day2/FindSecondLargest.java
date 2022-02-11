package week3.Day2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FindSecondLargest {

	public static void main(String[] args) {
	
		int[] data = { 3, 2, 11, 4, 6, 7,9,25 };
		List<Integer> list = new ArrayList<>();
		for(int i: data) {
			list.add(i);
		}
		
		Collections.sort(list);
		System.out.println(list.get((list.size())-2));
	}

}
