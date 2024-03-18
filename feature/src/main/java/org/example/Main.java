package org.example;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        CustomArrayList<String> test = new CustomArrayList<>();

        test.add(null);
        test.add("1");
        test.add("2");
        test.add("3");




        System.out.println("++++++");
        test.remove("2");
        System.out.println(test.remove("1"));
        System.out.println("--------");

        for (int i = 0; i < test.size(); i++) {
            System.out.println(test.get(i));
        }


    }
}

class CustomArrayList<E> {

    private final int CAPACITY = 5;
    private int size = 0;
    private Object[] array;

    public CustomArrayList() {
        this.array = new Object[CAPACITY];
    }

    public void add(E element) {
        if (size >= CAPACITY) {
            increasingArray();
            array[size + 1] = element;
        }
        array[size] = element;
        size++;
    }

    // Удваивает массив и копирует данные
    private void increasingArray() {
        if (size == array.length) {
            int newSize = array.length * 2;
            Object[] newArray = new Object[newSize];
            System.arraycopy(array, 0, newArray, 0, array.length);
            array = newArray;
        }
    }

    public void add(int index, E element) {
        //    Проверяем, что индекс находится в пределах размера текущего массива
        if (index > CAPACITY || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        increasingArray();

        // Сдвигаем элементы, начиная с индекса вправо, чтобы освободить место для нового элемента
        if (size - index >= 0) {
            System.arraycopy(array, index, array, index + 1, size - index);
        }

        array[index] = element;
        size++;
    }

    public int size() {
        return size;
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            array[i] = null;
        }
        size = 0;
    }

    public E get(int index) {
        return (E) array[index];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void remove(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        System.arraycopy(array, index + 1, array, index, size - index - 1);
        size--;
    }


    public boolean remove(Object o) {
        for (int i = 0; i < size; i++) {
            if (o.equals(array[i])) {
                remove(i);
                return true;
            }
        }
        return false;
    }


    public boolean addAll(Collection<E> collection) {
        int sizeCollection = collection.size();


    }

}
