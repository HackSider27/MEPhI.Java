package ru.numbDev.lab;

public class ArrayWrapper implements ArraySync {

    private final int[] array = new int[1000];

    @Override
    public boolean addItem(int item) {
        return false;
    } //заэддили и сортить(важно)

    @Override
    public void printArray() {

    }
}
