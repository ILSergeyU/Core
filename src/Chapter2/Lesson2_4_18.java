package Chapter2;

import java.util.Arrays;

public class Lesson2_4_18 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(mergeArrays(new int[]{0, 2, 2}, new int[]{1, 3})));
      //  System.out.println(Arrays.toString(mergeArrays2(new int[]{0, 2, 2}, new int[]{1, 3})));
       // System.out.println(Arrays.toString(mergeArrays3(new int[]{0, 2, 2}, new int[]{1, 3})));

    }

    public static int[] mergeArrays(int[] a1, int[] a2) {
        int[] result = new int[a1.length + a2.length];
        System.arraycopy(a1, 0, result, 0, a1.length);
        System.arraycopy(a2, 0, result, a1.length, a2.length);
        Arrays.sort(result);
        return result;
    }

    public static int[] mergeArrays2(int[] a1, int[] a2) {
        int[] result = new int[a1.length + a2.length];
        int idxOne = 0;
        int idxTwo = 0;

        for (int i = 0; i < result.length; i++) {
            if (idxTwo >= a2.length || idxOne < a1.length && a1[idxOne] < a2[idxTwo]) {
                result[i] = a1[idxOne];
                idxOne++;
            } else {
                result[i] = a2[idxTwo];
                idxTwo++;
            }
        }

        return result;
    }
    public static int[] mergeArrays3(int[] a1, int[] a2) {
        //Сложение двух массивов
        int[] c = new int[a1.length + a2.length];
        int count = 0;
        for (int i = 0; i < a1.length; i++) {
            c[i] = a1[i];
            count++;
        }
        for (int j = 0; j < a2.length; j++) {
            c[count++] = a2[j];
        }
        /*Внешний цикл каждый раз сокращает фрагмент массива, так как внутренний цикл каждый раз ставит в конец
      фрагмента максимальный элемент*/
        for (int i = c.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                /*Сравниваем элементы попарно, если они имеют неправильный порядок, то меняем местами*/
                if (c[j] > c[j + 1]) {
                    int tmp = c[j];
                    c[j] = c[j + 1];
                    c[j + 1] = tmp;
                }
            }
        }
//        for (int i = 0; i < c.length; i++)
//            System.out.print(c[i] + " ");
//        System.out.println();                //  Выведет 0 1 2 2 3
        return c;                              //  Выведет [0, 1, 2, 2, 3]
    }
}

/*Урок с кодом
Реализуйте метод, сливающий два отсортированных по неубыванию массива чисел в один
отсортированный в том же порядке массив. Массивы могут быть любой длины, в том числе нулевой.

Предполагается, что вы реализуете алгоритм слияния, имеющий линейную сложность:
 он будет идти по двум исходным массивам и сразу формировать отсортированный результирующий
 массив. Так, чтобы сортировка полученного массива при помощи Arrays.sort() уже не требовалась.

К сожалению, автоматически это не проверить, так что это остается на вашей совести :)

Воспользуйтесь предоставленным шаблоном. Декларацию класса, метод main и обработку
 ввода-вывода добавит проверяющая система.

Пример ввода: {0, 2, 2} и {1, 3}
Пример вывода: {0, 1, 2, 2, 3}

Требования:
Cигнатура метода должна быть: mergeArrays(int[] a1, int[] a2)*/