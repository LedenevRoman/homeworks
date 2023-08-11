package com.telrun.rledenev.summary_0811;

public class MyNumberList {
    /**
     *    // Спроектировать список, в который можно добавить до N элементов и который поддерживает их сумму. Если добавить
     *     // больше элементов, то они игнорируются.
     *     // Методы add/size/remove(index)/sum()
     */

    private final Integer[] numbers;
    private final Integer capacity;
    private int size = 0;
    private int sum = 0;

    public MyNumberList(Integer capacity) {
        this.capacity = capacity;
        numbers = new Integer[capacity];
    }

    public void add(Integer number){
        if (size == capacity) {
            return;
        }
        numbers[size] = number;
        size++;
        sum += number;
    }

    public Integer remove(int index) {
        if (index < 0 || index > size - 1) {
            throw new IllegalArgumentException();
        }
        Integer result = numbers[index];
        numbers[index] = null;
        if (size == capacity) {
            size--;
            System.arraycopy(numbers, index + 1, numbers, index, size - index);
            numbers[size] = null;
        } else {
            System.arraycopy(numbers, index + 1, numbers, index, size - index);
            size--;
        }
        sum -= result;
        return result;
    }

    public int sum() {
        return sum;
    }

    public int size(){
        return size;
    }
}
