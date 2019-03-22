package test;

import demos.day2.Dictionary;

public class TestTree {

	public static void main(String[] args) {
		Dictionary dic = Dictionary.getInstance();
		
		dic.add("confirm", "确认");
		dic.add("confirm", "确认");
		dic.add("confirm", "确认");
		dic.add("confirm", "确认");
		dic.add("confirm", "确认");
		dic.add("confirm", "确认");
		dic.add("confirm", "确认");

		dic.add("confirm", "确认");
		dic.add("confirm", "确认");
		dic.add("confirm", "确认");
		dic.add("confirm", "确认");
		dic.add("confirm", "确认");
		dic.add("confirm", "确认");
		dic.add("confirm", "确认");
		dic.add("confirm", "确认");
		dic.add("confirm", "确认");
		dic.add("confirm", "确认");
		dic.add("confirm", "确认");
		
		
		System.out.println(1);
		System.out.println(dic.search("confirm"));
	}
}
