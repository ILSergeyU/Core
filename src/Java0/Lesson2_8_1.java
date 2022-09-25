package Java0;

public class Lesson2_8_1 {
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

/*Урок с кодом
Создайте метод public static int getMinFromTwo(int x, int y), который принимает
два целочисленных параметра и возвращает наименьший из них.

Создайте метод public static int getMinFromFour(int x, int y, int m, int n),
который принимает четыре целочисленных параметра и возвращает наименьший из них.

При том  второй метод должен использовать первый.

Требования:
1. Оба метода должны принимать целочисленные параметры
2. Оба метода должны возвращать целочисленные параметры
3. Второй метод должен использовать первый
4. Методы не должны ничего выводить в консоль*/