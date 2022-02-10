package week1.Day1;

public class Student {
	public String name;
	protected int rollNo;
	
	public void college(String name, int num) {
		String collegeName = "Anna University";
		
		this.name = name;
		this.rollNo = num;
		
		System.out.println("The student details are:");
		System.out.println("Name: " +name);
		System.out.println("RollNo: " +rollNo);
		System.out.println("CollegeName: " +collegeName);
		System.out.println();
	}
	
	public static void main(String[] args) {
		Student stud1 = new Student();
		Student stud2 = new Student();
		
		stud1.college("Akash", 233561);
		stud2.college("Pavithra", 233869);
	}

}
