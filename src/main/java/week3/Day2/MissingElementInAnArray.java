package week3.Day2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MissingElementInAnArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,2,3,4,7,6,8,10,15,10,13,18,16,6};
		List<Integer> elts = new ArrayList<>();
		
		for(int i: arr) {
			elts.add(i);
		}
		Collections.sort(elts);
		
		int highestElt = elts.get(elts.size()-1);
		
		System.out.println("The missing elts are:");
		
		for(int i=1; i<=highestElt; i++) {
			if(!elts.contains(i)) {
				System.out.print(i + "\t");
			}
		}
	}

}
