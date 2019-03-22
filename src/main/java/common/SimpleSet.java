package common;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class SimpleSet<E> implements Set<E> {
	
	private Object[] data;
	private int len = 0;
	private int currPointer = 0;
	private final int incWhenTooBig = 2048;
	private boolean isFull = false, hasNullValue = false;
	
	public SimpleSet() {
		this.data = new Object[12];
		this.len = 0;
	}
	public SimpleSet(int size) {
		if(size <=0 || size >= Integer.MAX_VALUE) throw new RuntimeException("size is too large or too small");
		this.data = new Object[size];
		this.len = size;
	}
	@Override
	public synchronized boolean add(E e) {
		this.ensureSize(currPointer + 1);
		return this.addOne(e);
	}

	@Override
	public synchronized boolean addAll(Collection<? extends E> col) {
		if(col == null) throw new NullPointerException();
		int num = 0;
		if((num = col.size()) == 0) return false;
		this.ensureSize(currPointer + num);
		boolean r = false;
		for(E e : col) {
			if(!r) {
				r = this.addOne(e);
			} else {
				this.addOne(e);
			}
		}
		return r;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean contains(Object arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(Object arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() {
		return currPointer + 1;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T[] toArray(T[] arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	private synchronized void ensureSize(int willSize) {
		if(willSize > len) {
			this.increase(willSize - len + 1);
		} else {
			if(this.isFull) {
				this.increase(0);
			}
		}
		
	}
	
	private synchronized void increase(int inc) {
		int newLen= 0;
		if(inc == 0) {
			if(data.length < this.incWhenTooBig) {
				inc = len / 2;
			} else {
				inc = len;
			}
		}
		if(len < Integer.MAX_VALUE && (newLen = len + inc) > Integer.MAX_VALUE) throw new RuntimeException("too big");
		data = Arrays.copyOf(data, newLen);
		this.len = newLen;
		this.isFull = false;
	}
	
	private synchronized boolean addOne(E e) {
		if(e == null) {
			if(!this.hasNullValue) {
				this.hasNullValue = true;
				data[++currPointer] = e;
				if(currPointer == len) this.isFull = true;
				return true;
			} else {
				return false;
			}
		} else {
			for(Object obj : data) {
				if(obj == e) return false;
				if(e.equals(obj)) return false;
				data[++currPointer] = e;
				if(currPointer == len) this.isFull = true;
				return true;
			}
		}
		return false;
	}
}
