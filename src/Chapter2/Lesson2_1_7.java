package Chapter2;

public class Lesson2_1_7 {
    public static void main(String[] args) {
//        int minFromFour = (int) priceCalculation(double 14, int 11);
        System.out.println(priceCalculation(8.50, 2));
    }

    public static double priceCalculation(double price, int count) {
        //Твой код здесь
        return (price * count);

    }
}

/*Урок с кодом
Напишите публичный метод priceCalculation, который считает стоимость товара.
В метод передается цена товара (может быть дробной) и количество товара,
метод должен возвращать итоговую цену покупки.

Пример ввода: 8.50, 2
Пример вывода: 17.0

Требования:
Сигнатура метода должна быть: priceCalculation(double price, int count)*/
