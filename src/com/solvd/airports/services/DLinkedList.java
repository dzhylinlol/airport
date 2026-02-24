package com.solvd.airports.services;

public class DLinkedList<T> {

    private T value;
    private DNode<T> tail;
    private DNode<T> head;

    public DLinkedList() {
    }

    public DLinkedList(T value, DNode<T> tail, DNode<T> head) {
        this.value = value;
        this.tail = tail;
        this.head = head;
    }

    public void addToTail(T value) {
        DNode<T> newNode = new DNode<>(value, null);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.setNext(newNode);
            tail = newNode;
        }
    }

    public void removeFromTail() {
        DNode<T> current = head;

        if (head == null) {
            throw new RuntimeException("List is empty");
        }

        if (head.getNext() == null) {
            head = null;
            return;
        }

        while (current.getNext().getNext() != null) {
            current = current.getNext();
        }
        current.setNext(null);
    }

    public T getItem(int index) {
        if (head == null) {
            throw new RuntimeException("List is empty");
        }

        DNode<T> current = head;
        int counter = 0;

        while (current != null) {
            if (counter == index) {
                return current.getValue();
            }
            current = current.getNext();
            counter++;
        }
        throw new IndexOutOfBoundsException("You've reached the end of the list");
    }

    public void print() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        DNode<T> current = head;

        while (current != null) {
            System.out.print(current.getValue() + " ");
            current = current.getNext();
        }
        System.out.println();
    }

}
