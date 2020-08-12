package dsa_danh_sach.bai_tap.trien_khai_phuong_thuc_cua_array_list;

import java.util.Arrays;

public class BaiTapMyList<E> {
    private int size = 0;
    public static final int DEFAULT_CAPACITY = 10;
    private E[] data = (E[]) new Object[DEFAULT_CAPACITY];

    public BaiTapMyList() {
    }

    public BaiTapMyList(int capacity) {
        //E[] data = (E[]) new Object[capacity];
    }

    public void add(int index, E element) {
        if (size >= data.length) {
            E[] newData = (E[]) (new Object[size * 2 + 1]);
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

        E element = data[index];
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
        E[] e = (E[]) (new Object[size / 2]);
        e = Arrays.copyOf(data, e.length);
        data = e;
        size = size/2;
        return data;
    }

    public boolean contains(E o) {
        for (int i = 0; i < size; i++) {
            if (o.equals(data[i])) {
                return true;
            }
        }
        return false;
    }

    public int indexOf(E o) {
        for (int i = 0; i < size; i++) {
            if (o.equals(data[i])) {
                return i;
            }
        }
        return -1;
    }

    public boolean add(E e) {
        if (size >= data.length) {
            E[] newData = (E[]) (new Object[size + 1]);
            newData = Arrays.copyOf(data, newData.length);
            data = newData;
        }
        data[size] = e;
        size++;
        return true;
    }

    public void ensureCapacity(int minCapacity) {
        if (data.length < minCapacity) {
            E[] newData = (E[]) (new Object[minCapacity]);
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
        return data[index];
    }

    public void clear() {
        data = (E[]) new Object[DEFAULT_CAPACITY];
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
