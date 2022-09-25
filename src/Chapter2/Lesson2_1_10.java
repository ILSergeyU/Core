package Chapter2;

public class Lesson2_1_10 {
    public static void main(String[] args) {
//        double minFromFour = doubleExpression(14, 11, 10);
        System.out.println(doubleExpression(3, 3, 8));
    }

    public static boolean doubleExpression(double a, double b, double c) {
        return Math.abs(a + b - c) < 1E-4;
    }
}
/*

/*Урок с кодом
Реализуйте метод, возвращающий ответ на вопрос: правда ли, что a + b = c ?
Допустимая погрешность – 0.0001 (1E-4)
Можно использовать класс Math и его методы. Класс Math доступен всегда,
импортировать его не надо.
В качестве примера написано заведомо неправильное выражение. Исправьте его.

Требования:
Метод должен иметь сигнатуру: doubleExpression(double a, double b, double c)*/
