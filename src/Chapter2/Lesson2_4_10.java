package Chapter2;

public class Lesson2_4_10 {
}

/*Выберите правильный ответ
Что произойдет, если находясь на 12 строчке программы нажать step into?


public class Main {

    public static void main(String[] args) {
        int minFromFour = getMinFromFour(14, 11, 10, 15);
        System.out.println(minFromFour);
    }

    public static int getMinFromFour(int a, int b, int c, int d) {
        int firstPairResult = getMinFromTwo(a, b);
        int secondPairResult = getMinFromTwo(c, d);

        return getMinFromTwo(firstPairResult, secondPairResult);
    }

    public static int getMinFromTwo(int a, int b) {
        if (a > b) {
            return b;
        } else {
            return a;
        }
    }
}
Программа переместится в первую строчку метода main
>>>Программа переместится в первую строчку метода getMinFromTwo
Программа завершит свою работу
Программа переместится на следующую строчку метода getMinFromFour*/