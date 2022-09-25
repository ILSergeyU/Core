package Chapter6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Scanner;

public class Lesson6_2_15 {

    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
        //Scanner sc = new Scanner("1 2 3 4 5 6 7 8 9 10");
        Deque<String> dq = new ArrayDeque<>();

        for (int i = 0; sc.hasNext(); i++) {
            String n = sc.next();
            if (i % 2 != 0) {
                dq.addFirst(n);
            }
        }

        System.out.println(String.join(" ", dq));
    }

/*    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String temp;
        while ((temp = br.readLine()) != null) {
            String[] buf = temp.split(" ");
            for (int i = buf.length - 1; i >= 0; i--) {
                if (i % 2 != 0) System.out.print(buf[i] + " ");
            }
        }
    }*/
}

/*Урок с кодом
Напишите программу, которая прочитает из System.in последовательность целых чисел,
 разделенных пробелами, затем удалит из них все числа, стоящие на четных позициях,
 и затем выведет получившуюся последовательность в обратном порядке в System.out.

Все числа влезают в int. Позиции чисел в последовательности нумеруются с нуля.

Все import объявлены за вас.

Пример ввода: 1 2 3 4 5 6 7 8 9 10
Пример вывода: 10 8 6 4 2

Требования:
1. Необходимо наличие метода public static void main(String[] args)
2. Программа должна читать данные из консоли
3. Программа должна выводить текст в консоль*/