package Chapter5;

public class Lesson5_3_9 {
    public static void main(String[] args) throws Exception {
        String s = "Ы";
        byte[] b = s.getBytes();
        for (int i = 0; i < b.length; i++) {
            System.out.print(((int) b[i] ^ -1 << 8) + " ");
        }
    }
}
/*Урок с вводом ответа
Какими байтами представляется символ 'Ы' в кодировке UTF-8?
Введите десятичные беззнаковые значения байт через пробел, например, 10 34 254.*/

//>>>208 171