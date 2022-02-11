package org.department;


import org.college.College;

public class Department extends College{


	public void deptName(String stDept) {
		switch (stDept) {
		case "CSC":{
			System.out.println("Bachelor of ComputerScience");
			break;
		}
		case "EEE":{
			System.out.println("Bachelor of Electric & Electronic Engg");
			break;
		}
		case "ECE":{
			System.out.println("Bachelor of Electronic & Communication Engg");
			break;
		}
		case "MECH":{
			System.out.println("Bachelor of Mechanincal Engg");
			break;
		}
		case "IT":{
			System.out.println("Bachelor of Information & Technology");
			break;
		}
		}
	}
}
