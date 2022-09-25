package Chapter2;

public class Lesson2_4_17 {
    public static void main(String[] args) {
        int[] strArray = new int[]{3, 5, 20, 8, 7, 3, 100};
        printOddNumbers(strArray);
    }

    public static void printOddNumbers(int[] arr) {
        StringBuilder stringBuilder = new StringBuilder();
        boolean first = true;
        for (int i = 0; i < arr.length; i++) {
            if (Math.abs(arr[i] % 2) == 1) {
                if (first) {
                    stringBuilder.append(arr[i]);
                    first = false;
                } else {
                    stringBuilder.append(",")
                            .append(arr[i]);
                }
            }
        }
        System.out.println(stringBuilder);
    }
}

/*Урок с кодом
Напишите метод printOddNumbers, который принимает массив и выводит в консоль только нечетные
числа из него, через запятую. Конец вывода должен перевести курсор на новую строку.

Пример ввода: [3,5,20,8,7,3,100]

Пример вывода: 3,5,7,3

Требования:
Сигнатура метода должна быть: printOddNumbers(int[] arr)*/