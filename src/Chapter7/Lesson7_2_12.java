package Chapter7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Lesson7_2_12 {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in).useDelimiter("[\\s\\p{Punct}]+");
//        Map<String, Integer> words = new TreeMap<>();
//        scanner.forEachRemaining(s -> words.merge(s.toLowerCase(), 1, Integer::sum));
//        words.entrySet().stream()
//                .sorted((o1, o2) -> o2.getValue().compareTo(o1.getValue()))
//                .limit(10)
//                .map(Map.Entry::getKey)
//                .forEach(System.out::println);
//    }

    //решение принятое ментором
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, "UTF-8"));
        reader.lines()
                .map(words -> words.toLowerCase().split("[^а-я|А-Я|a-z|A-Z|0-9]+"))
                .flatMap(Arrays::stream)
                .collect(Collectors.groupingBy(String::toString, TreeMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .limit(10)
                .forEach((line) -> System.out.println(line.getKey()));
    }
}


/*Урок с кодом
Напишите программу, читающую из System.in текст в кодировке UTF-8, подсчитывающую в нем частоту появления слов,
 и в конце выводящую 10 наиболее часто встречающихся слов.

Словом будем считать любую непрерывную последовательность символов, состоящую только из букв и цифр. Например,
 в строке "Мама мыла раму 33 раза!" ровно пять слов: "Мама", "мыла", "раму", "33" и "раза".

Подсчет слов должен выполняться без учета регистра, т.е. "МАМА", "мама" и "Мама" — это одно и то же слово.
Выводите слова в нижнем регистре.

Если в тексте меньше 10 уникальных слов, то выводите сколько есть.

Если в тексте некоторые слова имеют одинаковую частоту, т.е. их нельзя однозначно упорядочить только по частоте,
то дополнительно упорядочите слова с одинаковой частотой в лексикографическом порядке.

Задача имеет красивое решение через стримы без циклов и условных операторов. Попробуйте придумать его.

Пример ввода  1:
Мама мыла-мыла-мыла раму!

Пример вывода  1:
мыла
мама
раму

Пример ввода 2:
Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed sodales consectetur purus at faucibus.
 Donec mi quam, tempor vel ipsum non, faucibus suscipit massa. Morbi lacinia velit blandit tincidunt
 efficitur. Vestibulum eget metus imperdiet sapien laoreet faucibus. Nunc eget vehicula mauris, ac
 auctor lorem. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer vel odio nec mi tempor dignissim.

Пример вывода 2:
consectetur
faucibus
ipsum
lorem
adipiscing
amet
dolor
eget
elit
mi

Требования:
1. Должен быть метод public static void main(String[] args)
2. Программа должна читать данные с консоли
2. Программа должна писать данные в консоль*/