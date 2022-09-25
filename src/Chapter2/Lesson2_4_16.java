package Chapter2;

import java.util.Arrays;

public class Lesson2_4_16 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(evenArray(8)));
    }
    public static int[] evenArray(int number) {
        int[] array = new int[number / 2];
        for (int i = 0, n = 2; i < array.length; n = n + 2, i++) {
            array[i] = n;
        }
        return array;
    }
}

/*Урок с кодом
Напишите метод evenArray который принимает целое число типа int и возвращает массив заполненный четными числами от 1 до этого числа.

Пример ввода: 8
Пример вывода: [2,4,6,8]

Требования:
1. Метод должен быть публичным.
2. Параметр должен иметь тип int.
3. Сигнатура метода должна быть: evenArray(int number)*/
