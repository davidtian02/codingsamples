package com.datastructures.arraylist;

public class SCArrayList<E> {
    /**
     *  add(element)
     *  add(element, index)
     *  add(E... elements)
     *  get()
     *  remove(index)
     *  remove(element)
     *  contains
     *  indexOf
     *  size
     *  isEmpty
     *  copy/clone
     *  constructor(variable size)
     *  toArray(E[])
     *  equals()
     *  toString()
     */

    private static final int INITIAL_CAPACITY = 100;
    private E[] mInternalList = (E[]) new Object[INITIAL_CAPACITY];
    private int mNumberOfElements = 0;

    public void add(E element) { // can add null
        if (mNumberOfElements == mInternalList.length) {
            resize();
        }
        mInternalList[mNumberOfElements] = element;
        mNumberOfElements++;
    }

    public E remove(int index) {
        if (index < 0 || index >= mNumberOfElements) {
            throw new IndexOutOfBoundsException();
        } else if (index == mNumberOfElements - 1) {
            E temp = mInternalList[index];
            mNumberOfElements--;
            return temp;
        } else {
            E temp = mInternalList[index];
            while (index != mNumberOfElements) {
                mInternalList[index] = mInternalList[index+1];
                index++;
            }
            mNumberOfElements--;
            return temp;
        }
    }

    public boolean contains(E element) {
        for (int i=0; i<mNumberOfElements; i++) {
            E e = mInternalList[i];
            if (e == element) {
                return true;
            } else if (e == null || element == null) {
                return false;
            } else {
                if (e.equals(element)) {
                    return true;
                }
            }
        }
        return false;
    }

    public int size() {
        return mNumberOfElements;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public SCArrayList<E> clone() {
        SCArrayList<E> list = new SCArrayList<E>();
        for (int i=0; i<mNumberOfElements; i++) {
            list.add(list.get(i));
        }
        return list;
    }

    public E get(int index) {
        if (index < 0 || index >= mNumberOfElements) {
            throw new IndexOutOfBoundsException();
        }
        return mInternalList[index];
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        for (int i=0; i<mNumberOfElements; i++) {
            result.append(mInternalList[i] == null? "null" : mInternalList[i]).append(", ");
        }
        return result.append("]").toString();
    }

    private void resize() {
        int newLength = (mInternalList.length<<1);
        E[] newList = (E[]) new Object[newLength];
        for (int i=0; i<mNumberOfElements; i++) {
            newList[i] = mInternalList[i];
        }
        mInternalList = newList;
    }
}
