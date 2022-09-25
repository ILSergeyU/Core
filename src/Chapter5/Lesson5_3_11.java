package Chapter5;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class Lesson5_3_11 {
    public static void main(String[] args) {
        byte[] array = {48, 49, 50, 51};
        Charset charset = StandardCharsets.UTF_8;
        InputStream inputStream = new ByteArrayInputStream(array);
        try {
            System.out.println(readAsString(inputStream, charset));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //не принял ментор, нужно без String
//    public static String readAsString(InputStream inputStream, Charset charset) throws IOException {
//        String retval;
//        Reader reader = new InputStreamReader(inputStream, charset);
//        StringWriter r = new StringWriter();
//        int b;
//        while ((b = reader.read()) != -1) {
//            r.write(b);
//        }
//        retval = r.toString();
//        return retval;
//    }
//------------------------------------------------------
    //ответ №2  StringWriter заменить на StringBuilder
//    public static String readAsString(InputStream inputStream, Charset charset) throws IOException {
//
//        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, charset);
//        StringWriter stringWriter = new StringWriter();
//        while (inputStreamReader.ready()) {
//            stringWriter.write(inputStreamReader.read());
//        }
//        return stringWriter.toString();
//    }

    //-----------------------------------------------------
    //ответ №3 Принял ментор
    public static String readAsString(InputStream inputStream, Charset charset) throws IOException {
        int in;
        Reader reader = new InputStreamReader(inputStream, charset);
        StringBuilder sb = new StringBuilder();
        while ((in = reader.read()) != -1) {
            sb.append((char) in);
        }
        return sb.toString();
    }
}

/*Урок с кодом
Реализуйте метод, который зачитает данные из InputStream и преобразует их в строку, используя заданную кодировку.

Пример:
InputStream последовательно возвращает четыре байта: 48 49 50 51.
Метод, вызванный для такого InputStream и кодировки ASCII, должен вернуть строку: "0123".

Требования:
1. Метод должен быть публичным.
2. Сигнатура метода должна быть: readAsString(InputStream inputStream, Charset charset)*/