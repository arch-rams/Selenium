package org.college;

public class College {

	private int collegeCode;

	protected void collegeCode(int colgCode) {
		this.collegeCode = colgCode;
		System.out.println("The college code is: " + this.collegeCode);
		collegeRank();
	}

	public void collegeRank() {
		if (collegeCode >= 200 && collegeCode < 500) {
			System.out.println("This is an A-Tier university");
			
		} else if (collegeCode >= 500 && collegeCode < 700) {
			System.out.println("This is a B-Tier university");

		} else if (collegeCode >= 700 && collegeCode < 900) {
			System.out.println("This is a C-Tier university");

		} else {
			System.out.println("College rank is not listed. Please consult with University Board");
		}

	}
}
