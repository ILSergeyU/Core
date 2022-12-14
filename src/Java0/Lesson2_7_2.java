package Java0;

import java.util.Scanner;

public class Lesson2_7_2 {
    public static void main(String[] args) {

        //Твой код здесь
        Scanner scan = new Scanner(System.in);
        System.out.println("Как вас зовут?");
        String name = scan.nextLine();
        System.out.println("Здравствуйте, " + name + "!");

    }
}


/*Урок с кодом
В методе main напишите программу, которая будет спрашивать имя пользователя и здороваться с ним.

При запуске программа должна выводить в консоль “Как вас зовут?”,после чего ожидать ввода имени пользователя.

После ввода имени программа должна выводить в консоль “Здравствуйте, {username}!” (Где вместо {username} имя пользователя) и завершаться.

Для принятия ответа от пользователя воспользуйтесь классом Scanner из стандартной библиотеки.

Подсказка: Про работу со сканером можете прочитать здесь:

https://metanit.com/java/tutorial/2.9.php

Пример ввода: Никита
Пример вывода:
                            Как вас зовут?
                            Здравствуйте, Никита!

Требования:
1. Реализация должна быть в методе main
2. При запуске, программа должна выводить в консоль "Как вас зовут?"
3. После ввода имени, программа должна выводить в консоль "Здравствуйте, {username}!"
4. При решении задачи, необходимо использовать класс Scanner*/