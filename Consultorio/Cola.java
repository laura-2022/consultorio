package com.laurapestana.prg3.Consultorio;

public class Cola {
    private static final int CAPACITY = 100;
    private Paciente[] queue;
    private int size;
    private int front;
    private int rear;

    public Cola() {
        queue = new Paciente[CAPACITY];
        size = 0;
        front = 0;
        rear = -1;
    }

    public void enqueue(Paciente item) {
        if (size == CAPACITY) {
            throw new IllegalStateException("La cola está llena");
        }
        rear = (rear + 1) % CAPACITY;
        queue[rear] = item;
        size++;
    }

    public Paciente dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("La cola está vacía");
        }
        Paciente item = queue[front];
        front = (front + 1) % CAPACITY;
        size--;
        return item;
    }

    public Paciente peek() {
        if (isEmpty()) {
            throw new IllegalStateException("La cola está vacía");
        }
        return queue[front];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == CAPACITY;
    }

    public int size() {
        return size;
    }
}

