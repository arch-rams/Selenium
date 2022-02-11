package week3.Day1;

class AxisBank extends BankInfo{
 void deposit() {
	 
	 System.out.println("This is axisbank deposit");
 }
 
 public static void main(String[] args) {
	BankInfo ab = new AxisBank();
	ab.deposit();
	
}
}
