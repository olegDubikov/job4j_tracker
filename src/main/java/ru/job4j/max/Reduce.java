package ru.job4j.max;

public class Reduce {
    private int[] arrays;

    public void to(int[] array) {
        arrays = array;
    }

    public void print() {
        for (int index = 0; index < arrays.length; index++) {
            System.out.println(arrays[index]);
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3};
        Reduce reduce = new Reduce();
        reduce.to(array);
        reduce.print();
    }
}
