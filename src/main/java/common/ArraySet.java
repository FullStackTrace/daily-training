package common;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class ArraySet<E> implements Set<E> {

	private ArrayList<E> list;

	public ArraySet() {
		this.list = new ArrayList<>(13);
	}
	
	public ArraySet(int initialSize) {
		this.list = new ArrayList<>(initialSize);
	}
	
	@Override
	public int size() {
		return list.size();
	}

	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}

	@Override
	public boolean contains(Object o) {
		return list.contains(o);
	}

	@Override
	public Iterator<E> iterator() {
		return list.iterator();
	}

	@Override
	public Object[] toArray() {
		return list.toArray();
	}

	@Override
	public <T> T[] toArray(T[] a) {
		return list.toArray(a);
	}

	@Override
	public boolean add(E e) {
		if(list.contains(e))
			return false;
		else 
			list.add(e);
		return true;
	}
	
	public E add(int index, E element) {
		E e = list.get(index);
        list.add(index, element);
        return e;
    }

	@Override
	public boolean remove(Object o) {
		return list.remove(o);
	}

	
	@Override
	public boolean containsAll(Collection<?> c) {
		return list.containsAll(c);
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		return list.addAll(c);
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		return list.retainAll(c);
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		return list.removeAll(c);
	}

	@Override
	public void clear() {
		list.clear();
	}
	
	public int indexOf(Object o) {
		return list.indexOf(o);
	}
	
	public E get(int index) {
		return list.get(index);
	}
	
	public E remove(int index) {
		return list.remove(index);
	}

	@Override
	public String toString() {
		return list.toString();
	}
	
}
