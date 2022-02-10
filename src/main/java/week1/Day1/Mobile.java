package week1.Day1;

import java.util.HashMap;
import java.util.Map;

public class Mobile {

	private long mobNum;
	private Map<String, Long> contactList;

	private boolean sendMsg(String name) {
		if (contactList.get(name) != null) {
			System.out.println(" Hai " + name + " Sent successfully");
			return true;
		} else {
			System.out.println("Msg sending failed");
			return false;
		}

	}

	private void setNum(long mobNum) {
		this.mobNum = mobNum;
		this.contactList = new HashMap<>();
	}

	public void makeCall(long num) {
		System.out.println(" Placing call to.." + num);
	}

	protected void saveContact(long num, String name) {
		contactList.put(name, num);
		System.out.println("Number saved successfully");
	}

	public static void main(String[] args) {

		Mobile num1 = new Mobile();
		Mobile num2 = new Mobile();

		num1.setNum(9854012156L);
		num2.setNum(9859012050L);

		num1.saveContact(9957748565L, "Parvathi");
		num1.saveContact(9969741565L, "Sankar");

		num1.makeCall(9859012050L);
		num1.sendMsg("Sankar");
		num1.sendMsg("Shiva");
	}

}
