package Chapter6;

import java.io.*;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
//https://www.programiz.com/java-programming/library/hashmap/merge

public class Lesson6_2_14 {
    public static void main(String[] args) throws IOException {

        try {
            Reader reader = new FileReader("src//Chapter6//first");
            System.out.println(getSalesMap(reader));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Map<String, Long> getSalesMap(Reader reader) {
        Map<String, Long> map = new LinkedHashMap<>();
        Scanner scanner = new Scanner(reader);
        while (scanner.hasNext()) {
//            String str= scanner.next();
//            Long num = scanner.nextLong();
//            map.merge(str, num, Long::sum);
            map.merge(scanner.next(), scanner.nextLong(), Long::sum);
        }
        scanner.close();
        return map;
    }

//---------------------------------------------------
//Ментор не принял:  - убрать throws IOException. тело цикла упростить до одной строки

//    public static Map<String, Long> getSalesMap(Reader reader) /*throws IOException*/ {
//        Map<String, Long> resultHashMap = new LinkedHashMap<>();
//        Scanner scanner = new Scanner(reader);
//        while (scanner.hasNextLine()) {
//            StringBuilder stringBuilder = new StringBuilder(scanner.nextLine());
//            String stringValue = stringBuilder.substring(0, stringBuilder.indexOf(" "));
//            Long longValue = new Scanner(stringBuilder.substring(stringBuilder.indexOf(" ") + 1)).nextLong();
//            System.out.println(stringValue);
//            System.out.println(longValue);
//            if (!resultHashMap.containsKey(stringValue)) {
//                resultHashMap.put(stringValue, longValue);
//            } else {
//                resultHashMap.replace(stringValue, resultHashMap.get(stringValue), resultHashMap.get(stringValue) + longValue);
//            }
//        }
//       // reader.close();
//        return resultHashMap;
//    }

    //------------------------------------------------------------
// Решение от хлопца из Контакта JM не принял но оно рабочее.

//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        System.out.println(getSalesMap(reader));
//
//    }
//
//    public static Map<String, Long> getSalesMap(Reader reader) throws IOException {
//        Map<String, Long> map = new HashMap<>();
//        BufferedReader br = new BufferedReader(reader);
//        String line;
//        while (!(line = br.readLine()).equals("")) {
//            String name = line.trim().split(" ")[0];
//            Long salary = Long.parseLong(line.trim().split(" ")[1]);
//            if (map.containsKey(name)) {
//                map.put(name, map.get(name) + salary);
//            } else {
//                map.put(name, salary);
//            }
//        }
//        return map;
//    }
}

/*Урок с кодом
Магазину нужно сохранять информацию о продажах для каждого сотрудника.
 Напишите метод Map getSalesMap(Reader reader) который принимает Reader
 содержащий строки вида:

Алексей 3000
Дмитрий 9000
Антон 3000
Алексей 7000
Антон 8000
Метод должен получить все строки из Readera и заполнить и вернуть карту
 где ключом будет имя сотрудника, а значением сумма всех его продаж.

Пример ввода:


Алексей 3000
Дмитрий 9000
Антон 3000
Алексей 7000
Антон 8000
Пример вывода:
{Алексей=[10000], Дмитрий=[9000], Антон=[11000]}

Требования:
1. Должен быть метод public static Map<String, Long> getSalesMap(Reader reader)
2. Работа метода getSalesMap должна удовлетворять условию*/
