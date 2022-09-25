package Chapter2;

public class Lesson2_2_8 {
    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(4));
    }
    public static boolean isPowerOfTwo(int value) {
        //Твой код здесь
        return Integer.bitCount(Math.abs(value)) == 1;
    }
}
//https://www.youtube.com/watch?v=zXQuqY3WQtM
// Статический метод bitCount() из класса Integer, который возвращает количество бит в числе:

// Так как, числа степени двойки имеют в двоичном представлении только один знаковый бит
// (единицу), то для выполнения проверки нам достаточно оператора сравнения == и метода
// bitCount() из класса Integer, который возвращает количество бит в числе:

/*Урок с кодом
Реализуйте метод isPowerOfTwo, проверяющий, является ли заданное число по абсолютной величине степенью двойки.

Решать можно разными способами:

воспользовавшись одним удобным статическим методом из класса java.lang.Integer;
применив пару трюков из двоичной арифметики;
написав решение "в лоб" с циклом и условными операторами (можете вернуться к этой задаче после просмотра соответствующих уроков).
Пример ввода 1: 0
Пример возвращаемого значения 1: false

Пример ввода 2: 1
Пример возвращаемого значения 2: true

Пример ввода 3: -2
Пример возвращаемого значения 3: true

Требования:
1. Метод должен быть public.
2. Метод должен быть static.
3. Передаваемый параметр должен иметь тип int.*/