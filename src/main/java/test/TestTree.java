package test;

import demos.day2.Dictionary;

public class TestTree {

	public static void main(String[] args) {
		Dictionary dic = Dictionary.getInstance();
		
		dic.add("confirm", "ȷ��");
		dic.add("confirm", "ȷ��");
		dic.add("confirm", "ȷ��");
		dic.add("confirm", "ȷ��");
		dic.add("confirm", "ȷ��");
		dic.add("confirm", "ȷ��");
		dic.add("confirm", "ȷ��");

		dic.add("confirm", "ȷ��");
		dic.add("confirm", "ȷ��");
		dic.add("confirm", "ȷ��");
		dic.add("confirm", "ȷ��");
		dic.add("confirm", "ȷ��");
		dic.add("confirm", "ȷ��");
		dic.add("confirm", "ȷ��");
		dic.add("confirm", "ȷ��");
		dic.add("confirm", "ȷ��");
		dic.add("confirm", "ȷ��");
		dic.add("confirm", "ȷ��");
		
		
		System.out.println(1);
		System.out.println(dic.search("confirm"));
	}
}
