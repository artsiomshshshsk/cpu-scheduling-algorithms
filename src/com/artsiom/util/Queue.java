package com.artsiom.util;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Queue<E> extends ArrayList<E>{
    public Queue() {
        super();
    }

    public void push(E elem){
        super.add(elem);
    }

    public E pop(){
        if(super.size() <= 0) throw new NoSuchElementException();
        E elem = super.remove(0);
        return elem;
    }

    public E first(){
        return super.get(0);
    }
}
