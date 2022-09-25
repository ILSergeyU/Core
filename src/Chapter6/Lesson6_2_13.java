package Chapter6;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;


public class Lesson6_2_13 {
    public static void main(String[] args) {
        Set<Integer> set1 = new LinkedHashSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);

        Set<Integer> set2 = new LinkedHashSet<>();
        set2.add(0);
        set2.add(1);
        set2.add(2);

        System.out.println(symmetricDifference(set1, set2)); // {0, 3}
    }

    public static <T> Set<T> symmetricDifference(Set<? extends T> set1, Set<? extends T> set2) {

        Set<T> answer = new HashSet<>(set1);
        Set<T> help = new HashSet<>(set2);
        answer.removeIf(help::remove);
        answer.addAll(help);
        return answer;
    }

//   Замечание ментора - убрать цикл, решить методами коллекций
//    public static <T> Set<T> symmetricDifference(Set<? extends T> set1, Set<? extends T> set2) {
//        Set<T> set = new HashSet<>();
//        set.addAll(set1);
//        set.addAll(set2);
//
//        Iterator<T> it = set.iterator();
//        while (it.hasNext()) {
//            T item = it.next();
//            if (set1.contains(item) && set2.contains(item)) {
//                it.remove();
//            }
//        }
//
//        return set;
//    }
}

/*Урок с кодом
Реализуйте метод symmetricDifference, вычисляющий симметрическую разность двух множеств. Метод должен возвращать результат в виде нового множества. Изменять переданные в него множества не допускается.

Пример ввода: [1, 2, 3} и {0, 1, 2]
Пример вывода: [0, 3]

Требования:
1. должен быть метод public static Set symmetricDifference(Set set1, Set set2)
2. метод symmetricDifference не должен изменять исходные множества
3. метод symmetricDifference должен возвращать корректный результат*/