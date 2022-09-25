package Chapter2;

/**
 * Checks if given <code>text</code> is a palindrome.
 *
 * @return <code>true</code> when <code>text</code> is a palindrome, <code>false</code> otherwise
 */
public class Lesson2_3_10 {
    public static void main(String[] args) {
        System.out.println(isPalindrome("Madam, I'm Adam!"));
    }

    public static boolean isPalindrome(String text) {
        text = text.replaceAll("[^a-zA-Z0-9]", "");
        StringBuilder strBuilder = new StringBuilder(new StringBuilder(text).reverse());

        return text.equalsIgnoreCase(strBuilder.toString());
    }
//    public static boolean isPalindrome(String text) {
//        text = text.replaceAll("\\W","");//удаляем все ненужное
//        StringBuilder strBuilder = new StringBuilder(text);
//        strBuilder.reverse(); //переворачиваем строку
//        String invertedText = strBuilder.toString();//присваиваем перевернутую строку
//
//        return text.equalsIgnoreCase(invertedText) ;//возвращаем сравнение двух строк вне зависимости от регистра
//    }
}


/*Урок с кодом
Реализуйте метод, проверяющий, является ли заданная строка палиндромом. Палиндромом называется строка, которая
читается одинаково слева направо и справа налево (в том числе пустая). При определении "палиндромности" строки
должны учитываться только буквы и цифры. А пробелы, знаки препинания, а также регистр символов должны игнорироваться.
Гарантируется, что в метод попадают только строки, состоящие из символов ASCII (цифры, латинские буквы, знаки препинания).
 Т.е. русских, китайских и прочих экзотических символов в строке не будет.
Для удаления из строки всех символов, не являющихся буквами и цифрами, можно воспользоваться регулярным выражением
"[^a-zA-Z0-9]".Найдите в классе String метод, выполняющий замену по регулярному выражению и воспользуйтесь им.

Воспользуйтесь предоставленным шаблоном. Декларацию класса, метод main и обработку ввода-вывода добавит проверяющая система.

Пример ввода 1: Was it a cat I saw?
Пример вывода 1: true
Пример ввода 2: A palindrome is a word, number, phrase, or other sequence of characters which reads the same backward
as forward, such as madam or racecar or the number 10801.
Пример вывода 2: false
Требования:
1. Должен быть доступный статический метод boolean isPalindrome(String text)
2. Работа метода должна удовлетворять условию*/