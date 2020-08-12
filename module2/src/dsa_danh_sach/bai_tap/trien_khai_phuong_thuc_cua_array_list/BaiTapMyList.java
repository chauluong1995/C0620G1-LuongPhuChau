package dsa_danh_sach.bai_tap.trien_khai_phuong_thuc_cua_array_list;

import java.util.Arrays;

public class BaiTapMyList<E> {
    private int size = 0;
    public static final int DEFAULT_CAPACITY = 10;
    Object[] data = new Object[DEFAULT_CAPACITY];
    //private E[] data = (E[]) new Object[DEFAULT_CAPACITY];

    public BaiTapMyList() {
    }

    public BaiTapMyList(int capacity) {
        Object[] data = new Object[capacity];
        //E[] data = (E[]) new Object[capacity];
    }

    public void add(int index, E element) {
        if (size >= data.length) {
            Object[] newData = new Object[size * 2 + 1];
            newData = Arrays.copyOf(data, newData.length);
            data = newData;
        }
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = element;
        size++;
    }

    public E remove(int index) {
        checkIndex(index);

        E element = (E) data[index];
        for (int j = index; j < size - 1; j++) {
            data[j] = data[j + 1];
        }
        data[size - 1] = null;
        size--;
        return element;
    }

    public int size() {
        return this.size;
    }

    @Override
    public E[] clone() {
        E[] temp = (E[]) (new Object[size / 2]);
        temp = (E[]) Arrays.copyOf(data, temp.length);
        data = temp;
        size = size / 2;
        return (E[]) data;
    }

    public boolean contains(E element) {
        for (int i = 0; i < size; i++) {
            if (element.equals(data[i])) {
                return true;
            }
        }
        return false;
    }

    public int indexOf(E element) {
        for (int i = 0; i < size; i++) {
            if (element.equals(data[i])) {
                return i;
            }
        }
        return -1;
    }

    public boolean add(E element) {
        if (size >= data.length) {
            Object[] newData = new Object[size + 1];
            newData = Arrays.copyOf(data, newData.length);
            data = newData;
        }
        data[size] = element;
        size++;
        return true;
    }

    public void ensureCapacity(int minCapacity) {
        if (data.length < minCapacity) {
            Object[] newData = new Object[minCapacity];
            newData = Arrays.copyOf(data, newData.length);
            data = newData;
        }
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException
                    ("index " + index + " out of bounds");
    }

    public E get(int index) {
        checkIndex(index);
        return (E) data[index];
    }

    public void clear() {
        data = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            result.append(data[i]);
            if (i < size - 1) result.append(", ");
        }
        return result.toString() + "]";
    }
}
