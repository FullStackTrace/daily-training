package demos.day2;

import java.util.Map.Entry;

public class Dictionary {

	private PrefixTree[] roots;
	
	public static Dictionary getInstance() {
		Dictionary dic = new Dictionary();
		dic.roots = new PrefixTree[52];
		int c = 65, idx = 0;
		for(;c <= 90; c++) {
			dic.roots[idx++] = new PrefixTree((char)c);
		}
		for(c = 97; c <= 122; c++) {
			dic.roots[idx++] = new PrefixTree((char)c);
		}
		return dic;
	}
	
	public void add(String word, String notes) {
		if(word == null || "".equals(word = word.trim())) return;
		for(PrefixTree node : roots) {
			if(node.getCharactor() == word.toCharArray()[0]) {
				node.add(word, notes);
			}
		}
	}
	
	public Entry<String, String> search(String word) {
		for(PrefixTree node : roots) {
			if(node.getCharactor() == word.toCharArray()[0]) {
				return node.search(word);
			} 
		}
		return null;
	}
}
