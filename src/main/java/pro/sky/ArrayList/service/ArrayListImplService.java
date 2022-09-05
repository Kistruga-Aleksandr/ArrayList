package pro.sky.ArrayList.service;

import org.springframework.stereotype.Service;
import pro.sky.ArrayList.Interface.StringList;

import java.util.Arrays;


@Service

public class ArrayListImplService implements StringList {
    private static final int STARTING_SIZE = 10;

    private final String[] strings;
    private int capacity;

    public ArrayListImplService() {
        strings = new String[STARTING_SIZE];
        capacity = 0;
    }

    public ArrayListImplService(int a) {
        if (a < 0) {
            throw new IllegalArgumentException("Разменр массива не должен быть отрицательным");
        }
        strings = new String[STARTING_SIZE];
        capacity = 0;
    }

    @Override
    public String add(String item) {
        return add(capacity, item);
    }

    @Override
    public String add(int index, String item) {
        if (index < 0 || index > capacity) {
            throw new IndexOutOfBoundsException("Не должен выходить за пределы массива");
        }
        if (capacity == strings.length) {
            throw new IllegalArgumentException("Массив полный!");
        }
        if (item == null) {
            throw new IllegalArgumentException("Не должен быть null");
        }
        if (index < capacity) {
            System.arraycopy(strings, index, strings, index + 1, capacity - index);
        }
        strings[index] = item;
        capacity++;
        return item;
    }

    @Override
    public String set(int index, String item) {
        if (index < 0 || index >= capacity) {
            throw new IndexOutOfBoundsException();
        }
        if (item == null) {
            throw new IllegalArgumentException("Не должен быть null");
        }
        return strings[index] = item;
    }

    @Override
    public String remove(String item) {
        int indexForRemove = indexOf(item);
        if (indexForRemove == -1) {
            throw new IllegalArgumentException("нет такого элемента");
        }
        return remove(indexForRemove);
    }

    @Override
    public String remove(int index) {
        if (index < 0 || index >= capacity) {
            throw new IndexOutOfBoundsException();
        }
        String removeIndex = strings[index];
        if (index + 1 < capacity) {
            System.arraycopy(strings, index + 1, strings, index, capacity - index - 1);
        }
        capacity--;
        strings[capacity] = null;
        return removeIndex;
    }

    @Override
    public boolean contains(String item) {
        return indexOf(item) != -1;
    }

    @Override
    public int indexOf(String item) {
        if (item == null) {
            throw new IllegalArgumentException("Не должен быть null");
        }
        for (int i = 0; i < capacity; i++) {
            if (strings[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(String item) {
        if (item == null) {
            throw new IllegalArgumentException("Не должен быть null");
        }
        for (int i = capacity - 1; i >= 0; i--) {
            if (strings[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String get(int index) {
        if (index < 0 || index >= capacity) {
            throw new IndexOutOfBoundsException();
        }

        return strings[index];
    }

    @Override
    public boolean equals(StringList otherList) {
        if (otherList == null || size() != otherList.size()) {
            return false;
        }
        for (int i = 0; i < capacity; i++) {
            if (!get(i).equals(otherList.get(i))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int size() {
        return capacity;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public void clear() {
        Arrays.fill(strings, null);
        capacity = 0;
    }

    @Override
    public String[] toArray() {
        String[] array = new String[capacity];
        System.arraycopy(strings, 0, array, 0, capacity);
        return array;
    }


}
