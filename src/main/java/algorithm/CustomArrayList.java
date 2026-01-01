package algorithm;

import java.util.Arrays;

/**
 * ArrayList 직접 구현
 */
public class CustomArrayList<T> {
    private Object[] elements;
    private int currentSize;
    private final static int DEFAULT_CAPACITY = 2;

    public CustomArrayList() {
        this.elements = new Object[DEFAULT_CAPACITY];
        this.currentSize = 0;
    }

    public void add(T element) {
        if (currentSize == elements.length) {
            // 배열의 크기증가
            int newCapacity = elements.length + (elements.length >> 1); // 1.5배 증가
            elements = Arrays.copyOf(elements, newCapacity);
        }
        elements[currentSize++] = element;
    }

    public void remove(int index) {
        if (index < 0 || index >= currentSize) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + currentSize);
        }

        int numMoved = currentSize - index - 1; // 만약 currentSize가 5이고 index가 2라면 5 - 2 - 1 = 2 (3,4번 인덱스가 앞으로 당겨져야 함)
        if (numMoved > 0) {
            System.arraycopy(elements, index + 1, elements, index, numMoved);
        }
        elements[--currentSize] = null;
    }

    public T get(int index) {
        if (index < 0 || index >= currentSize) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + currentSize);
        }

        if (elements[index] != null) {
            return (T) elements[index];
        } else {
            throw new ClassCastException("Element at index " + index + " is not of type T");
        }
    }

    public int indexOf(T element) {
        for (int i=0; i<currentSize; ++i) {
            if (elements[i].equals(element)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        CustomArrayList<String> list = new CustomArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");

        System.out.println("Element at index 2: " + list.get(2)); // C
        System.out.println("Index of 'B': " + list.indexOf("B")); // 1

        list.remove(1); // Remove 'B'
        System.out.println("Index of 'B' after removal: " + list.indexOf("B")); // -1
    }
}


