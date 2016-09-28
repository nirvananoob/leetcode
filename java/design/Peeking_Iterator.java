package design;

import java.util.Iterator;

/**
 * Given an Iterator class interface with methods: next() and hasNext(), design
 * and implement a PeekingIterator that support the peek() operation -- it
 * essentially peek() at the element that will be returned by the next call to
 * next().
 * 
 * Here is an example. Assume that the iterator is initialized to the beginning
 * of the list: [1, 2, 3].
 * 
 * Call next() gets you 1, the first element in the list.
 * 
 * Now you call peek() and it returns 2, the next element. Calling next() after
 * that still return 2.
 * 
 * You call next() the final time and it returns 3, the last element. Calling
 * hasNext() after that should return false.
 * 
 * Show Hint
 * 
 * @author kaizhang
 *
 */
public class Peeking_Iterator implements Iterator<Integer> {
	private Integer nextvalue;
	private Integer lastvalue;
	private Iterator<Integer> iter;

	public Peeking_Iterator(Iterator<Integer> iterator) {
		// initialize any member here.
		this.iter = iterator;
		this.nextvalue = iter.hasNext() ? iter.next() : null;
		this.lastvalue = null;
	}

	// Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
		return this.nextvalue;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
		this.lastvalue = this.nextvalue;
		this.nextvalue = iter.hasNext() ? iter.next() : null;
		return this.lastvalue;
	}

	@Override
	public boolean hasNext() {
		return this.nextvalue != null;
	}
}
