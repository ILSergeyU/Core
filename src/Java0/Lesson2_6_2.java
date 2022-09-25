package Java0;

public class Lesson2_6_2 {
    public static void main(String[] args) {
           System.out.println(determineRainfall(8,12));
    }

    public static long determineRainfall(double area, double rainfallAmount) {
        //Твой код здесь
        return (long)(area*2*1000000*rainfallAmount);
    }
}

/*Урок с кодом
Известно, что 1 мм осадков - это один литр воды, вылитый на квадратный метр за 12 часов.
 Напишите метод static long determineRainfall(double area, double rainfallAmount),
 который будет принимать площадь в квадратных километрах и осадки в мм и возвращать
 количество выпавших осадков за сутки на этой площади.

Пример ввода параметров: 8, 12
Пример возвращаемого значения: 192000000

Требования:
1. Метод должен иметь модификаторы public static
2. Метод должен принимать в качестве параметров два числа с плавающей точкой
3. Метод должен возвращать число типа long
4. Метод не должен ничего выводить в консоль*/