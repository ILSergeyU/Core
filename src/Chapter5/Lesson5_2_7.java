package Chapter5;

import com.sun.org.apache.xalan.internal.xsltc.util.IntegerArray;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;


public class Lesson5_2_7 {
    public static void main(String[] args) throws IOException {
        InputStream stream = new ByteArrayInputStream(new byte[]{1, 2, 4, 10,});
        System.out.println(sumOfStream(stream));
    }

    public static int sumOfStream(InputStream inputStream) throws IOException {
        //твой код здесь
        int buff;
        int result = 0;
        while ((buff = inputStream.read()) != -1) {
            result += (byte) buff;
        }
        return result;
    }
}


/*Урок с кодом
Напишите метод int sumOfStream(InputStream inputStream), который принимает InputStream и возвращает сумму всех его элементов.

Пример ввода: 1, 2, 4, 10

Пример вывода: 17

Требования:
1. Метод должен быть публичным.
2. Параметр должен иметь тип InputStream.
3. Сигнатура метода должна быть: sumOfStream(InputStream inputStream)*/