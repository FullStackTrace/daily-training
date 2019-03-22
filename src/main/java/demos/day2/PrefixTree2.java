package demos.day2;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import common.ArraySet;

public class PrefixTree2 {
	private final char charactor;
	private ArraySet<PrefixTree2> children;
	private Map<String, String> words;

	public PrefixTree2(char c) {
		this.charactor = c;
	}

	public void add(String word, String note) {
		if (word == null || "".equals(word = word.replaceAll("\\s", "")))
			return;
		char[] chars = word.toCharArray();
		if (chars[0] == this.charactor) {
			this.add(chars, 0, note);
		}
	}

	public void add(char[] chars, int pointer, String note) {
		char c;
		if (this.charactor == (c = chars[pointer])) {
			if (pointer == chars.length - 1) {
				this.setWordAndNote(chars, note);
			} else {
				boolean flag = true;
				c = chars[++pointer];//取下一个char进行对比
				if (this.children != null) {
					for (PrefixTree2 pt : this.children) {
						if (c == pt.charactor) {
							pt.add(chars, pointer, note);
							flag = false;
							break;
						}
					}

				}
				if (flag) {
					this.addIfNotExisits(chars, pointer, note);// pointer 已经增加了1
				}
			}
		} else {
			this.addIfNotExisits(chars, pointer, note);//
		}
	}

	public void addIfNotExisits(char[] chars, int pointer, String note) {
		PrefixTree2 p = new PrefixTree2(chars[pointer]);
		if (pointer == chars.length - 1) {
			p.setWordAndNote(chars, note);
		} else {
			p.addIfNotExisits(chars, ++pointer, note);
		}
		if (this.children == null)
			this.children = new ArraySet<>(13);
		this.children.add(p);
	}

	public void setWordAndNote(char[] chars, String note) {
		if (this.words == null)
			this.words = new HashMap<>(1, 1);
		this.words.put(new String(chars), note);
	}

	public Entry<String, String> search(String word) {
		if (word == null || "".equals(word = word.replaceAll("\\s", "")))
			return null;
		char[] chars = word.toCharArray();
		int pointer = 0;
		return this.deepSearch(chars, pointer, chars.length);
	}

	private Entry<String, String> deepSearch(char[] chars, int pointer, int len) {
		char c = chars[pointer];
		if (pointer == 0 && len == 1) {
			if (this.charactor == c)
				return this.getEntry(chars, this.words.entrySet());
		} else {
			if (pointer == len - 1) {
				if (this.charactor == c) {
					return this.getEntry(chars, this.words.entrySet());
				}
			} else {
				if (this.children == null)
					return null;
				c = chars[++pointer];
				for (PrefixTree2 pt : this.children) {
					if (pt.charactor == c) {
						return pt.deepSearch(chars, pointer, len);
					}
				}
			}
		}
		return null;
	}

	private Entry<String, String> getEntry(char[] chars, Set<Entry<String, String>> entrys) {
		String k = new String(chars);
		for (Entry<String, String> entry : entrys) {
			if (k.equals(entry.getKey()))
				return entry;
		}
		return null;
	}

	@Override
	public String toString() {
		return "[charactor:" + charactor + ", children:" + children + ", words:" + words + "]";
	}

	public static void main(String[] args) {
		String[] words = { "alittle", "[ 'litl ]有些", "able", "['eibl] 能", "about", "[ 'əbaut ]关于,大约", "accountant",
				"[ə'kauntənt]会计", "active", "[ 'æktiv ]积极的;活跃的", "actor", "['æktə]男演员", "actress ", "['æktris]女演员" };
		PrefixTree2 pt2 = new PrefixTree2('a');
		for (int i = 0; i < words.length - 1; i += 2) {
			pt2.add(words[i], words[i + 1]);
		}

		for (int i = words.length - 2; i >= 0; i -= 2) {
			System.out.println(pt2.search(words[i]));
		}
		System.out.println(pt2);
	}
}
