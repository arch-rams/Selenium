package com.seleniumProject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;

import week5.day1.BaseClassServiceNow;

public class TestWrite {
	
	public static void main(String[] args) {
		TestWrite tw = new TestWrite();
		tw.mtdToWrite();
	}

	public void mtdToWrite() {
		List<String> innerList = new ArrayList<>();
		List<String> innerList2 = new ArrayList<>();
		List<List<String>> outList = new ArrayList<>();
		
		innerList.add("EntryNo");
		innerList.add("IncidentNo");
		innerList.add("Status");
		
		
		innerList2.add("one");
		innerList2.add("INC0011105");
		innerList2.add("Created");
		
		outList.add(innerList);
		outList.add(innerList2);
		
		BaseClassServiceNow test = new BaseClassServiceNow();
		
		test.setData();
		String writeStatus;
		try {
			writeStatus = ExternalUtil.updateExcel(outList, test.fileName, test.sheetName);
			System.out.println(writeStatus);
			Assert.assertTrue(writeStatus.equalsIgnoreCase("Success"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		
	}
}
