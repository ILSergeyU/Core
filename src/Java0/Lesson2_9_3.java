package Java0;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Lesson2_9_3 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(evenArray(3)));


        //  System.out.println(Arrays.toString(fillArray(3)));

    }

    public static int[] evenArray(int number) {
        return IntStream.iterate(0, i -> i + 1)
                .limit(number).toArray();
    }

//    static int[] fillArray(int x) {
//        int[] masstmp = new int[x];
//        for (int i = 0; i < masstmp.length; ++i) {
//            masstmp[i] = i;
//        }
//        return masstmp;
//    }
}


/*Урок с кодом
Cоздайте метод static int[] fillArray(int x), который принимает целое число и возвращает массив целых чисел,
размером равный этому числу и заполненный числами от 0 до числа, меньшего на единицу, чем принятое.

Пример ввода параметра: 3
Пример возвращаемого массива: [0,1,2]

Требования:
1. Метод должен принимать целое число
2. Метод не должен ничего выводить в консоль
3. Метод должен возвращать массив целых чисел*/