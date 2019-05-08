package com.github.funnygopher.adventofcode2018.day1;

import java.util.Iterator;

public class LoopingArrayIterator<T> implements Iterator<T> {

    private int currIndex = -1;
    private T[] arr;

    public LoopingArrayIterator(T[] arr) {
        this.arr = arr;
    }

    @Override
    public boolean hasNext() {
        return true;
    }

    @Override
    public T next() {
        this.currIndex++;

        // Reset the current index 
        if(arr.length <= this.currIndex) {
            this.currIndex = 0;
        }

        return arr[this.currIndex];
    }
}