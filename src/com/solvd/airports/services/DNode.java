package com.solvd.airports.services;

public class DNode<T> {

    private T value;
    private DNode<T> next;

    public DNode() {}

    public DNode (T value, DNode<T> next){
            this.value = value;
            this.next = next;
    }

    public T getValue() {
        return value;
    }
    public void setValue(T value) {
            this.value = value;
    }

    public DNode<T> getNext() {
        return next;
    }
    public void setNext(DNode<T> next) {
            this.next = next;
    }

}


