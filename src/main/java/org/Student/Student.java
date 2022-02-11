package org.Student;

import org.department.Department;

public class Student extends Department {

	String firstName, lastName, stDept;
	int studID, colgCode;
	private String email;
	long mobNum;

	public Student(String firstName, String lastName, String dept, int studentID, int collCode) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.stDept = dept;
		this.studID = studentID;
		this.colgCode = collCode;
	}

	private void getStudentInfo(int ID, String email, long mob) {
		// TODO Auto-generated method stub
		this.mobNum = mob;
		System.out.println(ID + " " +email + " " + firstName);
		System.out.println("Mob Num: " +mobNum);
	}
	
	private void getStudentInfo(String email) {
		// TODO Auto-generated method stub
		this.email = email;
		System.out.println(email);
	}

	private void getStudentInfo() {

		System.out.println("Name is: ");
		studentName();
	}

	public void studentName() {
		String[] Name = new String[2];
		Name[0] = this.firstName;
		Name[1] = this.lastName;
		System.out.println("The student name is: " + Name[0] + " " + Name[1]);
	}

	public void studentDept() {
		System.out.print(this.firstName + " belongs to ");
		deptName(this.stDept);
	}

	public void studentId() {
		System.out.println("The student ID is:" + this.studID);
		studentDept();
		collegeCode(this.colgCode);
	}

	public static void main(String[] args) {

		Student s1 = new Student("Mani", "Megala", "CSC", 51155621, 511);
		s1.getStudentInfo();
		s1.getStudentInfo("something@emai.com");
		s1.getStudentInfo(s1.studID, s1.email, 98858521131L);
		s1.studentName();
		s1.studentId();
		System.out.println();
		Student s2 = new Student("Kundhavai", "karikalan", "IT", 23751995, 237);
		s2.studentName();
		s2.studentId();
	}

}
