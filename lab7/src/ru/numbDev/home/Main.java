package ru.numbDev.home;

import java.util.concurrent.CopyOnWriteArrayList;

public class Main {

    private final CopyOnWriteArrayList<Object> list = new CopyOnWriteArrayList<>();

    /**
     * Используя ExecutorService создать 2 потока, которые пишут в list.
     * В потоках, после каждого добавления, в конце метода вызывать Thread.sleep(3000)
     */
    public static void main(String[] args) {
        //ExecutorService и его методов
    }

}
