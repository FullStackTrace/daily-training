package demos.day2;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import common.ArraySet;

public class PrefixTree {

	private char charactor;
	private ArraySet<PrefixTree> children;
	private Map<String, String> words;

	public PrefixTree() {
		
	}
	
	public PrefixTree(char c) {
		this.charactor = c;
	}
	
	public void add(String word, String notes) {
		if(word == null || "".equals(word.trim())) return;
		char[] chars = word.toCharArray();
		int pointer = 0;
		if(chars[pointer++] == charactor) {
			if(pointer == chars.length) {
				this.putWord(chars, notes);
			} else {
				add(this.children, chars, pointer, notes);
			}
		}
	}
	
	private void add(ArraySet<PrefixTree> cs, char[] chars, int pointer, String notes) {
		if(pointer == (chars.length - 1)) {
			this.putWord(chars, notes);
		} else {
			boolean flag = true;
			if(cs != null && cs.size() > 0) {
				for(PrefixTree t : cs) {
					if(chars[pointer++] == t.charactor) {
						t.add(t.children, chars, pointer, notes);
						flag = false;
						break;
					}
				}
			}
			if(flag) {
				this.addIfNotExisits(this, chars, pointer, notes);
			}
		}
	}
	
	private void addIfNotExisits(PrefixTree t, char[] chars, int pointer, String notes) {
		if(t.children == null) t.children = new ArraySet<>(13);
		if(pointer == (chars.length - 1)) {
			this.makeAndAddWord(t, chars, pointer, notes);
		} else {
			this.makeChildAndAdd(t, chars, pointer, notes);
		}
	}
	
	/**
	 * 创建子节点并添加单词
	 * @param t
	 * @param chars
	 * @param pointer
	 */
	private void makeAndAddWord(PrefixTree t, char[] chars, int pointer, String notes) {
		PrefixTree p = new PrefixTree(chars[pointer]);
		p.putWord(chars, notes);
		if(t.children == null) t.children = new ArraySet<>(13);
		t.children.add(p);
	}
	
	/**
	 * 创建子节点并继续深入
	 * @param t
	 * @param chars
	 * @param pointer
	 */
	private void makeChildAndAdd(PrefixTree t, char[] chars, int pointer, String notes) {
		PrefixTree p = new PrefixTree(chars[pointer++]);
		if(t.children == null) t.children = new ArraySet<>(13);
		t.children.add(p);
		p.addIfNotExisits(p, chars, pointer, notes);
	}

	
	public Entry<String, String> search(String word) {
		if(word == null || "".equals(word.trim())) return null;
		char[] chars = word.toCharArray();
		int pointer = 0;
		if(this.charactor == chars[pointer++]) {
			return this.deepSearch(this, chars, pointer);
		}
		return null;
	}
	
	public Entry<String, String> deepSearch(PrefixTree t, char[] chars, int pointer) {
		if(pointer == chars.length) {
			return t.getEntry(chars, t.words.entrySet());
		}
		if(t.children == null) return null;
		for(PrefixTree ch : t.children) {
			if(ch.charactor == chars[pointer++]) {
				return ch.deepSearch(ch, chars, pointer);
			}
		}
		return null;
	}
	
	private Entry<String, String> getEntry(char[] chars, Set<Entry<String, String>> entrys) {
		for(Entry<String, String> entry : entrys) {
			if(new String(chars).equals(entry.getKey())) return entry;
		}
		return null;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + charactor;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PrefixTree other = (PrefixTree) obj;
		if (charactor != other.charactor)
			return false;
		return true;
	}

	private void putWord(char[] chars, String notes) {
		if(this.words == null) this.words = new HashMap<>(1, 1);
		this.words.put(new String(chars), notes);
	}
	
	public char getCharactor() {
		return charactor;
	}

	public void setCharactor(char charactor) {
		this.charactor = charactor;
	}

	public ArraySet<PrefixTree> getChildren() {
		return children;
	}

	public void setChildren(ArraySet<PrefixTree> children) {
		this.children = children;
	}

	public Map<String, String> getWords() {
		return words;
	}

	public void setWords(Map<String, String> words) {
		this.words = words;
	}
}
