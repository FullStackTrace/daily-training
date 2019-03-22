package test;

import demos.day2.Dictionary;

public class TestTree {

	public static void main(String[] args) {
		Dictionary dic = Dictionary.getInstance();
		
//		dic.add("confirm", "确认");
//		dic.add("darling", "亲爱的");
//		dic.add("dear", "亲爱的");
//		dic.add("lief", "亲爱的");
//		dic.add("loving", "亲爱的");
		dic.add("toots", "亲爱的");
//		dic.add("tootsie", "亲爱的");
		dic.add("tootsy", "亲爱的2");
		dic.add("tootsir", "亲爱的3");
		dic.add("tootsas", "亲爱的4");
		
		System.out.println(dic.search("tootsir"));
		System.out.println(dic.search("tootsas"));
		System.out.println(dic.search("toots"));
		System.out.println(dic.search("tootsy"));
	}
	
}
