package week3.Day2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.collections4.CollectionUtils;

public class FindIntersection {
	int[] arr1 = { 3, 2, 11, 4, 6, 7 }, arr2 = { 1, 2, 8, 4, 9, 7 };

	public void usingArray() {
		System.out.println("Using Arrays");
		for (int i = 0; i < arr1.length; i++) {
			for (int j = i; j < arr2.length; j++) {
				if (arr1[i] == arr2[j]) {
					System.out.print(arr1[i]+ "\t");
				}
			}
			
		}
		System.out.println();
	}

	public void usingList() {
		List<Integer> list1 = new ArrayList<>(), list2 = new ArrayList<>();
		
		for(int i: arr1) {
			list1.add(i);
		}
		
		for(int i: arr2) {
			list2.add(i);
		}
		
		 {
			System.out.println("Using retainAll method");
			List<Integer> common = new ArrayList<>(list1);
			common.retainAll(list2);
			for(int i: common) {
				System.out.print(i + "\t");
			}
			System.out.println();
			
		} 
		 
		 {
			 System.out.println("Using Streams");
			 List<Integer>common1 = list1.stream().filter(elt ->list2.contains(elt)).collect(Collectors.toList());
			 for(int i: common1) {
					System.out.print(i + "\t");
				}
				System.out.println();
		 }
		 
		
		 {
			 System.out.println("Using Collection Utils");
			 List<Integer> common2 = new ArrayList<>(CollectionUtils.intersection(list1, list2));
			 for(int i: common2) {
					System.out.print(i + "\t");
				}
				System.out.println();
		 }
	}

	public static void main(String[] args) {
		FindIntersection test = new FindIntersection();
		test.usingArray();
		test.usingList();
	}
}
