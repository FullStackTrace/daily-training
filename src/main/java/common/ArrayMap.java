package common;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Ωˆπ©”È¿÷
 * @author Administrator
 *
 * @param <K>
 * @param <V>
 */
public class ArrayMap<K, V> implements Map<K, V> {

	private ArraySet<K> keys;
	private ArrayList<V> values;
	private int DEFAULT_CAP = 26;
	
	public ArrayMap() {
		keys = new ArraySet<>(DEFAULT_CAP);
		values = new ArrayList<>(DEFAULT_CAP);
	}
	
	public ArrayMap(int cap) {
		keys = new ArraySet<>(cap);
		values = new ArrayList<>(cap);
	}
	
	@Override
	public int size() {
		return keys.size();
	}

	@Override
	public boolean isEmpty() {
		return keys.isEmpty();
	}

	@Override
	public boolean containsKey(Object key) {
		return keys.contains(key);
	}

	@Override
	public boolean containsValue(Object value) {
		return values.contains(value);
	}

	@Override
	public V get(Object key) {
		return values.get(keys.indexOf(key));
	}

	@Override
	public V put(K key, V value) {
		int index = 0;
		if((index = keys.indexOf(key)) != -1) {
			V v = values.get(index);
			values.add(index, value);
			return v;
		} else {
			keys.add(key);
			values.add(value);
		}
		return null;
	}

	@Override
	public V remove(Object key) {
		int index = 0;
		if((index = keys.indexOf(key)) != -1) {
			keys.remove(index);
			return values.remove(index);
		}
		return null;
	}

	@Override
	public void putAll(Map<? extends K, ? extends V> m) {
		int size = m.size();
		List<K> ks = new ArrayList<>(size);
		List<V> vs = new ArrayList<>(size);
		for (Map.Entry<? extends K, ? extends V> e : m.entrySet()) {
            ks.add(e.getKey());
            vs.add(e.getValue());
        }
		keys.addAll(ks);
		vs.addAll(vs);
	}

	@Override
	public void clear() {
		keys.clear();
		values.clear();
	}

	@Override
	public Set<K> keySet() {
		return keys;
	}

	@Override
	public Collection<V> values() {
		return values;
	}

	@Override
	public Set<Entry<K, V>> entrySet() {
		return null;
	}

}
