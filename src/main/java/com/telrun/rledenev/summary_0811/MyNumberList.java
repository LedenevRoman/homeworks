package com.telrun.rledenev.summary_0811;

public class MyNumberList {
    /**
     *    // Спроектировать список, в который можно добавить до N элементов и который поддерживает их сумму. Если добавить
     *     // больше элементов, то они игнорируются.
     *     // Методы add/size/remove(index)/sum()
     */

    private final Number[] numbers;
    private final Integer capacity;
    private int size = 0;
    private long sum = 0;

    public MyNumberList(Integer capacity) {
        this.capacity = capacity;
        numbers = new Number[capacity];
    }

    public void add(Number number){
        if (size == capacity) {
            return;
        }
        numbers[size] = number;
        size++;
        sum += (long) number;
    }

    public Number remove(int index) {
        if (index < 0 || index > size - 1) {
            throw new IllegalArgumentException();
        }
        Number result = numbers[index];
        numbers[index] = null;
        System.arraycopy(numbers, index + 1, numbers, index, capacity - size--);
        sum -= (long) result;
        return result;
    }

    public Number sum() {
        return sum;
    }

    public int size(){
        return size;
    }
}
