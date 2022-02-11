package week3.Day1;

public class Automation extends MultipleLanguage implements TestTool, Language{

	@Override
	public void java() {
		// TODO Auto-generated method stub
		System.out.println("Selenium supports: ");
		for(String val: this.browsers) {
			System.out.print(val + ", ");
		}
		System.out.println();
		System.out.println("Java version:" +Language.version);
	}
	
	@Override
	public void Selenium() {
		// TODO Auto-generated method stub
		System.out.println("Interface method of Selenium");
	}
	
	public void python() {
		System.out.println("The version of python from implementation class is : 3.9.1");
		
	}
	
	public void pythonSuper() {
		super.python();
		System.out.println();
	}

	@Override
	public void ruby() {
		// TODO Auto-generated method stub
		System.out.println("Interface ruby abstract method given body in implementation class");
	}

	public static void main(String[] args) {
		Automation at = new Automation();
		at.Selenium();
		at.python();
		at.ruby();
		at.java();
		at.pythonSuper();
		
		MultipleLanguage ar = new  Automation();
		ar.python();
		System.out.println(ar.version);
	}
}
