package com.zsy.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Lists {

	@SafeVarargs
	public static <T> ListBuilder<T> newArrayList(T... t) {
		return new ListBuilder<T>(new ArrayList<>(Arrays.asList(t)));
	}
	
	@SafeVarargs
	public static <T> ListBuilder<T> newLinkedList(T... t) {
		List<T> l = new LinkedList<>();
		for(T tt : t) {
			l.add(tt);
		}
		return new ListBuilder<T>(l);
	}
	
	public static class ListBuilder<E> {
		List<E> list;
		
		private ListBuilder(List<E> list) {
			this.list = list;
		}
		public  ListBuilder<E> add(E e) {
			list.add(e);
			return this;
		}
		public List<E> list() {
			return this.list;
		}
	}
	
	public static void main(String[] args) {
		List<String> list = Lists.newArrayList("").list();
	}
}
