package com.zsy.util;

import java.util.HashMap;
import java.util.Map;

public class Maps {

	/**
	 * 此方法先要使用Builder接收，否则链式调用返回的是Object泛型的
	 * @param <K>
	 * @param <V>
	 * @return
	 */
	public static <K, V> HashMapBuilder<K, V> newHashMap() {
		return new HashMapBuilder<K, V>();
	}
	
	/**
	 * 创建时即确定泛型类型，此方法返回的是Map<k, v>类型的
	 * @param <K>
	 * @param <V>
	 * @param k
	 * @param v
	 * @return
	 */
	public static <K, V> HashMapBuilder<K, V> newHashMap(K k, V v) {
		return new HashMapBuilder<K, V>(k, v);
	}
	
	public static class HashMapBuilder<K, V> {
		Map<K, V> map;
		
		private HashMapBuilder() {
			this.map = new HashMap<K, V>();
		}
		
		private HashMapBuilder(K k, V v) {
			this.map = new HashMap<>();
			map.put(k, v);
		}
		
		public HashMapBuilder<K, V> put(K k, V v) {
			map.put(k, v);
			return this;
		}
		
		public Map<K, V> map() {
			return map;
		}
	}
}
