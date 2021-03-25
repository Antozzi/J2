package hw5;

import java.util.Arrays;

public class Main {
    private static final int size = 10000000;
    private static final int h = size / 2;

    public static void main(String[] args) {
        Main mainClass = new Main();
        mainClass.methodOne();
        mainClass.methodTwo();
    }

    private void methodOne() {
        System.out.println("Method One launched");
        float[] arr = new float[size];
        Arrays.fill(arr, 1.0f);
        long start = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        long end = System.currentTimeMillis();
        System.out.println(String.format("Method One accomplished. Exec time: %s", (end - start)));
    }

    private void methodTwo() {
        System.out.println("Method Two launched");
        float[] arr = new float[size];
        float[] arr1 = new float[h];
        float[] arr2 = new float[h];
        Arrays.fill(arr, 1.0f);
        long start = System.currentTimeMillis();
        System.arraycopy(arr, 0, arr1, 0, h);
        System.arraycopy(arr2, 0, arr, h, h);
        long split = System.currentTimeMillis();
        System.out.println(String.format("Array split time %s", (split - start)));

        Thread thread1 = new Thread(() -> methodTwoThreaded(arr1, 1));
        Thread thread2 = new Thread(() -> methodTwoThreaded(arr2, 2));
        thread1.start();
        thread2.start();

        long connect = System.currentTimeMillis();
        System.arraycopy(arr1, 0, arr, 0, h);
        System.arraycopy(arr2, 0, arr, h, h);
        long end = System.currentTimeMillis();
        System.out.println(String.format("Array merge time %s", String.valueOf(end - connect)));
        System.out.println(String.format("Method Two accomplished. Exec time: %s", (end - start)));
    }

    private synchronized void methodTwoThreaded(float[] arr, int number) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        long end = System.currentTimeMillis();
        System.out.println(String.format("Thread %d exec time: %s", number, (end - start)));
    }
}
