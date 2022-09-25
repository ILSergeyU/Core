package Chapter7;

import java.util.function.UnaryOperator;

public class Lesson7_1_7 {
    public static void main(String[] args) {
       // System.out.println(sqrt.apply(3));
    }

    public static UnaryOperator<Integer> sqrt(int i) {
        //Твой код здесь
        return  x -> x * x; //Ответ JM
    }
    public interface UnaryOperator<T> {
        T apply(T t);
    }
}

/*Урок с кодом
Напишите метод с названием sqrt, который возвращает реализацию функционального
 интерфейса UnaryOperator, который принимает целое число(тип int) и возвращает его квадрат.

Требования:
1. Должен быть метод public UnaryOperator sqrt()
2. Метод должен возвращать реализацию интерфейса UnaryOperator.
3. Реализация должна соответствовать условию*/