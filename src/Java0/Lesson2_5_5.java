package Java0;

//Не принимает ответ JM!!!!!!!!!!!!!!!Не решено!!
//Исправил должно работать  !!+++!!
public class Lesson2_5_5 {
    public static void main(String[] args) {
        System.out.println(determineAdult(-5));

       // determineAdult(-1);
    }

    public static boolean determineAdult(int age) {

        boolean i = false;
        if (age >= 18) {
            i = true;
        } else if (age < 18 && age > 0) {
            i = false;
        } else if (age < 0) {
            System.out.println("Ошибке! Введите правильный возраст.");
        }
        return i;

//        boolean i = false;
//        if (age >= 18) {
//            i = true;
//        } else if (age < 0) {
//            System.out.println("Ошибке! Введите правильный возраст.");
//        } else i = false;
//        return i;

    }
}

/*Урок с кодом
Создайте метод static boolean determineAdult(int age), который будет принимать возраст человека и возвращать логическое
 значение, равное true если он 18 и больше и false если он меньше 18, если переданное число меньше 0, метод должен
 вывести в консоль “Ошибка! Введите правильный возраст.” и вернуть false.

Требования:
1. Метод должен иметь модификаторы public static
2. Метод должен принимать в качестве параметра целое число
3. Метод должен возвращать логическое значение*/