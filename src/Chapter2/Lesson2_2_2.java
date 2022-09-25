package Chapter2;

public class Lesson2_2_2 {
    public static void main(String[] args) {
        System.out.println(charExpression(33));
    }

//    public static char charExpression(int a) { //что бы получить символ из кода
//        return (char) ('\\' + a);
//
//    }

    public static char charExpression(int a) { //что бы получить код символа
        return (char)('\\' + a);
    }

}

/*Урок с кодом
Реализуйте метод, который возвращает букву, стоящую в таблице UNICODE после символа "\" (обратный слэш) на расстоянии a.
В качестве примера написано заведомо неправильное выражение. Исправьте его.

Требования:
1. Сигнатура метода должна быть: charExpression(int a)*/
