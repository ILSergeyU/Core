package Java0;

public class Lesson2_9_2 {
    public static void main(String[] args) {
        printArray(new int[]{2, 4, 6});
    }
    public static void printArray(int[] arr){
        for ( int i = 0; i< arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}


/*Урок с кодом
Создайте метод static void printArray(int[] arr), который принимает массив целых
чисел и выводит их в консоль, каждое с новой строки.

Пример ввода: [2,4,6]
Пример вывода:
                                2
                                4
                                6

Требования:
1. Метод должен принимать массив целых чисел
2. Метод не должен ничего возвращать
3. Метод должен выводить каждое число с новой строки*/