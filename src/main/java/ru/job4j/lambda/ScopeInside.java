package ru.job4j.lambda;

import java.util.function.Supplier;

public class ScopeInside {

    public static void main(String[] args) {
        int[] number = {13, 42, 73};
        int[] total = {0};
        for (int num : number) {
            total[0] = add(() ->
                    total[0] += num);

        }
        System.out.print(total[0]);
    }

    private static Integer add(Supplier<Integer> calc) {
        return calc.get();
    }
}