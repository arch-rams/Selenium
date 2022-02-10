package week3.Day2;

import java.util.LinkedHashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import com.google.common.primitives.Chars;

public class RemoveDuplicates {

		public static void main(String[] args) {		
			
//			Declare a String as PayPal India
			String pay = "PayPal India";
//			Convert it into a character array
			char[] arr = pay.toCharArray();
			
//			Declare a Set as charSet for Character
			Set<Character> charSet = new LinkedHashSet<>();
			
//			Declare a Set as dupCharSet for duplicate Character
			Set<Character> dupCharSet = new TreeSet<>();
			
//			Iterate character array and add it into charSet
			for(char c: arr) {
				
				if(charSet.contains(c)) {
					dupCharSet.add(c);
				}
				charSet.add(c);
			}
//			if the character is already in the charSet then, add it to the dupCharSet

//			Check the dupCharSet elements and remove those in the charSet
			for(char c: dupCharSet) {
				if(charSet.contains(c)) {
					charSet.remove(c);
				}
			}
//			Iterate using charSet
			Iterator<Character> iter = charSet.iterator();
//			Check the iterator variable isn't equals to an empty space
			while(iter.hasNext()) {
					char c = iter.next();
					if(c!=' ')
					System.out.print(c);
				
			}
//			print each character for charSet

		}

	
}
