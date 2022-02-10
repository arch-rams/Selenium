package week1.Day2;

public class ConditionalLoops {

	public static void main(String[] args) {
		
		//print 1-100
		for(int i=1; i<=100; i++) {
			System.out.println(i);
		}
		
		//print odd in 1 - 100
		for(int i=1; i<=100; i++) {
			if(i%2!=0)
				System.out.println(i);
		}
		System.out.println();
		
		//print square of even num between 59-38
		for(int i=59; i>=38; i--) {
			if(i%2==0)
				System.out.println(i +"-> "+i*i);
		}
		System.out.println();
		
		System.out.println(printSum(5));
		
	}

	private static int printSum(int i) {
		// TODO Auto-generated method stub
		
		if(i>0)
		return i+printSum(i--);
		else
			return i;
	}
}
