package org.system;

public class Desktop extends Computer{

	static int size = 15;
	
	public void desktopSize() {
		System.out.println("The desktop resolution is: " +Desktop.size);
	}
	
	public static void main(String[] args) {
		Desktop dsk = new Desktop();
		dsk.computerModel();
		dsk.desktopSize();
	}
}
